package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.UserService;
import com.example.demo.vo.SbscVO;
import com.example.demo.vo.UserVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * localhost:8005 시 login 으로 redirect
     * @return
     */
    @GetMapping
    public String root() {
        return "redirect:/login";
    }

    /**
     * 로그인 폼
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 회원가입 폼
     * @return
     */
    @GetMapping("/signUp")
    public String signUpForm() {
        return "signup";
    }

    /**
     * 로그인 실패 폼
     * @return
     */
    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }

    /**
     * 회원가입 진행
     * @param userVo
     * @return
     */
    @PostMapping("/signUp")
    public String signUp(UserVO userVo) {
        userService.joinUser(userVo);
        return "redirect:/login";
    }

    /**
     * 유저 페이지
     * @param model
     * @param authentication
     * @return
     */
    @GetMapping("/user_access")
    public String userAccess(Model model, Authentication authentication) {
        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        UserVO userVo = (UserVO) authentication.getPrincipal();  //userDetail 객체를 가져옴
        model.addAttribute("mbrId", userVo.getMbrId());
        return "user_access";
    }
    
    @ResponseBody
    @GetMapping("/getUserAccount")
    public UserVO getUserAccount(Authentication authentication) {
    	UserVO userVo = (UserVO) authentication.getPrincipal();  
    	String mbrId = userVo.getMbrId();
    	return userService.getUserAccount(mbrId);
    }
    
}
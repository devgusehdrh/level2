package com.sparta.level2.controller;

import com.sparta.level2.dto.UserInfoDto;
import com.sparta.level2.dto.UserRequestDto;
import com.sparta.level2.security.UserDetailsImpl;
import com.sparta.level2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    //회원가입
    @GetMapping("/user/signup")
    public String signup(){
        return "signup";
    }

    // 로그인
    @GetMapping("/user/loginView")
    public String login() {
            return "login";
    }

    // 로그아웃
    @GetMapping("/user/logout")
    public String logout() {
        return "logout";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(@RequestBody UserRequestDto requestDto){
        userService.registerUser(requestDto);
        return "redirect:/user/loginView";
    }

    // 회원 관련 정보 받기
    @PostMapping("/user/userinfo")
    @ResponseBody
    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String username = userDetails.getUser().getUsername();

        return new UserInfoDto(username);
    }
}
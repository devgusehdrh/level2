package com.sparta.level2.service;

import com.sparta.level2.dto.UserRequestDto;
import com.sparta.level2.model.User;
import com.sparta.level2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void registerUser(UserRequestDto requestDto){
        String username = requestDto.getUsername();
        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()){
            throw new IllegalArgumentException("중복된 ID가 존재합니다");
        }

        String nickname = requestDto.getNickname();



        // 패스워드 암호화
        String pw = passwordEncoder.encode(requestDto.getPw());

        User user = new User(username,pw,nickname);
        userRepository.save(user);
    }
}


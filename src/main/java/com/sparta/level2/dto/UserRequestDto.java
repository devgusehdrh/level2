package com.sparta.level2.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDto {
    private Long id;
    private String username;
    private String pw;
    private String nickname;
}

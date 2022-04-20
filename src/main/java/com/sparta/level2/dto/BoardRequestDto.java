package com.sparta.level2.dto;

//import com.sparta.level2.model.User;
import lombok.Getter;

@Getter
public class BoardRequestDto {
    private Long id;
    private String content;
    private String like_count;
    private String nickname;
    private Long fileId;

//    private User user_id;
}

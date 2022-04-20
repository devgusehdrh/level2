package com.sparta.level2.dto;

import com.sparta.level2.model.Board;
import com.sparta.level2.model.User;
import lombok.Getter;

@Getter
public class LikeRequestDto {
    private Board post_id;
    private User user_id;
}

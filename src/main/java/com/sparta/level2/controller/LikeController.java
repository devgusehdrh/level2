package com.sparta.level2.controller;

import com.sparta.level2.dto.LikeRequestDto;
import com.sparta.level2.model.Like;
import com.sparta.level2.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class LikeController {

    private final LikeRepository likeRepository;

    //게시글 좋아요
    @ResponseBody
    @PostMapping("/api/posts/{post_id}/like")
    public Long isLike(@PathVariable Long post_id, @RequestBody LikeRequestDto requestDto){
        Like like = new Like(requestDto);
        likeRepository.save(like);

        return post_id;
    }

    //게시글 좋지 않아요
    @ResponseBody
    @DeleteMapping("/api/posts/{post_id}/like")
    public Long isLike(@PathVariable Long post_id){
        likeRepository.deleteById(post_id);

        return post_id;
    }
}

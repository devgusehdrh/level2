package com.sparta.level2.service;

import com.sparta.level2.dto.BoardRequestDto;
import com.sparta.level2.model.Board;
import com.sparta.level2.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long post_id, BoardRequestDto requestDto){
        Board board = boardRepository.findById(post_id).orElseThrow(
                () -> new NullPointerException("해당하는 글이 없습니다")
        );
        board.update(requestDto);
        return board.getId();
    }

}

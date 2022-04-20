package com.sparta.level2.model;



import com.sparta.level2.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Board extends Timestamp{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "post_id")
    private Long id;

    @Column(name = "content")
    private String content;
    @Column(name = "picture")
    private String picture;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "like_count")
    private String like_count;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user_id;

    @Column
    private Long fileId;

    public Board(BoardRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.nickname = requestDto.getNickname();
        this.fileId = requestDto.getFileId();

    }
    public Board(Optional<Board> board) {
        this.content = board.get().getContent();
        this.nickname = board.get().getNickname();
        this.fileId = board.get().getFileId();

    }

    public void update(BoardRequestDto requestDto){
        this.content = requestDto.getContent();
        this.nickname = requestDto.getNickname();
        this.fileId = requestDto.getFileId();

    }

}

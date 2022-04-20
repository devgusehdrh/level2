package com.sparta.level2.model;

import com.sparta.level2.dto.BoardRequestDto;
import com.sparta.level2.dto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToMany(mappedBy = "user_id")
    @Column(nullable = true,name = "user_id")
    private Long id;

    @Column(nullable = false,name = "username")
    private String username;

    @Column(nullable = false,name = "pw")
    private String pw;

    @Column(nullable = false,name = "nickname")
    private String nickname;


    public User(String username, String pw, String nickname) {
        this.username = username;
        this.pw = pw;
        this.nickname = nickname;
    }


}

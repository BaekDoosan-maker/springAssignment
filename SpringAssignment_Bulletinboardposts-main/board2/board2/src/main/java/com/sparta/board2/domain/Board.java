package com.sparta.board2.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.board2.controller.BoardController;
import com.sparta.board2.dto.BoardCheckRequestDto;
import com.sparta.board2.dto.BoardRequestDto;
import com.sparta.board2.service.BoardService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Board extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

   // @JsonIgnore  //password 안보이게
    @Column(nullable = false)
    private String password;

    public Board(String title, String username, String contents, String password) {
        this.title = title;
        this.username = username;
        this.contents = contents;
        this.password = password;
    }

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

    public void update(BoardRequestDto requestDto) {
        this.title= requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }
//    public void check(BoardCheckRequestDto boardCheckRequestDto){
//        this.password = boardCheckRequestDto.getPassword();
//    }

}

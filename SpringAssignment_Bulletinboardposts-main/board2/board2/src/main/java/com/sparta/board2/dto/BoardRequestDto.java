package com.sparta.board2.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardRequestDto { // 테이블의 데이터에 접근할때 완충역할
    private String username;
    private String contents;
    private String title;
    private String password;
}

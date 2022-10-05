package com.sparta.board2.controller;
import com.sparta.board2.domain.Board;
import com.sparta.board2.dto.BoardCheckRequestDto;
import com.sparta.board2.repository.BoardRepository;
import com.sparta.board2.dto.BoardRequestDto;
import com.sparta.board2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/api/boards/{id}")
    public Optional<Board> getBoard(@PathVariable Long id) {
        return boardRepository.findById(id);
    }

    @GetMapping("/api/boards")
    public List<Board> getBoard() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return boardRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }
    //@RequestBody:
    // http 통신을 할 때 post의 body에 data를 넣어서 보내겠다라는 의미로,
    // RequestBody에 SearchParam 값들을 매칭시켜서 달라는 의미이다.

    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

    //비밀번호 확인
    @PostMapping("/api/boards/{id}")
    public Boolean passwordCheck(@PathVariable Long id, @RequestBody BoardCheckRequestDto requestDto) {
        return boardService.passwordCheck(id, requestDto);
    }
// 데이터 하나 조회하기(findById)-이 데이터 하나를 유일하게 구분할 수 있는 PK로 ID의 의미를 생각하면 된다.
//@PathVariable 뒤에오는 변수가 주소{id}로 넘어가서 대입됨
//=> PutMapping의 대상을 유일한 하나로 지정해줌

    // 수정 확인
    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        boardService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }
}


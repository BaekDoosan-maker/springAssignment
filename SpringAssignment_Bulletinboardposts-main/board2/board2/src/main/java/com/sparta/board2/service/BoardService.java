package com.sparta.board2.service;
import com.sparta.board2.domain.Board;
import com.sparta.board2.dto.BoardCheckRequestDto;
import com.sparta.board2.repository.BoardRepository;
import com.sparta.board2.dto.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Objects;
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    @Transactional
    public void update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
    }
    @Transactional
    public boolean passwordCheck(Long id, BoardCheckRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지않는 글입니다.")
        );

        return board.getPassword().equals(requestDto.getPassword());
    }
}

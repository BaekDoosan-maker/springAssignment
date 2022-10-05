package com.sparta.board2;
import com.sparta.board2.domain.Board;
import com.sparta.board2.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Board2Application {
    public static void main(String[] args) {
        SpringApplication.run(Board2Application.class, args);
    }
    @Bean
    public CommandLineRunner demo(BoardRepository boardRepository) {
        return (args) -> {
          boardRepository.save(new Board("게시글제목입니다","백두산","게시글내용","1234"));
        };
    }
}
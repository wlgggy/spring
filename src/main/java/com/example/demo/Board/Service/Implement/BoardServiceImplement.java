package com.example.demo.Board.Service.Implement;

import com.example.demo.Board.Service.BoardService;
import com.example.demo.JPA.Repository.BoardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImplement implements BoardService {

    public final BoardRepository boardRepository;

    public BoardServiceImplement(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(boardRepository.findAll());
    }

}

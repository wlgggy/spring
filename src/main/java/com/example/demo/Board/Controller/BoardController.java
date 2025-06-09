package com.example.demo.Board.Controller;

import com.example.demo.JPA.Entity.BoardEntity;
import com.example.demo.JPA.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private final BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /*@GetMapping("/board")
    public List<BoardEntity> findAll() {
        return boardRepository.findAll();
    }*/

    /*@GetMapping("/board")
    public BoardEntity findById(@RequestParam(value = "idx", required = false, defaultValue = "1") int idx) {
        return boardRepository.findById(idx).orElse(null);
    }*/

    /*@PutMapping("/board")
    public BoardEntity updateBoard(@RequestBody BoardEntity updatedBoard) {
        return boardRepository.save(updatedBoard);
    }*/

    /*@DeleteMapping("/board")
    public void deleteBoard(@RequestParam(value = "idx", required = false, defaultValue = "1") int idx) {
        boardRepository.deleteById(idx);
    }*/

    @PostMapping("/board")
    public BoardEntity createBoard(@RequestBody BoardEntity newBoard) {
        return boardRepository.save(newBoard);
    }
}

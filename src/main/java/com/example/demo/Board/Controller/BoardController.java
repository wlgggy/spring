package com.example.demo.Board.Controller;

import com.example.demo.Board.Service.BoardService;
import com.example.demo.Board.VO.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<BoardVO>> getAllBoards() {
        return ResponseEntity.ok(boardService.findAll());
    }

    @GetMapping("/{no}")
    public ResponseEntity<BoardVO> getBoard(@PathVariable int no) {
        BoardVO board = boardService.findById(no);
        if (board == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(board);
    }


    @PostMapping
    public ResponseEntity<BoardVO> createBoard(@RequestBody BoardVO boardVO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(boardService.create(boardVO));
    }

    @PutMapping("/{no}")
    public ResponseEntity<BoardVO> updateBoard(@PathVariable int no, @RequestBody BoardVO boardVO) {
        return ResponseEntity.ok(boardService.update(no, boardVO));
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<Void> deleteBoard(@PathVariable int no) {
        boardService.delete(no);
        return ResponseEntity.noContent().build();
    }
}

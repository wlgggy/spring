package com.example.demo.Board.Service;

import com.example.demo.Board.VO.BoardVO;

import java.util.List;

public interface BoardService {
    BoardVO create(BoardVO vo);
    List<BoardVO> findAll();
    BoardVO findById(int no);
    BoardVO update(int no, BoardVO vo);
    void delete(int no);
}

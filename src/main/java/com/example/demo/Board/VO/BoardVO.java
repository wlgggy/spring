package com.example.demo.Board.VO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BoardVO {
    private int no;         // 게시글 번호 (Entity의 idx 대응)
    private String title;    // 제목
    private String content;  // 내용
    private LocalDate CreateDate;
    private LocalDate UpdateDate;
}

package com.example.demo.Board.VO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardVO {

    private int no;
    private String title;
    private String content;

    public BoardVO() {
    }

    public BoardVO(int no, String title, String content) {
        this.no = no;
        this.title = title;
        this.content = content;
    }

}

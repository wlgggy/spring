package com.example.demo.JPA.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "board")
public class BoardEntity {
    @Id

    @Column(name = "no")
    public int no;
    @Column(name = "title")
    public String title;
    @Column(name = "content")
    public String content;
}
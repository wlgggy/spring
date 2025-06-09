package com.example.demo.JPA.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "board")
@Getter
@Setter
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String title;
    private String content;
    private LocalDate date;
}

package com.example.demo.JPA.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
@EntityListeners(AuditingEntityListener.class)
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
    @CreatedDate
    private LocalDate CreateDate;
    @LastModifiedDate
    private LocalDate UpdateDate;
}

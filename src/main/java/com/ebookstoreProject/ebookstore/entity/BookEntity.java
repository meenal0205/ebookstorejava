package com.ebookstoreProject.ebookstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "booktable")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;
    private String name;
    private String Author;
    private String Genre;
    private String Description;
    private Integer Stock;
    private Integer Price;
    private String bookurl;


}

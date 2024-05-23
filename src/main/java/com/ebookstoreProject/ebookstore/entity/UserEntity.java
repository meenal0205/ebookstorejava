package com.ebookstoreProject.ebookstore.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;

@Entity
@Data
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;
    private String Username;
    private String Password;
    private HashMap<Integer,Integer> basket;
}

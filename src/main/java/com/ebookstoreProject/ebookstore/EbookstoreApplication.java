package com.ebookstoreProject.ebookstore;

import com.ebookstoreProject.ebookstore.Repository.UserRepository;
import com.ebookstoreProject.ebookstore.entity.UserEntity;
import com.ebookstoreProject.ebookstore.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.util.ArrayList;
import java.util.List;
@SpringBootApplication
public class EbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookstoreApplication.class, args);
	}


}

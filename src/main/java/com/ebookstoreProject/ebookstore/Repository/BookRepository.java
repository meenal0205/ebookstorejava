package com.ebookstoreProject.ebookstore.Repository;

import com.ebookstoreProject.ebookstore.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
public interface BookRepository extends  JpaRepository<BookEntity,Integer> {

}

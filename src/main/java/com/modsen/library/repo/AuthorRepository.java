package com.modsen.library.repo;

import com.modsen.library.model.book.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNameAndSurnameAndParentName(String name,
                                                       String surname,
                                                       String parentName);
}
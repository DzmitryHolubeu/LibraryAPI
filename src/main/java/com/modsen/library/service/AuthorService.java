package com.modsen.library.service;

import com.modsen.library.exception.ExistsException;
import com.modsen.library.model.book.Author;
import com.modsen.library.repo.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
    @Value("${EXISTED}") private String existed_message;

    private static final String s = "%s %s %s";

    private final AuthorRepository authorRepository;

    public Author save(Author author) {
        String fullName = String.format(s, author.getName(), author.getSurname(), author.getParentName());

        Optional<Author> authorByDB = authorRepository
                .findByNameAndSurnameAndParentName(author.getName(),
                        author.getSurname(),
                        author.getParentName());
        if (authorByDB.isPresent()) {
            throw new ExistsException(String.format(existed_message, fullName));
        }
        return authorRepository.save(author);
    }
}
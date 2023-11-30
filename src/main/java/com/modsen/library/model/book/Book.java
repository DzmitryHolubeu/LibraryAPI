package com.modsen.library.model.book;

import com.modsen.library.model.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Setter @Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Book extends AbstractEntity {
    private String ISBN;
    private String title;
    private String description;

    @OneToMany
    private List<Author> authors;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Genre> genres;

    @Enumerated(value = EnumType.STRING)
    private BookStatus bookStatus;
}
package com.modsen.library.model.book;

import com.modsen.library.model.AbstractEntity;
import com.modsen.library.model.book.Book;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Journal extends AbstractEntity {
    private LocalDate dateOfGetBook;
    private LocalDate dateOfReturnBook;

    @OneToOne
    private Book book;
}
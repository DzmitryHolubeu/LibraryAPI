package com.modsen.library.mapper;


import com.modsen.library.dto.book.BookDto;
import com.modsen.library.dto.book.UpdatedBookDto;
import com.modsen.library.model.book.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book dtoToBook(BookDto dto);
    BookDto bookToDto(Book book);

    Book updatedDtoToBook(UpdatedBookDto dto);
}
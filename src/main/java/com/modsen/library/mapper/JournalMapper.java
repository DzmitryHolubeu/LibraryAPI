package com.modsen.library.mapper;

import com.modsen.library.dto.journal.JournalDto;
import com.modsen.library.model.book.Journal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JournalMapper {
    JournalMapper INSTANCE = Mappers.getMapper(JournalMapper.class);

    Journal dtoToJournal(JournalDto dto);
    JournalDto journalToDto(Journal journal);
}
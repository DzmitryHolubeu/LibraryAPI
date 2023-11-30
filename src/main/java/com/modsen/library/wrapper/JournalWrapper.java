package com.modsen.library.wrapper;

import com.modsen.library.dto.journal.JournalDto;
import com.modsen.library.dto.journal.JournalListDto;
import com.modsen.library.service.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.modsen.library.mapper.JournalMapper.INSTANCE;

@Component
@RequiredArgsConstructor
public class JournalWrapper {
    private final JournalService journalService;

    public JournalDto save(long id) {
        return INSTANCE.journalToDto(journalService.save(id));
    }

    public JournalListDto getAllWithPagination(PageRequest pageRequest) {
        JournalListDto journalListDto = new JournalListDto();
        List<JournalDto> journalsDto = new ArrayList<>();

        journalService.findAllWithPagination(pageRequest)
                .forEach(journal ->
                        journalsDto.add(
                                INSTANCE.journalToDto(journal)));
        journalListDto.setJournalDtoList(journalsDto);

        return journalListDto;
    }
}
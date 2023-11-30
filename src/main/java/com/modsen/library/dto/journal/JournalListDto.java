package com.modsen.library.dto.journal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Information about journal notes")
public class JournalListDto {
    private List<JournalDto> journalDtoList;
}
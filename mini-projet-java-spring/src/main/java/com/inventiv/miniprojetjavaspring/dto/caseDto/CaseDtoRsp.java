package com.inventiv.miniprojetjavaspring.dto.caseDto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CaseDtoRsp {
    private Long caseId;

    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private String title;
    private String description;
}

package com.inventiv.miniprojetjavaspring.service;

import java.util.List;

public interface BaseService<RSP_DTO, REQ_DTO, F> {
    RSP_DTO save(REQ_DTO dtoMini);

    RSP_DTO update(REQ_DTO dtoMini, F f);

    Boolean delete(F f);

    RSP_DTO findById(F f);

    List<RSP_DTO> findAll();
}
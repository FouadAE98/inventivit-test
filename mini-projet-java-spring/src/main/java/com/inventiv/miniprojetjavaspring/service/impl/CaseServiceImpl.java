package com.inventiv.miniprojetjavaspring.service.impl;

import com.inventiv.miniprojetjavaspring.dto.caseDto.CaseDtoReq;
import com.inventiv.miniprojetjavaspring.dto.caseDto.CaseDtoRsp;
import com.inventiv.miniprojetjavaspring.entity.Case;
import com.inventiv.miniprojetjavaspring.exception.NotFoundEx;
import com.inventiv.miniprojetjavaspring.repository.CaseRepository;
import com.inventiv.miniprojetjavaspring.service.inter.CaseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CaseServiceImpl implements CaseService {

    private  final CaseRepository caseRepository;

    private  final ModelMapper modelMapper;

    @Override
    public CaseDtoRsp save(CaseDtoReq dtoMini) {
        Case caseEntity = modelMapper.map(dtoMini, Case.class);
        caseEntity = caseRepository.save(caseEntity);
        return modelMapper.map(caseEntity, CaseDtoRsp.class);
    }

    @Override
    public CaseDtoRsp update(CaseDtoReq dtoMini, Long aLong) {
        Case case1 = caseRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("Case not found"));
        Case caseEntity = modelMapper.map(dtoMini, Case.class);

        caseEntity.setCaseId(aLong);
        caseEntity.setCreationDate(case1.getCreationDate());
        caseEntity = caseRepository.save(caseEntity);
        return modelMapper.map(caseEntity, CaseDtoRsp.class);
    }

    @Override
    public Boolean delete(Long aLong) {
        caseRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("Case not found"));
        caseRepository.deleteById(aLong);
        return !caseRepository.existsById(aLong);
    }

    @Override
    public CaseDtoRsp findById(Long aLong) {
        Case caseEntity = caseRepository.findById(aLong).orElseThrow(() -> new NotFoundEx("Case not found"));
        return modelMapper.map(caseEntity, CaseDtoRsp.class);
    }

    @Override
    public List<CaseDtoRsp> findAll() {
        List<Case> caseEntities = caseRepository.findAll();
        return caseEntities.stream().map(caseEntity -> modelMapper.map(caseEntity, CaseDtoRsp.class)).toList();
    }
}

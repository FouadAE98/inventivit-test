package com.inventiv.miniprojetjavaspring.controller;

import com.inventiv.miniprojetjavaspring.dto.caseDto.CaseDtoReq;
import com.inventiv.miniprojetjavaspring.dto.caseDto.CaseDtoRsp;
import com.inventiv.miniprojetjavaspring.service.inter.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/case")
@RequiredArgsConstructor
public class CaseController {
    private final CaseService caseService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CaseDtoReq caseDtoReq) {
        HashMap<String, Object> response = new HashMap<>();
        CaseDtoRsp caseDtoRsp = caseService.save(caseDtoReq);
        response.put("message", "Case created successfully");
        response.put("case", caseDtoRsp);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CaseDtoReq caseDtoReq) {
        HashMap<String, Object> response = new HashMap<>();
        CaseDtoRsp caseDtoRsp = caseService.update(caseDtoReq, id);
        response.put("message", "Case updated successfully");
        response.put("case", caseDtoRsp);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        HashMap<String, Object> response = new HashMap<>();
        Boolean isDeleted = caseService.delete(id);
        response.put("message", "Case deleted successfully");
        response.put("isDeleted", isDeleted);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        CaseDtoRsp caseDtoRsp = caseService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(caseDtoRsp);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<CaseDtoRsp> caseDtoRsps = caseService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(caseDtoRsps);
    }
}

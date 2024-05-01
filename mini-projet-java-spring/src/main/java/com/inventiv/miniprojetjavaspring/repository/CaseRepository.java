package com.inventiv.miniprojetjavaspring.repository;

import com.inventiv.miniprojetjavaspring.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {
}

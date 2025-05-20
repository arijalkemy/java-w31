package com.bootcamp.showroom.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.bootcamp.showroom.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByDate(LocalDate date);
    void deleteByNumber(String number);
    Sale findByNumber(String number);
}

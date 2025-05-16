package com.meli.hibernate.maolaya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meli.hibernate.maolaya.model.MiniSerie;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {

}

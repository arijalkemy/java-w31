package dev.gomezandres.practicajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gomezandres.practicajpa.model.MiniSeries;

public interface IMiniserieRepository extends JpaRepository<MiniSeries, Long> {

}

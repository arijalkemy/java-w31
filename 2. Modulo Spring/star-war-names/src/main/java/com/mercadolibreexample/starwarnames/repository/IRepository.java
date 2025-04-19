package com.mercadolibreexample.starwarnames.repository;

import com.mercadolibreexample.starwarnames.Entity.Personaje;

import java.util.List;

public interface IRepository {
    public List<Personaje> LoadData();
}

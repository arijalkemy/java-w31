package com.example.ejlinkertracker.repository;

import com.example.ejlinkertracker.model.LinkTacker;

import java.util.List;

public interface ILinkRepository {
    List<LinkTacker> findAll();
}

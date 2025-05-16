package com.swapapp.miniseries.service;

import com.swapapp.miniseries.repository.IMiniSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {
    @Autowired
    private IMiniSerieRepository miniSerieRepository;
}

package com.meli.segurosautos.Service;

import com.meli.segurosautos.Repository.SiniestrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiniestroServiceImpl {
    @Autowired
    private SiniestrosRepository siniestrosRepository;
}

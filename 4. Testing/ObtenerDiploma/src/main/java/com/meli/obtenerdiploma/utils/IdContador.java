package com.meli.obtenerdiploma.utils;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class IdContador{

    private static Integer idCount = 1;

    public static Integer getIdCount() {
        return idCount;
    }

    public static Integer idCountGetAndIncrement(){
        return idCount++;
    }

}

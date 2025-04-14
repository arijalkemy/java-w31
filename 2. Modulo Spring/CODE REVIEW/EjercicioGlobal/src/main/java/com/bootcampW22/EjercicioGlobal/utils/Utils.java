package com.bootcampW22.EjercicioGlobal.utils;

import java.util.Arrays;

public abstract class Utils {
    public static double[] separateDimensionParams(String dimensions) {
        String[] dim = dimensions.split("-");
        return Arrays.stream(dim).mapToDouble(Double::parseDouble).toArray();
    }
}

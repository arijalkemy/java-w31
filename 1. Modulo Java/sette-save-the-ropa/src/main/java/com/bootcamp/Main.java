package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Wardrobe wardrobe = new Wardrobe();
        List<Garment> garmentsUno = List.of(new Garment("H&M", "Maglia1"), new Garment("H&M", "Maglia2"));
        List<Garment> garmentsDue = List.of(new Garment("Zara", "Pantaloni1"), new Garment("Zara", "Maglia1"));
        Integer clothesUno = wardrobe.saveClothes(garmentsUno);
        Integer clothesDue = wardrobe.saveClothes(garmentsDue);
        wardrobe.showClothes();
        System.out.println(wardrobe.getClothesById(clothesUno));
        System.out.println(wardrobe.getClothesById(clothesDue));
    }
}
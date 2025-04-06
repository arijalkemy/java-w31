package com.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wardrobe {
    private static HashMap<Integer, List<Garment>> clothes;
    private Integer id;

    public Wardrobe() {
        clothes = new HashMap<>();
        this.id = 0;
    }

    public Integer saveClothes(List<Garment> garments){
        System.out.println("\nSaving " + garments.size() + " garments");
        id += 1;
        clothes.put(id, garments);
        return id;
    }

    public void showClothes(){
        System.out.println("\nShowing clothes...");
        for (Map.Entry<Integer, List<Garment>> entry : clothes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public List<Garment> getClothesById(Integer id){
        System.out.println("\nGetting clothes by id: " + id);
        return clothes.get(id);
    }
}

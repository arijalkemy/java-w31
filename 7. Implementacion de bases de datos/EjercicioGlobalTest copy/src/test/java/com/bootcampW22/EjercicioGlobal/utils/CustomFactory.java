package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.*;




import java.util.ArrayList;
import java.util.List;

public class CustomFactory {

    public static List<Vehicle> getListVehicle(){
        List<Vehicle> list = new ArrayList<>();
        Vehicle v1 = new Vehicle(1L,"Ford","Fiero","6603","Azul",2018,"85",2,"gasoline","semi-automatic",105.43,280.28,1500);
        Vehicle v2 = new Vehicle(2L,"Ford","Fiero","6603","Azul",2020,"85",2,"gasoline","semi-automatic",105.43,280.28,1200);

        list.add(v1);
        list.add(v2);

        return list;
    }

    public static List<Vehicle> getListVehicleEqualYear(){
        List<Vehicle> list = new ArrayList<>();
        Vehicle v1 = new Vehicle(1L,"Ford","Fiero","6603","Azul",2018,"85",2,"gasoline","semi-automatic",105.43,280.28,1500);
        Vehicle v2 = new Vehicle(2L,"Ford","Fiero","6603","Azul",2018,"85",2,"gasoline","semi-automatic",105.43,280.28,1200);

        list.add(v1);
        list.add(v2);

        return list;
    }

}

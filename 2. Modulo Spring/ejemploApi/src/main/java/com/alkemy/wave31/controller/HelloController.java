package com.alkemy.wave31.controller;

import com.alkemy.wave31.service.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    //De esta manera puedo pedir varios parametros
    @GetMapping(path = "{name}/{lastname}/{age}")
    public String sayHello(@PathVariable String name,
                           @PathVariable String lastname,
                           @PathVariable String age) {
        return "Hello World: " + name + " " + lastname + " Tu edad es: " + age;
    }

    // Para solictar parametros que deben ser ingresados en la url como nombre?name="carlos"
    @GetMapping(path = "/student/")
    public Student findStudent(@RequestParam String name,
                               @RequestParam String lastname){
        return findStudent(name,lastname);
    }

    // me eprmite recibir un objeto en el body y ya mapearlo al objeto java
    @PostMapping (path = "/employee")
    public void handle (RequestBody Employee employee){
        // ....
    }


    @GetMapping(path = "/orders/")
    @ResponseBody // se encarga de mapear la lista de ordenes a un json y las devuelve
    public List<Order> getOrders(){
        return ordersManager.getAllOrders();
    }
}

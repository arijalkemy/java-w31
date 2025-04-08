package com.mercadolibre.ejemplos;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping (path = "{name}/{lastname}/{age}")
    public String hello(@PathVariable String name,
                        @PathVariable String lastname,
                        @PathVariable int age) {
        return ("Hola, " + name + " " + lastname + ", tu edad es " + age);
    }

    @GetMapping ("/user/{userId}")
    public User getUser(@PathVariable ("userId") String userId ) {
        return new User(userId);
    }

    @GetMapping (path = "/student/")
    public Student findStudent (@RequestParam String name,
                                @RequestParam String lastName) {
        return findStudent(name, lastName);
    }
}

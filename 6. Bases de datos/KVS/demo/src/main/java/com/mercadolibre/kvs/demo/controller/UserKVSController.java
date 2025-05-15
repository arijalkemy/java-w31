package com.mercadolibre.kvs.demo.controller;

import com.mercadolibre.kvs.demo.models.User;
import com.mercadolibre.kvs.demo.services.UserKVSService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserKVSController {

    private final UserKVSService service;

    @PostMapping
    public void create(@RequestBody User user) {
        service.createUser(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return service.getUser(id); // Aquí delegas la lógica completamente
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody User user) {
        service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @GetMapping("/pais/{pais}")
    public List<User> obtenerPorPais(@PathVariable String pais) {
        return service.obtenerUsuariosPorPais(pais);
    }
}
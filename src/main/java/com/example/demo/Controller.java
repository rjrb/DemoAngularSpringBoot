package com.example.demo;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("")
    public Map<String, String> hello() {
        return Map.of("mensaje", "Hola mundo");
    }

    @GetMapping("/{nombre}")
    public Map<String, String> getNombre(@PathVariable String nombre) {
        return Map.of("mensaje", "Hola " + nombre);
    }

}

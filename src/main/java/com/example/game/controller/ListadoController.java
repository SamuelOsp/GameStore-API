/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.game.controller;

import com.example.game.service.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
// ---------------------------------

/**
 *
 * @author samu ospina
 */
@Controller
public class ListadoController {
    
    private final VideojuegoService videojuegoService; 

    
    public ListadoController(VideojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }
    
 
    @GetMapping({"/", "/videojuegos"})
    public String listarVideojuego(Model model) {
        model.addAttribute("videojuegos", videojuegoService.buscarDestacados());
        return "listado";
    }
    
    
    @PostMapping("/checkout")
    @ResponseBody 
    public String procesarCompra(@RequestBody List<Long> ids) {
        videojuegoService.procesarCompra(ids);
        return "Compra exitosa";
    }
}
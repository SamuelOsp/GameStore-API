/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.game.service;

import com.example.game.domain.Usuario;
import com.example.game.domain.Videojuego;
import com.example.game.repository.UsuarioRepository;
import com.example.game.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class VideojuegoService {

    @Autowired
    private VideojuegoRepository videojuegoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para listar juegos (y crear datos si está vacío)
    public List<Videojuego> buscarDestacados() {
        
        if (videojuegoRepository.count() == 0) {
            
            // --- 1. CREACIÓN DE VIDEOJUEGOS ---
            Videojuego j1 = new Videojuego("Naruto Shippuden", 
                    "El maestro Kakashi ha organizado un torneo...", 
                    "https://m.media-amazon.com/images/I/81z7E+XXGJL._AC_SL1500_.jpg", 
                    new BigDecimal(150000), 20, "PS5", 4.8, 50); // 50 de Stock
            
            Videojuego j2 = new Videojuego("One Piece Odyssey", 
                    "Una aventura RPG en el universo de One Piece.", 
                    "https://m.media-amazon.com/images/I/81gD+I+yQ4L._AC_SL1500_.jpg", 
                    new BigDecimal(200000), 0, "PC", 4.5, 20); // 20 de Stock

            Videojuego j3 = new Videojuego("Dragon Ball Z: Kakarot", 
                    "Revive la historia de Goku y los guerreros Z.", 
                    "https://m.media-amazon.com/images/I/810-D-2w-LL._AC_SL1500_.jpg", 
                    new BigDecimal(180000), 15, "XBOX", 4.9, 10); // 10 de Stock

            Videojuego j4 = new Videojuego("Demon Slayer: Hinokami", 
                    "Conviértete en la espada que destruye demonios.", 
                    "https://m.media-amazon.com/images/I/81I+1r4A+pL._AC_SL1500_.jpg", 
                    new BigDecimal(220000), 5, "PS5", 4.7, 5); // 5 de Stock

            // Guardamos los juegos en la BD
            videojuegoRepository.saveAll(List.of(j1, j2, j3, j4));
            
            // --- 2. CREACIÓN DE USUARIOS ---
            if (usuarioRepository.count() == 0) {
                // Usuario 1: Admin
                Usuario admin = new Usuario("Samuel Ospina", "admin@neogame.com", "admin123", "ADMIN");
                usuarioRepository.save(admin);
                
                // Usuario 2: Cliente (El que pediste)
                Usuario user2 = new Usuario("Maria Perez", "maria@gmail.com", "maria123", "USER");
                usuarioRepository.save(user2);
            }
        }
        
        return videojuegoRepository.findAll();
    }

    
    @Transactional 
    public void procesarCompra(List<Long> idsJuegos) {
        for (Long id : idsJuegos) {
            
            Videojuego juego = videojuegoRepository.findById(id).orElse(null);
            
            
            if (juego != null && juego.getStock() > 0) {
                juego.setStock(juego.getStock() - 1); 
                videojuegoRepository.save(juego);
            }
        }
    }
}
package com.fing.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Clases internas para los modelos (puedes crearlas en archivos separados)
class Order {
    private int id;
    public Order(int id) { this.id = id; }
    public int getId() { return id; }
}

class BRate {
    private String estado;
    public BRate(String estado) { this.estado = estado; }
    public String getEstado() { return estado; }
}

class Users {
    private String nombre;
    public Users(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
}

class Visitors {
    private String nombre;
    public Visitors(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
}

@Controller
public class MainCtrl {
    
    @GetMapping("/")
    public String raiz(Model model) {
        // Título de la página (DBP)
        model.addAttribute("msg", "HOLAAAA");
        
        // Nombre de usuario (junto a la foto)
        model.addAttribute("nombreUsuario", "Erick Ramirez");
        
        // ===========================================
        // CUADRO AZUL - ORDERS (6 órdenes)
        // ===========================================
        ArrayList<Order> ordenes = new ArrayList<>();
        ordenes.add(new Order(10000));
        ordenes.add(new Order(259000));
        ordenes.add(new Order(982));
        ordenes.add(new Order(187956));
        ordenes.add(new Order(1568));
        ordenes.add(new Order(6000));
        model.addAttribute("ordenes", ordenes);
        
        // ===========================================
        // CUADRO VERDE - BOUNCE RATE (40% con lista)
        // ===========================================
        ArrayList<BRate> listaBRate = new ArrayList<>();
        listaBRate.add(new BRate("Orden incorrecto"));
        listaBRate.add(new BRate("Orden incorrecto"));
        listaBRate.add(new BRate("Orden correcto"));
        listaBRate.add(new BRate("Orden correcto"));
        listaBRate.add(new BRate("Orden correcto"));
        listaBRate.add(new BRate("Orden correcto"));

        
        // Calcular porcentaje de "Funciona"
        int positivos = 0;
        for (BRate b : listaBRate) {
            if ("Orden Correcto".equalsIgnoreCase(b.getEstado())) {
                positivos++;
            }
        }
        int porcentajeFinal = (int) Math.round((positivos * 100.0) / listaBRate.size()); // 40%
        
        model.addAttribute("brate", porcentajeFinal);
        model.addAttribute("listaBRate", listaBRate);
        
        // ===========================================
        // CUADRO AMARILLO - USER REGISTRATIONS (4 usuarios)
        // ===========================================
        ArrayList<Users> listaUsers = new ArrayList<>();
        listaUsers.add(new Users("Erick"));
        listaUsers.add(new Users("Pau"));
        listaUsers.add(new Users("Peter"));
        listaUsers.add(new Users("Ken"));
        model.addAttribute("listaUsers", listaUsers);
        
        // ===========================================
        // CUADRO ROJO - UNIQUE VISITORS (15 visitantes)
        // ===========================================
        ArrayList<Visitors> listaVisitors = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            listaVisitors.add(new Visitors("Visitante " + i));
        }
        model.addAttribute("listaVisitors", listaVisitors);
        
        return "index";
    }
}
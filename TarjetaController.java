package com.example.demo.controllers;

import com.example.demo.models.ClienteModel;
import com.example.demo.models.SimulacionModel;
import com.example.demo.models.SimulacionRqDTO;
import com.example.demo.models.UsuarioModel;
import com.example.demo.services.SimulacionService;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    SimulacionService simulacionService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping("/V1")
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
    @PostMapping("/registrar-cliente")
    public ClienteModel guardarCliente(@RequestBody ClienteModel cliente){
        return this.simulacionService.registarCliente(cliente);
    }

    @PostMapping("/simulacion")
    public ResponseEntity<SimulacionModel> realizarSimulación(@RequestBody SimulacionRqDTO simulacion) {
        return this.simulacionService.realizarSimulación(simulacion);
    }

}





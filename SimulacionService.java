package com.example.demo.services;

import com.example.demo.models.ClienteModel;
import com.example.demo.models.SimulacionModel;
import com.example.demo.models.SimulacionRqDTO;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.SimulacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SimulacionService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    SimulacionRepository simulacionRepository;


    public ClienteModel registarCliente(ClienteModel client){
        return clienteRepository.save(client);
    }

    public ResponseEntity<SimulacionModel> realizarSimulación (SimulacionRqDTO simulacionRequest) {

        clienteRepository.findById(simulacionRequest.getClienteId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no existe "));

        SimulacionModel simulacionTable = new SimulacionModel();
        simulacionTable.setCupoAprobado(simulacionRequest.getSalario() * 2);
        simulacionTable.setTasa("10");
        simulacionTable.setTipoTarjeta("Tarjeta gold");
        simulacionTable.setClienteId(simulacionRequest.getClienteId());
        simulacionTable.setSalario(simulacionRequest.getSalario());

        simulacionRepository.save(simulacionTable);

        return ResponseEntity.ok(simulacionTable);
    }
}





package com.veiculos.controller;

import com.veiculos.domain.Veiculo;
import com.veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public Iterable<Veiculo> obterTodos(){
        return veiculoService.obterTodos();
    }

    @GetMapping("/{vin}")
    public Optional<Veiculo> obterPorVin(@PathVariable int vin){
        return veiculoService.obterPorId(vin);
    }

    @PostMapping
    public Veiculo adicionar(@RequestBody Veiculo veiculo){
        return veiculoService.cadastrar(veiculo);
    }

    @PutMapping("/{vin}")
    public Optional<Veiculo> atualizar(@PathVariable int vin, @RequestBody Veiculo veiculo){
        veiculo.setVin(vin);
        return veiculoService.atualizar(veiculo);
    }

    @DeleteMapping("/{vin}")
    public Optional<Veiculo> remover(@PathVariable int vin){
        return veiculoService.remover(vin);
    }
}

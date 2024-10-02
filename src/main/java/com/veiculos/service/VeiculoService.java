package com.veiculos.service;

import com.veiculos.domain.Veiculo;
import com.veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public Iterable<Veiculo> obterTodos(){
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> obterPorId(int vin){
        return veiculoRepository.findById(vin);
    }

    public Veiculo cadastrar(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public Optional<Veiculo> atualizar(Veiculo _veiculo){
        Optional<Veiculo> veiculo = veiculoRepository.findById(_veiculo.getVin());
        if(veiculo.isPresent()){
            if(_veiculo.getMarca() != null){
                veiculo.get().setMarca(_veiculo.getMarca());
            }
            if(_veiculo.getTipo() != null){
                veiculo.get().setTipo(_veiculo.getTipo());
            }
            veiculoRepository.save(veiculo.get());
        }

        return veiculo;
    }

    public Optional<Veiculo> remover(int vin){
        Optional<Veiculo> veiculo =  obterPorId(vin);
        veiculo.ifPresent(veiculoRepository::delete);
        return veiculo;
    }
}

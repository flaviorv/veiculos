package com.veiculos.repository;

import com.veiculos.domain.Veiculo;
import org.springframework.data.repository.CrudRepository;

public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {
}

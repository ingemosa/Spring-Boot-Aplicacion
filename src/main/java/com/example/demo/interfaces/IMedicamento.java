package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.modelo.Medicamento;

@Repository
public interface IMedicamento extends CrudRepository<Medicamento, Integer> {
	

}

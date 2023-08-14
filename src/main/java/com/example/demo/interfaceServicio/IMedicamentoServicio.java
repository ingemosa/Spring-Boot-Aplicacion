package com.example.demo.interfaceServicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Medicamento;

public interface IMedicamentoServicio {

	public List<Medicamento> listar();

	public Optional<Medicamento> listarId(int id);

	public int guardar(Medicamento medicamento);

	public void eliminar(int id);

}

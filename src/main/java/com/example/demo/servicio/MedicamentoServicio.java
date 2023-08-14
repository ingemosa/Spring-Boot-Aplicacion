package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceServicio.IMedicamentoServicio;
import com.example.demo.interfaces.IMedicamento;
import com.example.demo.modelo.Medicamento;

@Service
public class MedicamentoServicio implements IMedicamentoServicio {

	@Autowired
	private IMedicamento data;

	@Override
	public List<Medicamento> listar() {

		return (List<Medicamento>) data.findAll();
	}

	@Override
	public Optional<Medicamento> listarId(int id) {
		
		return data.findById(id);
	}

	@Override
	public int guardar(Medicamento medicamento) {
		int res = 0;
		Medicamento registro = data.save(medicamento);

		if (!registro.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);

	}

}

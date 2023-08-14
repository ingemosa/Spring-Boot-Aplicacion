package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceServicio.IMedicamentoServicio;
import com.example.demo.modelo.Medicamento;

@Controller
@RequestMapping
public class MedicamentoController {

	@Autowired
	private IMedicamentoServicio servicio;

	@GetMapping("/listar")
	public String listar(Model model) {
		String titlePage = "Listado de Medicamentos";
		List<Medicamento> medicamentos = servicio.listar();

		model.addAttribute("titulo", titlePage);
		model.addAttribute("medicamento", medicamentos);

		return "index";
	}

	@GetMapping("/nuevo")
	public String agregar(Model model) {
		String titlePage = "Módulo Medicamentos";
		model.addAttribute("titulo", titlePage);
		model.addAttribute("medicamento", new Medicamento());

		return "formulario";
	}

	@PostMapping("/guardar")
	public String guardar(@Validated Medicamento m, Model model) {
		servicio.guardar(m);
		return "redirect:/listar ";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		
		Optional<Medicamento> registro = servicio.listarId(id);
		model.addAttribute("medicamento", registro);
		
		return "formulario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		servicio.eliminar(id);
		
		return "redirect:/listar";
	}

}

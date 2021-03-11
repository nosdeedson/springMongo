package br.com.ejs.springMongo.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ejs.springMongo.model.Funcionario;
import br.com.ejs.springMongo.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public List<Funcionario> obterTodos() {
		return this.funcionarioService.obterTodos();
	}
	
	@GetMapping("{codigo}")
	public Funcionario obterPorCodigo(@PathVariable String codigo) {
		return this.funcionarioService.obterPorCodigo(codigo);
	}
	
	@GetMapping("range")
	public List<Funcionario> obterPorIdade( @RequestParam(name = "de") Integer de,
			@RequestParam(name = "ate") Integer ate){
		return this.funcionarioService.obterPorIdade(de, ate);
	}
	
	@PostMapping
	public Funcionario criar(@RequestBody Funcionario funcionario) {
		return this.funcionarioService.criar(funcionario);
	}
	
	@GetMapping("contar")
	public Long contar() {
		return this.funcionarioService.contar();
	}
	
	
	@GetMapping("contar-por-niver")
	public Map<String, Long> contarPorNiver(@RequestParam(name = "dia", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy")  LocalDate dia,
			@RequestParam(name = "age") Integer age) {
		Map<String, Long> resp = new HashMap<>();
		Long t = this.funcionarioService.contarPorNiver(dia, age);
		resp.put("qtd", t);
		return resp;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

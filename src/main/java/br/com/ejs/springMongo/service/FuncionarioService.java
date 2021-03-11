package br.com.ejs.springMongo.service;

import java.time.LocalDate;
import java.util.List;

import br.com.ejs.springMongo.model.Funcionario;


public interface FuncionarioService {
	
	public List<Funcionario> obterTodos();

	public Funcionario obterPorCodigo(String codigo);
	
	public Funcionario criar(Funcionario funcionario);

	public List<Funcionario> obterPorIdade(Integer de, Integer ate);

	public Long contar();

	public Long contarPorNiver(LocalDate dia, Integer age);

}

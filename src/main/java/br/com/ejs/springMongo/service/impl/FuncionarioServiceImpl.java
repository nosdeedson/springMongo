package br.com.ejs.springMongo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ejs.springMongo.model.Funcionario;
import br.com.ejs.springMongo.repository.FuncionarioRepository;
import br.com.ejs.springMongo.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	@Override
	public List<Funcionario> obterTodos() {
		return this.funcionarioRepository.findAll();
	}

	@Override
	public Funcionario obterPorCodigo(String codigo) {
		return this.funcionarioRepository.findById(codigo).orElseThrow(() -> new IllegalArgumentException("Não encontrado") );
	}

	@Override
	public Funcionario criar(Funcionario funcionario) {
		Optional<Funcionario> chefe = this.funcionarioRepository.findById(funcionario.getChefe().getCodigo());
		funcionario.setChefe(chefe.get());
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public List<Funcionario> obterPorIdade(Integer de, Integer ate) {
		return this.funcionarioRepository.obterFuncionariosPorRangeIdade(de, ate);
	}

	@Override
	public Long contar() {
		return this.funcionarioRepository.count();
	}

	@Override
	public Long contarPorNiver(LocalDate dia, Integer age) {
		//dia = LocalDate.of(1980, 6, 30);
		LocalDate ate = LocalDate.now();
		Long d = this.funcionarioRepository.count_NiverEquals(dia, ate, age);
		return d;
	}

}

package br.com.ejs.springMongo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.ejs.springMongo.model.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
	
	List<Funcionario> findByNome(String nome);
	
	@Query(value = "{ $and: [ { 'idade': { $gte: ?0 } }, { 'idade': { $lte: ?1 } } ] }")
	public List<Funcionario> obterFuncionariosPorRangeIdade(Integer de, Integer ate);
	
	@Query(value = " { $and: [ { 'niver': { $gte: ?0 } }, { 'niver': { $lte: ?1 } } {'idade': ?2 }  ] }", count = true)
	public Long count_NiverEquals(LocalDate dia, LocalDate ate, Integer age);

}

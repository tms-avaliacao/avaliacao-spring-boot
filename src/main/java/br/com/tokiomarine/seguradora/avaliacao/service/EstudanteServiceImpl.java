package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

/**
 * Classe concreta para os serviços realizados na entidade Estudante
 * @author Danilo Portela
 */
@Service
public class EstudanteServiceImpl implements EstudandeService {

	//Repositorio para operações no BD
	@Autowired
	EstudanteRepository repository;

	
	/**
	 * Persiste um estudante no BD
	 * @param estudante
	 */
	@Override
	public void cadastrarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}

	/**
	 * Atualiza um estudante no BD com os novos dados informados no modelo
	 */
	@Override
	public void atualizarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}
	
	/**
	 * Busca todos os elementos da tabela estudante no BD
	 */
	@Override
	public List<Estudante> buscarEstudantes() {
		return (List<Estudante>) repository.findAll();
	}

	/**
	 * Busca um estudante no BD pelo ID
	 */
	@Override
	public Estudante buscarEstudante(long id) {
		Estudante estudante;
		try {
			estudante = repository.findById(id).get();
		} catch (Exception e) {
			throw new IllegalArgumentException("Identificador inválido:" + id);
		}
		return estudante;
	}

	/**
	 * Remove um estudante do banco de dados
	 */
	@Override
	public void apagarEstudante(Estudante estudante) {
		repository.delete(estudante);
	}
}

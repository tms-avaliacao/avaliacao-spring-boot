package br.com.tokiomarine.seguradora.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long>{

	//Implementação de método de busca pelo campo nome
	List<Estudante> findByNome(String nome);

}

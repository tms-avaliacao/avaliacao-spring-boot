package br.com.tokiomarine.seguradora.avaliacao.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

@Repository
public interface EstudanteRepository  extends JpaRepository<Estudante,Long>{

	@Query(value = "SELECT e.* FROM estudantes e WHERE e.nome = ?1", nativeQuery = true)
	List<Estudante> findByName(String name);

}

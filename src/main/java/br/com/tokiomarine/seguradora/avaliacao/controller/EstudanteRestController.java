package br.com.tokiomarine.seguradora.avaliacao.controller;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@ComponentScan
@EntityScan
public class EstudanteRestController {

    @Autowired
    EstudandeService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Estudante> find(@PathVariable Integer id) {
        Estudante obj = service.buscarEstudante(id);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * @RequestBody Instrui o sistema a criar o objeto Estudante a partir do objeto Json enviado
     * @return Retorna a URI da nova Estudante
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Estudante objDto) {
        Estudante obj = service.buscarEstudante(objDto.getId());
        service.cadastrarEstudante(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody Estudante objDto, @PathVariable Integer id) {
        service.atualizarEstudante(objDto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletarEstudante(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Estudante>> findAll() {
        List<Estudante> list = service.buscarEstudantes();
        return ResponseEntity.ok().body(list);
    }
}

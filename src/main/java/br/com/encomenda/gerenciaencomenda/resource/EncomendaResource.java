package br.com.encomenda.gerenciaencomenda.resource;

import br.com.encomenda.gerenciaencomenda.dto.EncomendaDTO;
import br.com.encomenda.gerenciaencomenda.entities.Encomenda;
import br.com.encomenda.gerenciaencomenda.service.EncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/encomenda")
public class EncomendaResource {

    @Autowired
    private EncomendaService service;

    @GetMapping
    public ResponseEntity listAll(){
        List<Encomenda> encomendas = this.service.listAll();
        return ResponseEntity.ok(encomendas);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Encomenda encomenda){
        Encomenda encomendaCriada = this.service.create(encomenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(encomendaCriada);

    }

    @GetMapping(value = "/paginado")
    public ResponseEntity<Page<?>> listarRequerimentosPaginado(
            @RequestParam(
                    value = "page",
                    required = true,
                    defaultValue = "0") int page,
            @RequestParam(value = "size",
                    required = true,
                    defaultValue = "10") int size){

        Page<EncomendaDTO> encomendas = service.listEncomendasPaginado(page, size);

        return new ResponseEntity(encomendas,
                HttpStatus.OK);
    }
}

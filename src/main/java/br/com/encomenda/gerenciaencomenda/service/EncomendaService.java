package br.com.encomenda.gerenciaencomenda.service;

import br.com.encomenda.gerenciaencomenda.StatusEncomendaEnum;
import br.com.encomenda.gerenciaencomenda.builder.EncomendaBuilder;
import br.com.encomenda.gerenciaencomenda.dto.EncomendaDTO;
import br.com.encomenda.gerenciaencomenda.entities.Encomenda;
import br.com.encomenda.gerenciaencomenda.repository.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class EncomendaService {

    @Autowired
    private EncomendaRepository repository;

    @Autowired
    private EncomendaBuilder encomendaBuilder;

    @Transactional
    public Encomenda create(Encomenda encomenda){
        return this.repository.save(Encomenda.builder()
                .nomeDestinatario(encomenda.getNomeDestinatario())
                .codigo(encomenda.getCodigo())
                .bloco(encomenda.getBloco())
                .apartamento(encomenda.getApartamento())
                .status(StatusEncomendaEnum.AGUARDANDORETIRADA)
                .build());
    }

    //@Transactional
    public List<Encomenda> listAll(){
        return this.repository.findAll();
    }

    @Transactional
    public Page<EncomendaDTO> listEncomendasPaginado(int page,
                                                  int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("nomeDestinatario"));
        Page<Encomenda> modelPage;
        if(isNull(pageRequest)){
            throw new RuntimeException("Não foi possível listar as encomendas");
        }else if(size == 0){
            throw new RuntimeException("Não é possível listar 0 encomendas");
        }
        modelPage = repository.findAll(pageRequest);
        return modelPage.map(a -> encomendaBuilder.from(a));


    }

}

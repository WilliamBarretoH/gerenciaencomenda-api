package br.com.encomenda.gerenciaencomenda.builder;

import br.com.encomenda.gerenciaencomenda.dto.EncomendaDTO;
import br.com.encomenda.gerenciaencomenda.entities.Encomenda;
import org.springframework.stereotype.Service;

@Service
public class EncomendaBuilder implements Builder<Encomenda, EncomendaDTO>{

    @Override
    public Encomenda to(EncomendaDTO object) {
        return null;
    }

    @Override
    public EncomendaDTO from(Encomenda object) {
        return EncomendaDTO.builder()
                .nomeDestinatario(object.getNomeDestinatario())
                .codigo(object.getCodigo())
                .bloco(object.getBloco())
                .apartamento(object.getApartamento())
                .status(object.getStatus().getDescricao())
                .build();
    }
}

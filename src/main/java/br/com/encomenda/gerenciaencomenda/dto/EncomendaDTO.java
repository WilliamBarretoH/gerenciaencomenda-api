package br.com.encomenda.gerenciaencomenda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EncomendaDTO {

    private String nomeDestinatario;
    private String codigo;
    private Integer bloco;
    private Integer apartamento;
    private String status;
}

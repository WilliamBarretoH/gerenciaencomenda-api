package br.com.encomenda.gerenciaencomenda.entities;

import br.com.encomenda.gerenciaencomenda.StatusEncomendaEnum;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_encomenda")
public class Encomenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nomeDestinatario;

    @Column(nullable = false)
    private String codigo;

    private Integer bloco;

    private Integer apartamento;

    private StatusEncomendaEnum status;
}

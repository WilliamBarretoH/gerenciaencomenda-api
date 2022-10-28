package br.com.encomenda.gerenciaencomenda.builder;

public interface Builder<ENTITY,DTO> {

    ENTITY to(DTO object);
    DTO from(ENTITY object);

}

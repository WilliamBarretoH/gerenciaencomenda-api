package br.com.encomenda.gerenciaencomenda;

import br.com.encomenda.gerenciaencomenda.repository.EncomendaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

;import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class JPAUnitTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EncomendaRepository repository;

    @Test
    public void deveListarTodasAsEncomendas(){
        Iterable encomendas = repository.findAll();

        assertThat(encomendas).isEmpty();
    };
}

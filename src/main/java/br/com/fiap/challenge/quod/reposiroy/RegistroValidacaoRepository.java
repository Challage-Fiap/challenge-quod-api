package br.com.fiap.challenge.quod.reposiroy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.challenge.quod.model.RegistroValidacao;

@Repository
public interface RegistroValidacaoRepository extends MongoRepository<RegistroValidacao, String> {
}


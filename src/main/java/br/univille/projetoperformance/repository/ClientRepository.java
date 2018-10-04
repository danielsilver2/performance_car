package br.univille.projetoperformance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.univille.projetoperformance.model.Client;;

public interface ClientRepository extends JpaRepository<Client, Long>{
	Client findByName(String name);
	Client findByCpf(String cpf);
}

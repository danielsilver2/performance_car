package br.univille.projetoperformance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projetoperformance.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    UserModel findByEmail(String email);
    UserModel findByName(String username);
}
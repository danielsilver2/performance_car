package br.univille.projetoperformance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetoperformance.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
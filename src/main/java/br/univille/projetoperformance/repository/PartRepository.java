package br.univille.projetoperformance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.projetoperformance.model.Part;

public interface PartRepository extends JpaRepository<Part, Long>{
	Part findByName(String name);
	Part findByCategory(String category);
}
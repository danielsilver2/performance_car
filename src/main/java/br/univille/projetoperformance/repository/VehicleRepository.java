package br.univille.projetoperformance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetoperformance.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	Vehicle findByPlate(String plate);
	Vehicle findByClientId(int id);
}
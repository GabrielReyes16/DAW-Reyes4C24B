package pe.isil.microservicios_2978.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.microservicios_2978.model.Game;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findByCategory(String category);
    List<Game> findByName(String name);
}

package uk.sample.casino.repository;

import org.springframework.data.repository.CrudRepository;
import uk.sample.casino.model.Game;

/**
 * Resopository for Game
 */
public interface GameRepository extends CrudRepository<Game, Long> {

}

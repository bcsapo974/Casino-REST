package uk.sample.casino.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import uk.sample.casino.model.Person;

/**
 * Resopository for Person
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

    /**
     * Get all persons.
     * @return all persons list
     */
    @Override
    public List<Person> findAll();
}

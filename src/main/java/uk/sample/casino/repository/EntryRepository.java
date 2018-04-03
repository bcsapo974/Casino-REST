package uk.sample.casino.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import uk.sample.casino.model.Entry;

/**
 * Resopository for Entry
 */
public interface EntryRepository extends CrudRepository<Entry, Long> {

    /**
     * Get list of entries for a person
     * @param personId id of the person
     * @return list of entries
     */
    public List<Entry> findByPersonId(long personId);
}

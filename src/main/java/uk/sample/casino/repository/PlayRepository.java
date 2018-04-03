package uk.sample.casino.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import uk.sample.casino.model.Play;

/**
 * Resopository for Play
 */
public interface PlayRepository extends CrudRepository<Play, Long> {

    /**
     * Get list of plays for a person which started after from Date and before
     * toDate.
     *
     * @param personId id of the person
     * @param fromDate beginning of the date interval
     * @param toDate end of the date interval
     * @return list of plays
     */
    public List<Play> findByPersonIdAndStartBetween(long personId, Date fromDate, Date toDate);

}

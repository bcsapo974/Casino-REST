package uk.sample.casino.dao;

import java.util.List;
import uk.sample.casino.view.TopRated;

/**
 * Casino data access for difficult queries.
 */
public interface CasinoDao {

    /** Get player list ordered by played-different-games-in-same-session count
     * 
     * @return Person list with played games count */
    public List<TopRated> getMostDifferentGamePlayers();

}

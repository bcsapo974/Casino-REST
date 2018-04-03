package uk.sample.casino.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import uk.sample.casino.view.TopRated;

/**
 * Casino data access implementation for difficult queries.
 */
@Repository
public class CasinoDaoImpl implements CasinoDao {

    @PersistenceContext
    private EntityManager em;

    /**
     *
     * @return current entitymanager
     */
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Get player list ordered by played-different-games-in-same-session count
     *
     * @return Person list with played games count
     */
    @Override
    public List<TopRated> getMostDifferentGamePlayers() {
        List<TopRated> res = new ArrayList<>();
        String queryStr
                = " select p.person_id as id, pe.name as name, count(distinct p.game_id) as counted from ENTRY e, PLAY p, person pe "
                + " where p.person_id = e.person_id "
                + " and p.person_id = pe.id "
                + " and p.start between e.enter and e.leave "
                + " group by p.person_id, pe.name "
                + " order by 3 desc";
        Query query = em.createNativeQuery(queryStr);
        List<Object[]> result = query.getResultList();
        return result.stream().map(mapToItem).collect(Collectors.toList());
    }

    private Function<Object[], TopRated> mapToItem = (record) -> {
        Long id = ((BigInteger) record[0]).longValue();
        String name = (String) record[1];
        Long counted = ((BigInteger) record[0]).longValue();
        TopRated topRated = new TopRated(id, name, counted);
        return topRated;
    };

}

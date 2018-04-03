package uk.sample.casino.service;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.sample.casino.model.Entry;
import uk.sample.casino.model.Person;
import uk.sample.casino.model.Play;
import uk.sample.casino.view.TopRated;

/**
 * Test class for the CasinoService
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ConditionalOnWebApplication
public class CasinoServiceTest {

    @Autowired
    private CasinoService casinoService;

    public CasinoServiceTest() {
    }

    /**
     * Test of getPersonEntries method, of class CasinoService.
     */
    @Test
    public void testGetPersonEntries() {
        List<Entry> result = casinoService.getPersonEntries(1L);
        assertEquals(result.size(), 2);
    }

    /**
     * Test of getPlayedGamesByPersonAndEntries method, of class CasinoService.
     */
    @Test
    public void testGetPlayedGamesByPersonAndEntries() {
        long personId = 4L;
        long entryId = 6L;
        List<Play> result = casinoService.getPlayedGamesByPersonAndEntries(personId, entryId);
        assertEquals(result.size(), 1);
    }

    /**
     * Test of createNewPerson method, of class CasinoService.
     */
    @Test
    public void testCreateNewPerson() {
        String name = "Rebeka";
        Person result = casinoService.createNewPerson(name);
        assertEquals(result.getId(), 5);
    }

    /**
     * Test of getAllPerson method, of class CasinoService.
     */
    @Test
    public void testGetAllPerson() {
        List<Person> result = casinoService.getAllPerson();
        assertEquals(result.size(), 4);
    }
    
    /**
     * Test of getAllPerson method, of class CasinoService.
     */
    @Test
    public void getMostDifferentGamePlayers() {
        List<TopRated> result = casinoService.getMostDifferentGamePlayers();
        assertTrue(result.size()>0);
        assertEquals(result.get(0).getName(), "Cathy");
    }
    
}

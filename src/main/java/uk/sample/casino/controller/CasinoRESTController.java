package uk.sample.casino.controller;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.sample.casino.model.Entry;
import uk.sample.casino.model.Person;
import uk.sample.casino.model.Play;
import uk.sample.casino.service.CasinoService;
import uk.sample.casino.view.TopRated;
import uk.sample.casino.view.View;

/**
 * REST controller for Casino
 */
@RestController
public class CasinoRESTController {

    private static final String JSON_RESPONSE_OK = "{response=OK}";
    private static final String JSON_RESPONSE_ERROR = "{error=#ERROR}";

    @Autowired
    CasinoService casinoService;

    /**
     * Get all entries for a person
     *
     * @param personId id of the person
     * @return Entry list
     */
    @JsonView(View.Entry.class)
    @RequestMapping(value = "/person/{personId}/entries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Entry> getPersonEntries(@PathVariable("personId") long personId) {
        return casinoService.getPersonEntries(personId);
    }

    /**
     * Get all plays for a person and entry
     *
     * @param personId id of the person
     * @param entryId id of the entry
     * @return played plays
     */
    @JsonView(View.GameByEntry.class)
    @RequestMapping(value = "/person/{personId}/entry/{entryId}/games", method = RequestMethod.GET)
    public List<Play> getUserPlayedGamesByEntries(@PathVariable long personId, @PathVariable long entryId) {
        return casinoService.getPlayedGamesByPersonAndEntries(personId, entryId);
    }

    /**
     * Create a new person.
     *
     * @param name
     * @return the new person with the given name
     */
    @JsonView(View.Person.class)
    @RequestMapping(value = "/person/new", method = RequestMethod.POST)
    public Person createNewPerson(@RequestParam String name) {
        return casinoService.createNewPerson(name);
    }

    /**
     * Lists all persons.
     *
     * @return list of all persons
     */
    @JsonView(View.Person.class)
    @RequestMapping(value = "/person/all", method = RequestMethod.GET)
    public List<Person> getAllPerson() {
        return casinoService.getAllPerson();
    }

    /**
     * Lists all persons and different games count, ordered by played-different-games-in-same-ebtry count.
     *
     * @return list of all persons
     */
    @RequestMapping(value = "/top/various", method = RequestMethod.GET)
    public List<TopRated> getTopRatedPerson() {
        return casinoService.getMostDifferentGamePlayers();
    }
}

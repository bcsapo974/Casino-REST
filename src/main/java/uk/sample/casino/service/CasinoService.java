package uk.sample.casino.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.sample.casino.dao.CasinoDao;
import uk.sample.casino.model.Entry;
import uk.sample.casino.model.Person;
import uk.sample.casino.model.Play;
import uk.sample.casino.repository.EntryRepository;
import uk.sample.casino.repository.GameRepository;
import uk.sample.casino.repository.PersonRepository;
import uk.sample.casino.repository.PlayRepository;
import uk.sample.casino.view.TopRated;

/**
 * Casino service
 */
@Service
public class CasinoService {

    @Autowired
    EntryRepository entryRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayRepository playRepository;

    @Autowired
    CasinoDao casinoDao;

    /**
     * Gets the entries of a person
     *
     * @param personId id of the person
     * @return list of entries
     */
    public List<Entry> getPersonEntries(long personId) {
        return entryRepository.findByPersonId(personId);
    }

    /**
     * Get the played games of a in an entry
     *
     * @param personId id of the person
     * @param entryId id of the entry
     * @return list of plays
     */
    public List<Play> getPlayedGamesByPersonAndEntries(long personId, long entryId) {
        Optional<Entry> entry = entryRepository.findById(entryId);
        if (!entry.isPresent()) {
            return new ArrayList<>();
        }
        return playRepository.findByPersonIdAndStartBetween(personId, entry.get().getEnter(), entry.get().getLeave() == null ? new Date() : entry.get().getLeave());
    }

    /**
     * Creates a new person with the given name
     *
     * @param name name of the new person
     * @return new person
     */
    public Person createNewPerson(String name) {
        Person person = new Person();
        person.setName(name);
        person = personRepository.save(person);
        return person;
    }

    /**
     * Get all persons
     *
     * @return list of persons
     */
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    /**
     * Get player list ordered by played-different-games-in-same-session count
     *
     * @return Person list with played games count
     */
    public List<TopRated> getMostDifferentGamePlayers() {
        return casinoDao.getMostDifferentGamePlayers();
    }

}

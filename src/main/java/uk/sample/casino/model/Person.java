package uk.sample.casino.model;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import uk.sample.casino.view.View;

/**
 * Person entity for persons
 */
@Entity
@Table(name = "person")
public class Person {

    @JsonView(View.Person.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonView(View.Person.class)
    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private List<Entry> entries;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private List<Play> plays;

    /**
     * Constructor
     */
    public Person() {
    }

    /**
     *
     * @return current id
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id id for set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return current name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return current plays of the person
     */
    public List<Play> getPlays() {
        return plays;
    }

    /**
     *
     * @param plays plays to set
     */
    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }

    /**
     *
     * @return current entries of the person
     */
    public List<Entry> getEntries() {
        return entries;
    }

    /**
     *
     * @param entries entries to set
     */
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}

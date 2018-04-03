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
import javax.persistence.UniqueConstraint;
import uk.sample.casino.view.View;

/**
 * Game entity for games
 */
@Entity
@Table(name = "game", uniqueConstraints = {
    @UniqueConstraint(columnNames = "name")})
public class Game {

    @JsonView(View.GameByEntry.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonView(View.GameByEntry.class)
    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
    private List<Play> plays;

    /**
     * Constructor
     */
    public Game() {
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
     * @param id id to set
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
     * @return current plays
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
}

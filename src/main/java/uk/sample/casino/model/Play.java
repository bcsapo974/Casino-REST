package uk.sample.casino.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.sample.casino.view.View;

/**
 * Play entity for games
 */
@Entity
@Table(name = "play")
public class Play {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @JsonView(View.GameByEntry.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    Person person;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date start;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date end;

    /**
     * Constructor
     */
    public Play() {
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
     * @param id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return current game
     */
    public Game getGame() {
        return game;
    }

    /**
     *
     * @param game game to set
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     *
     * @return current start of the play
     */
    public Date getStart() {
        return start;
    }

    /**
     *
     * @param start start of play to set
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     *
     * @return current end of play
     */
    public Date getEnd() {
        return end;
    }

    /**
     *
     * @param end end of play to set
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     *
     * @return current person of play
     */
    public Person getPerson() {
        return person;
    }

    /**
     *
     * @param person person of play to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

}

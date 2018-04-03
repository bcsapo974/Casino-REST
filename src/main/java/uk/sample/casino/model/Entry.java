package uk.sample.casino.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.sample.casino.view.View;

/**
 * Entry entity for entries
 */
@Entity
@Table(name = "entry")
public class Entry {

    @JsonView(View.Entry.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    Person person;

    @JsonView(View.Entry.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date enter;

    @JsonView(View.Entry.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date leave;

    /**
     * Constructor
     */
    public Entry() {
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
     * @return current enter date
     */
    public Date getEnter() {
        return enter;
    }

    /**
     *
     * @param enter enter date to set
     */
    public void setEnter(Date enter) {
        this.enter = enter;
    }

    /**
     *
     * @return current leave
     */
    public Date getLeave() {
        return leave;
    }

    /**
     *
     * @param leave leave date to set
     */
    public void setLeave(Date leave) {
        this.leave = leave;
    }

    /**
     *
     * @return current person who enters
     */
    public Person getPerson() {
        return person;
    }

    /**
     *
     * @param person person who enters
     */
    public void setPerson(Person person) {
        this.person = person;
    }

}

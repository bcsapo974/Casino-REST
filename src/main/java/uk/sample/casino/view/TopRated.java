package uk.sample.casino.view;

public class TopRated {

    private long id;
    private String name;
    private long counted;

    public TopRated(long id, String name, long counted) {
        this.id = id;
        this.name = name;
        this.counted = counted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCounted() {
        return counted;
    }

    public void setCounted(long counted) {
        this.counted = counted;
    }

}

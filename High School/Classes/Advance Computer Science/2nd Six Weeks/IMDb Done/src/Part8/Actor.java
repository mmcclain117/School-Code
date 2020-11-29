package Part8;

public class Actor {

    private String na;

    Actor() {
    }

    Actor(String name) {
        this.na = name;
    }

    public String getName() {
        return na;
    }

    public void setName(String name) {
        na = name;
    }

    public String toString() {
        return na;
    }
}

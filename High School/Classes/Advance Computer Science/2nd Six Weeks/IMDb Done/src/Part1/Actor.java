package Part1;

public class Actor {

    private String na;
    private Actor ap;

    Actor() {
    }

    Actor(String name) {
        na = name;
    }

    public String getName() {
        return na;
    }

    public void setName(String name) {
        na = name;
    }

    public Actor getNextPtr() {
        return ap;
    }

    public void setNextPtr(Actor next) {
        ap = next;
    }

    public String toString() {
        return na;
    }
}

package Part6;

public class Movie {

    private int d; // Date
    private String t; // Title
    private LinkedList act; // Actor
    private LinkedList dir; // Directors

    Movie() {

    }

    Movie(int date, String title, LinkedList actor, LinkedList directors) {
        d = date;
        t = title;
        act = actor;
        dir = directors;
    }

    public int getDate() {
        return d;
    }

    public void setData(int date) {
        d = date;
    }

    public String getTitle() {
        return t;
    }

    public void setTitle(String title) {
        t = title;
    }

    public LinkedList getActors() {
        return act;
    }

    public void setActors(LinkedList actors) {
        act = actors; // Not Sure about
    }

    public LinkedList getDirectors() {
        return dir;
    }

    public void setDirectors(LinkedList actors) {
        dir = actors; // Not sure about
    }

    @Override
    public String toString() {
        return d + " " + t;
    }
}

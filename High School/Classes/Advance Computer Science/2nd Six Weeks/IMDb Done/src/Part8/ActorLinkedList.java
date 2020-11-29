package Part8;

import java.util.ArrayList;

public class ActorLinkedList {

    private int count;
    public ArrayList<Actor> a = new ArrayList(); // Not Sure using this
    private Actor head;

    public ActorLinkedList() {
        head = null;
        count = 0;
    }

    public void add(Actor actor) {
        actor.setNextPtr(head);
        a.add(actor);
        head = actor;
        ++count;
    }

    public Actor get(int index) { // Not sure did this right
        if (index >= count || index < 0) {
            return null;
        } else {
            Actor current = new Actor();
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNextPtr();
            }
            return current;
        }
    }

    public int size() {
        return count;
    }
}

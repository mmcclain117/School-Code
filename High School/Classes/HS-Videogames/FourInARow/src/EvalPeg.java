// class EvalPeg.java

import ch.aplu.jgamegrid.Actor;

public class EvalPeg extends Actor {

    public EvalPeg(int sprite) {
        // sprite 0 = black, sprite 1 = white
        super(true, "sprites/EvalPeg.png", 2);
        show(sprite);
    }
}

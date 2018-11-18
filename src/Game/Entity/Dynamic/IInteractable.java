package Game.Entity.Dynamic;

import java.awt.*;
import java.util.ArrayList;

public interface IInteractable {


    void interact(Graphics g);

    void endInteraction();

    String getName();

    ArrayList<String> getDialogue();
}

package agh.ics.oop;


import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class World {
    public static void main(String[] args) {
        try {
            List<MoveDirection> directions = OptionsParser.parse(args);
            AbstractWorldMap map = new GrassField(10);
            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(2, 10),
                    new Vector2d(-2, -5)));
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            Application.launch(App.class, args);
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
package agh.ics.oop.gui;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage){
            List<MoveDirection> directions = OptionsParser.parse(this.getParameters().getRaw().toArray(new String[0]));
            GrassField map = new GrassField(10);
            List<Vector2d> positions = List.of(new Vector2d[]{new Vector2d(2, 2), new Vector2d(2, 4)});
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            Vector2d lowerLeft = map.getLowerLeft();
            Vector2d upperRight = map.getUpperRight();
            GridPane gridPane = new GridPane();


            int lowerleftx = lowerLeft.x;
            int upperrighty = upperRight.y;

            Label newlabel = new Label("y/x");
            gridPane.add(newlabel, 0, 0, 1, 1);
            GridPane.setHalignment(newlabel, HPos.CENTER);
            gridPane.getColumnConstraints().add(new ColumnConstraints(30));
            gridPane.getRowConstraints().add(new RowConstraints(30));

            for (int p = 1; p <= (upperRight.x - lowerLeft.x + 1); p++) {
                Label label = new Label(Integer.toString(lowerleftx));
                gridPane.add(label, p, 0, 1, 1);
                GridPane.setHalignment(label, HPos.CENTER);
                lowerleftx++;
                gridPane.getColumnConstraints().add(new ColumnConstraints(30));
            }
            for (int q = 1; q <= (upperRight.y - lowerLeft.y + 1); q++) {
                Label label = new Label(Integer.toString(upperrighty));
                gridPane.add(label, 0, q, 1, 1);
                GridPane.setHalignment(label, HPos.CENTER);
                upperrighty--;
                gridPane.getRowConstraints().add(new RowConstraints(30));
            }

            int ox = 1;
            int oy = 1;

            for (int j = upperRight.y; j >= lowerLeft.y; j--) {
                for (int i = lowerLeft.x; i <= upperRight.x; i++) {
                    String objectRepresentation = "";
                    if (map.objectAt(new Vector2d(i, j)) != null) {
                        objectRepresentation = map.objectAt(new Vector2d(i, j)).toString();
                    }
                    Label label = new Label(objectRepresentation);
                    gridPane.add(label, ox, oy, 1, 1);

                    GridPane.setHalignment(label, HPos.CENTER);
                    ox++;
                }
                oy++;
                ox = 1;
            }
            gridPane.setGridLinesVisible(true);
            Scene scene = new Scene(gridPane, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();

    }
    public static void main(String[] args) {try {
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

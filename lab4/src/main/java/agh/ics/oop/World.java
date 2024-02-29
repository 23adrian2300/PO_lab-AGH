package agh.ics.oop;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class World {
    public static void main(String[] args) {
        System.out.println("System wystartowal");
        Animal animal = new Animal();
        List <MoveDirection> directions = new OptionsParser().parse(args);
        for (MoveDirection direction: directions){
            animal.move(direction);
        }
        System.out.println(animal);



        int licznik = 0;
        for (String arguments : args) {
            if (arguments.equals("f")) {
                licznik++;
            }
            if (arguments.equals("b")) {
                licznik++;
            }

            if (arguments.equals("l")) {
                licznik++;
            }

            if (arguments.equals("r")) {
                licznik++;
            }

        }
        MoveDirection[] arguments = new MoveDirection[licznik];

        int i = 0;
        for (String arg : args) {
            if (arg.equals("f") || arg.equals("l") || arg.equals("r") || arg.equals("b")) {
                arguments[i] = changing(arg);
                i++;
            }
        }

        run(arguments);
        System.out.println("System zakonczyl dzialanie");


        List<MoveDirection> direction = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();


    }

    public static void run(MoveDirection[] args) {
        if (args.length != 0) {
            System.out.println("START");
        }
        for (MoveDirection argument : args) {
            switch (argument) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case LEFT -> System.out.println("Zwierzak skreca w lewo");
                case RIGHT -> System.out.println("Zwierzak skreca w prawo");
            }
        }
        if (args.length != 0) {
            System.out.println("STOP");
        }
    }

    public static MoveDirection changing(String argument) {
        return switch (argument) {
            case "f" -> MoveDirection.FORWARD;
            case "b" -> MoveDirection.BACKWARD;
            case "l" -> MoveDirection.LEFT;
            case "r" -> MoveDirection.RIGHT;
            default -> null;
        };
    }

}
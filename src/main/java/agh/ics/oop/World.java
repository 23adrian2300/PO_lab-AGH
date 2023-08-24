package agh.ics.oop;


import java.util.List;

import static agh.ics.oop.OptionsParser.parse;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartowal");
        Animal animal = new Animal();
        List <MoveDirection> directions = parse(args);
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
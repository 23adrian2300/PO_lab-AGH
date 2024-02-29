package agh.ics.oop;


public class World {
    public static void main(String[] args) {
        System.out.println("System wystartowal");
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
        Direction[] arguments = new Direction[licznik];

        int i = 0;
        for (String arg : args) {
            if (arg.equals("f") || arg.equals("l") || arg.equals("r") || arg.equals("b")) {
                arguments[i] = changing(arg);
                i++;
            }
        }

        run2(arguments);
        System.out.println("System zakonczyl dzialanie");
    }

    public static void run2(Direction[] args) {
        if (args.length != 0) {
            System.out.println("START");
        }
        for (Direction argument : args) {
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

    public static Direction changing(String argument) {
        return switch (argument) {
            case "f" -> Direction.FORWARD;
            case "b" -> Direction.BACKWARD;
            case "l" -> Direction.LEFT;
            case "r" -> Direction.RIGHT;
            default -> null;
        };
    }

}
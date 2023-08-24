package agh.ics.oop;


public class World {
    public static void main(String[] args) {
        System.out.println("System wystartowal");
        int len = args.length;
        Direction[] arguments = new Direction[len];
        int i;
        for (i = 0; i < args.length; ++i) {
            arguments[i] = changing(args[i]);
        }
        run(arguments);
        System.out.println("System zakonczyl dzialanie");
    }

    public static void run(Direction[] args) {
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
            default -> Direction.NONE;
        };
    }
}
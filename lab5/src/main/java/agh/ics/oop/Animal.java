package agh.ics.oop;

import java.util.ArrayList;

public class Animal extends AbstractWorldMapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private final AbstractWorldMap map;

    // Parameterless constructor for testing purposes only
    public Animal() {
        this.position = new Vector2d(2, 2);
        this.map = new RectangularMap(5, 5);
    }

    public Animal(AbstractWorldMap map) {
        this.map = map;
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }


    @Override
    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    private boolean eatAttempt(Object objectAt, Vector2d newPosition) {
        if (objectAt instanceof Grass) {
            this.map.mapElements.remove(objectAt);
            return true;
        }

        return false;
    }

    public Animal move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD, BACKWARD -> {
                Vector2d unitVector = this.orientation.toUnitVector();
                if (direction == MoveDirection.BACKWARD)
                    unitVector = unitVector.opposite();
                Vector2d newPosition = this.position.add(unitVector);

                if (this.map.canMoveTo(newPosition)) {
                    Object objectAt = this.map.objectAt(newPosition);

                    if (objectAt == null || objectAt instanceof Grass)
                        this.position = newPosition;

                    if (eatAttempt(objectAt, newPosition))
                        ((GrassField) this.map).spawnGrass();
                }
            }
        }

        return this;
    }

    public Animal move(ArrayList<MoveDirection> directions) {
        for (MoveDirection direction : directions)
            this.move(direction);

        return this;
    }
}

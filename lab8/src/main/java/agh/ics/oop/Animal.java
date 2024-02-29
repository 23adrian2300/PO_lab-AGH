package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private final AbstractWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

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


    public void move(MoveDirection direction) {
        Vector2d newPosition;
        switch (direction) {
            case RIGHT -> this.orientation = orientation.next();
            case LEFT -> this.orientation = orientation.previous();
            case FORWARD -> {
                newPosition = this.position.add(this.orientation.toUnitVector());
                if (this.map.canMoveTo(newPosition)) {
                    positionChanged(this.position, newPosition);
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                newPosition = this.position.subtract(this.orientation.toUnitVector());
                if (this.map.canMoveTo(newPosition)) {
                    positionChanged(this.position, newPosition);
                    this.position = newPosition;
                }
            }
    }}

        public Animal move(ArrayList <MoveDirection> directions) {
            for (MoveDirection direction : directions)
                this.move(direction);

            return this;
        }

        public void addObserver(IPositionChangeObserver observer){

        this.observers.add(observer);
        }

        public void removeObserver(IPositionChangeObserver observer){

        this.observers.remove(observer);
        }

        private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
            for (IPositionChangeObserver observer : this.observers)
                observer.positionChanged(oldPosition, newPosition);
        }

}
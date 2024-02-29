package agh.ics.oop;


import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, Animal> mapElements = new HashMap<>();
    protected final MapVisualizer mapVisualizer = new MapVisualizer(this);
    protected Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d initialPosition = animal.getPosition();
        if(!this.canMoveTo(initialPosition))
            throw new IllegalArgumentException(initialPosition + " is not valid position to place new animal");
        this.mapElements.put(initialPosition, animal);
        return true;
    }
    public abstract Vector2d getLowerLeft();

    public abstract Vector2d getUpperRight();
    @Override
    public boolean isOccupied(Vector2d position) {
        return this.mapElements.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {

        return this.mapElements.get(position);
    }

    @Override
    public String toString() {
        return this.mapVisualizer.draw(this.lowerLeft, this.upperRight);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = mapElements.get(oldPosition);
        mapElements.remove(oldPosition);
        mapElements.put(newPosition, animal);
    }
}

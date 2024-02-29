package agh.ics.oop;

import java.util.*;
import java.lang.Math;
public class GrassField extends AbstractWorldMap {
    private final int maxCoord;
    int numberOfGrass;
    protected Map<Vector2d, Grass> grassPlacement = new HashMap<>();
    MapBoundary mapBoundary = new MapBoundary();

       public GrassField(int numberOfGrass) {
            this.numberOfGrass = numberOfGrass;
            maxCoord = (int) Math.sqrt((double) numberOfGrass * 10);
            spawnGrass(numberOfGrass);
        }

    @Override
    public boolean canMoveTo(Vector2d position) {

        if (this.isOccupied(position)) {
            return this.objectAt(position) instanceof Grass;
        }
        return true;
    }


    @Override
    public Object objectAt(Vector2d position) {   //returns animal if both animal and grass are on the position
        Object x = super.objectAt(position);
        if (x != null)
            return x;
        return grassPlacement.get(position);
    }

    @Override
    public Vector2d getLowerLeft() {
        return mapBoundary.lowerLeft();
    }

    @Override
    public Vector2d getUpperRight() {

        return mapBoundary.upperRight();
    }
    @Override
    public boolean place(Animal animal)
    {
        if(super.place(animal))
        {
            mapBoundary.addElement(animal.getPosition());
            animal.addObserver(mapBoundary);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        this.upperRight = this.mapBoundary.upperRight();
        this.lowerLeft = this.mapBoundary.lowerLeft();
        System.out.println(this.upperRight);
        System.out.println(this.lowerLeft);

        return super.toString();
    }

    public void spawnGrass(int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            Vector2d newPosition = new Vector2d(rand.nextInt(maxCoord), rand.nextInt(maxCoord));
            while (this.isOccupied(newPosition))
                newPosition = new Vector2d(rand.nextInt(maxCoord), rand.nextInt(maxCoord));
            this.grassPlacement.put(newPosition, new Grass(newPosition));
            mapBoundary.addElement(newPosition);
    }}

        @Override
        public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
        {
            super.positionChanged(oldPosition, newPosition);
            Grass grass = grassPlacement.get(newPosition);
            if(grass != null)
            {
                grassPlacement.remove(newPosition);
                this.spawnGrass(1);
            }
        }
}

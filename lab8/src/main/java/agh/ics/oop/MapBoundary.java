package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

import static agh.ics.oop.Comparators.comparatorX;
import static agh.ics.oop.Comparators.comparatorY;

public class MapBoundary implements IPositionChangeObserver{
    SortedSet<Vector2d> itemsX = new TreeSet<>(comparatorX);
    SortedSet<Vector2d> itemsY = new TreeSet<>(comparatorY);
    public void addElement(Vector2d a)
    {
        itemsX.add(a);
        itemsY.add(a);
    }
    public void removeElement(Vector2d a)
    {
        itemsX.remove(a);
        itemsY.remove(a);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removeElement(oldPosition);
        addElement(newPosition);
    }
    public Vector2d lowerLeft()
    {

        return new Vector2d(itemsX.first().x, itemsY.first().y);
    }
    public Vector2d upperRight()
    {

        return new Vector2d(itemsX.last().x, itemsY.last().y);
    }
}
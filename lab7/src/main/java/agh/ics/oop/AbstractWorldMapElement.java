package agh.ics.oop;

public class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position = new Vector2d(0,0);
    // Default position (guaranteed to be present on any map)

    public Vector2d getPosition() {
        return this.position;
    }
}

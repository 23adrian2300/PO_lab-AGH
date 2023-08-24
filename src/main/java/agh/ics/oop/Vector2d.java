package agh.ics.oop;
import java.util.Objects;
class Vector2d {
    public final int x, y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }


    boolean precedes(Vector2d other) {
        return (this.x <= other.x && this.y <= other.y);
    }


    boolean follows(Vector2d other) {
        return (this.x >= other.x && this.y >= other.y);
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));

    }

    //    Do pisać hashcode
    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Vector2d vector2dOther) {
            return (this.x == vector2dOther.x && this.y == vector2dOther.y);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

}
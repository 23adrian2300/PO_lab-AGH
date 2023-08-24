package agh.ics.oop;

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

    public boolean precedes(Vector2d other) {
        return (this.x <= other.x && this.y <= other.y);
    }


    public boolean follows(Vector2d other) {
        return (this.x >= other.x && this.y >= other.y);
    }

    public Vector2d add(Vector2d other) {
        int a = this.x + other.x;
        int b = this.y + other.y;

        return new Vector2d(a, b);
    }

    public Vector2d subtract(Vector2d other) {
        int a = this.x - other.x;
        int b = this.y - other.y;

        return new Vector2d(a, b);
    }

    public Vector2d upperRight(Vector2d other) {
        int a, b;
        a = Math.max(this.x, other.x);
        b = Math.max(this.y, other.y);

        return new Vector2d(a, b);

    }

    public Vector2d lowerLeft(Vector2d other) {
        int a, b;
        a = Math.min(this.x, other.x);
        b = Math.min(this.y, other.y);

        return new Vector2d(a, b);
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


    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }
}

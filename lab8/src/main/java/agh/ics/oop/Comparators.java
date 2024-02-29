package agh.ics.oop;

import java.util.Comparator;

public class Comparators {
    static Comparator<Vector2d> comparatorX = new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d a, Vector2d b)
        {
            if(a.x == b.x)
                return a.y-b.y;
            return a.x-b.x;
        }
    };

    static Comparator<Vector2d> comparatorY = new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d a, Vector2d b)
        {
            if(a.y == b.y)
                return a.x-b.x;
            return a.y-b.y;
        }
    };
}
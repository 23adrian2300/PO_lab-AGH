package agh.ics.oop;

class Animal {
    private Vector2d position;
    private MapDirection orientation;

    public Animal() {
        position = new Vector2d(2, 2);
        orientation = MapDirection.NORTH;
    }

    @Override
    public String toString() {
        return "Orientacja: " + orientation.toString() + " Pozycja: " + position.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT:
                orientation = orientation.next();
                break;
            case LEFT:
                orientation = orientation.previous();
                break;
            case FORWARD:
                if (orientation == MapDirection.NORTH && position.y < 4) {
                    position = position.add(new Vector2d(0, 1));
                } else if (orientation == MapDirection.EAST && position.x < 4) {
                    position = position.add(new Vector2d(1, 0));
                } else if (orientation == MapDirection.SOUTH && position.y > 0) {
                    position = position.add(new Vector2d(0, -1));
                } else if (orientation == MapDirection.WEST && position.x > 0) {
                    position = position.add(new Vector2d(-1, 0));
                }
                break;
            case BACKWARD:
                if (orientation == MapDirection.NORTH && position.y > 0) {
                    position = position.add(new Vector2d(0, -1));
                } else if (orientation == MapDirection.EAST && position.x > 0) {
                    position = position.add(new Vector2d(-1, 0));
                } else if (orientation == MapDirection.SOUTH && position.y < 4) {
                    position = position.add(new Vector2d(0, 1));
                } else if (orientation == MapDirection.WEST && position.x < 4) {
                    position = position.add(new Vector2d(1, 0));
                }
                break;

        }

    }
}
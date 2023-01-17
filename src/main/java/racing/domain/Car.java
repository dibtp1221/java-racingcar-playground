package racing.domain;

public class Car {
    private Position position;

    public Car() {
        position = new Position(0);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.canMove()) {
            position = position.move();
        }
    }

    public Position getPosition() {
        return this.position;
    }
}

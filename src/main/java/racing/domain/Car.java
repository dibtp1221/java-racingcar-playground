package racing.domain;

import java.util.Objects;

public class Car {
    private Name name;
    private Position position;

    public Car() {
        position = new Position(0);
    }

    public Car(String name, int location) {
        this.name = new Name(name);
        this.position = new Position(location);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.canMove()) {
            position = position.move();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}

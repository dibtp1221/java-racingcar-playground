package racing.domain;

import java.util.Objects;

public class Position {
    private final int location;
    public Position(int location) {
        this.location = location;
    }

    public Position move() {
        return new Position(location + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return location == position.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}

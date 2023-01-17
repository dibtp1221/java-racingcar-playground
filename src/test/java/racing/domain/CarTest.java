package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void move() {
        MovingStrategy movingStrategy = new AlwaysTrueMovingStrategy();
        Car car = new Car();
        car.move(movingStrategy);
        Assertions.assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    void toStringTest() {
        Car car = new Car("pobi", 3);
        Assertions.assertThat(car.toString()).isEqualTo("pobi : ---");
    }
}

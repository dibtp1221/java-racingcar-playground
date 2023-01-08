package carRacing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void getter() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    void drive() {
        Car car = new Car("pobi");
        car.drive();
        car.drive();
        car.drive();
        assertThat(car.getLocation()).isLessThanOrEqualTo(3);
    }
}

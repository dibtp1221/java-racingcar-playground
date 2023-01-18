package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingCarsTest {

    @Test
    void getFirstCar() {
        RacingCars racingCars = new RacingCars(new Car("pobi", 3), new Car("lucky", 6), new Car("four", 4), new Car("winner", 6));
        List<Car> firstCars = racingCars.getFirstCars();
        Assertions.assertThat(firstCars).containsOnly(new Car("lucky", 6), new Car("winner", 6));

        racingCars = new RacingCars(new Car("pobi", 3), new Car("lucky", 6), new Car("four", 4), new Car("winner", 7));
        firstCars = racingCars.getFirstCars();
        Assertions.assertThat(firstCars).containsOnly(new Car("winner", 7));
    }

}
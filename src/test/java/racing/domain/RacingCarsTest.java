package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingCarsTest {

    @Test
    void getFirstCar() {
        RacingCars racingCars = new RacingCars(new AlwaysTrueMovingStrategy(),
                new Car("pobi", 3), new Car("lucky", 6), new Car("four", 4), new Car("winner", 6));
        List<Car> firstCars = racingCars.getFirstCars();
        Assertions.assertThat(firstCars).containsOnly(new Car("lucky", 6), new Car("winner", 6));

        racingCars = new RacingCars(new AlwaysTrueMovingStrategy(),
                new Car("pobi", 3), new Car("lucky", 6), new Car("four", 4), new Car("winner", 7));
        firstCars = racingCars.getFirstCars();
        Assertions.assertThat(firstCars).containsOnly(new Car("winner", 7));
    }

    @Test
    void getFirstWinnersNames() {
        RacingCars racingCars = new RacingCars(new AlwaysTrueMovingStrategy(),
                new Car("pobi", 3), new Car("lucky", 6), new Car("four", 4), new Car("winner", 6));
        String firstWinnersNames = racingCars.getFirstWinnersNames();
        Assertions.assertThat(firstWinnersNames).isEqualTo("lucky, winner");
    }

    @Test
    void move() {
        RacingCars racingCars = new RacingCars(new AlwaysTrueMovingStrategy(),
                new Car("pobi", 0), new Car("lucky", 0), new Car("four", 0), new Car("winner", 0));
        racingCars.move();
        racingCars.move();
        List<Car> firstCars = racingCars.getFirstCars();
        Assertions.assertThat(firstCars).containsOnly(new Car("pobi", 2), new Car("lucky", 2), new Car("four", 2), new Car("winner", 2));
    }

}
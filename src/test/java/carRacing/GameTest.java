package carRacing;

import carRacing.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    @Test
    void inputNames() {
        Game game = new Game();
        String[] names = game.parseNames("pobi,crong,honux");
        Assertions.assertThat(names).containsExactly("pobi", "crong", "honux");

        Assertions.assertThatThrownBy(() -> game.parseNames("pobi,crong,honuxxx"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void makeCars() {
        Game game = new Game();

        String[] names = new String[]{"pobi", "crong", "honux"};
        List<Car> cars = game.makeCars(names);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("crong");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("honux");
    }
}

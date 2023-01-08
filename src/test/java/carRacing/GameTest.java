package carRacing;

import carRacing.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    @Test
    void inputNames() {
        String[] names = Game.parseNames("pobi,crong,honux");
        Assertions.assertThat(names).containsExactly("pobi", "crong", "honux");

        Assertions.assertThatThrownBy(() -> Game.parseNames("pobi,crong,honuxxx"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void makeCars() {
        String[] names = new String[]{"pobi", "crong", "honux"};
        List<Car> cars = Game.makeCars(names);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("crong");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("honux");
    }

    @Test
    void getWinner() {

        String[] names = new String[]{"pobi", "crong", "honux"};
        List<Car> cars = Game.makeCars(names);
        Game game = new Game(cars);

        cars.get(0).setLocation(3);
        cars.get(1).setLocation(2);
        cars.get(2).setLocation(4);
        Assertions.assertThat(game.getWinner()).containsExactly(cars.get(2));

        cars.get(0).setLocation(5);
        cars.get(1).setLocation(5);
        cars.get(2).setLocation(4);
        Assertions.assertThat(game.getWinner()).containsExactly(cars.get(0), cars.get(1));
    }
}

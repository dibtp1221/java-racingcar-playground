package racing.domain;

public class AlwaysTrueMovingStrategy implements MovingStrategy {
    @Override
    public boolean canMove() {
        return true;
    }
}

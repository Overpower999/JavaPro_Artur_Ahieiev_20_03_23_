package homework8.art2;

public class Cat extends Team {
    public Cat(int maxRange, int maxJump, String name) {
        super(maxRange, maxJump, name);
    }

    @Override
    public void runTreadmill(Treadmill treadmill) {
        if (treadmill.getRange() <= getMaxRange()) {
            System.out.println("Кот " + getName() + " пробежал : " + treadmill.getRange() + " метров");
        } else {
            System.out.println("Кот " + getName() + " не смог пробежать : " + treadmill.getRange() + " метров");
        }

    }

    @Override
    public void jumpWall(Wall wall) {
        if (wall.getHeight() <= getMaxJump()) {
            System.out.println("Кот " + getName() + " смог перепрыгнуть препятствие высотой : " + wall.getHeight() + " сантиметров");
        } else {
            System.out.println("Кот " + getName() + " не смог перепрыгнуть препятствие высотой : " + wall.getHeight() + " сантиметров");
        }

    }
}

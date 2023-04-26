package homework8.art2;

public class Robot extends Team {


    public Robot(int maxRange, int maxJump, String name) {
        super(maxRange, maxJump, name);
    }

    @Override
    public void runTreadmill(Treadmill treadmill) {
        if (treadmill.getRange() <= getMaxRange()) {
            System.out.println("Робот " + getName() + " пробежал : " + treadmill.getRange() + " метров");
        } else {
            System.out.println("Робот " + getName() + " не смог пробежать : " + treadmill.getRange() + " метров");
        }

    }

    @Override
    public void jumpWall(Wall wall) {
        if (wall.getHeight() <= getMaxJump()) {
            System.out.println("Робот " + getName() + " смог перепрыгнуть препятствие высотой : " + wall.getHeight() + " сантиметров");
        } else {
            System.out.println("Робот " + getName() + " смог перепрыгнуть препятствие высотой : " + wall.getHeight() + " сантиметров");
        }

    }
}

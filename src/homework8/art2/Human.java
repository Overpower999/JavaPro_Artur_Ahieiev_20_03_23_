package homework8.art2;

public class Human extends Team {
    public Human(int maxRange, int maxJump, String name) {
        super(maxRange, maxJump, name);
    }

    @Override
    public void runTreadmill(Treadmill treadmill) {
        if (treadmill.getRange() <= getMaxRange()) {
            System.out.println("Человек " + getName() + " пробежал : " + treadmill.getRange() + " метров");
        } else if (treadmill.getRange() > getMaxRange()){
            System.out.println("Человек " + getName() + " не смог пробежать : " + treadmill.getRange() + " метров");
        }

    }

    @Override
    public void jumpWall(Wall wall) {
        if (wall.getHeight() <= getMaxJump()) {
            System.out.println("Человек " + getName() + " смог перепрыгнуть препятствие высотой : " + wall.getHeight() + " сантиметров");
        } else if (wall.getHeight() > getMaxJump()){
            System.out.println("Человек " + getName() + " не смог перепрыгнуть препятствие высотой : " + wall.getHeight() + " сантиметров");
        }
    }
}

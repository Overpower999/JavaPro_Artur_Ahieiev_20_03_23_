package homework8.art2;

public abstract class Team {
    private int maxRange;
    private int maxJump;
    private String name;

    public Team(int maxRange, int maxJump, String name) {
        this.maxRange = maxRange;
        this.maxJump = maxJump;
        this.name = name;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public String getName() {
        return name;
    }

    public abstract void runTreadmill(Treadmill treadmill);
    public abstract void jumpWall(Wall wall);
}

package homework_11;

public abstract class Fruit {
    private final String name = "fruit";
    float weight;

    public Fruit(float w) {
        this.weight = w;
    }

    protected Fruit() {

    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }
}

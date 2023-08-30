package homework_11;

public class Orange extends Fruit {
    private final String name = "orange";
    float weight;

    public Orange(float w) {
        this.weight = w;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}

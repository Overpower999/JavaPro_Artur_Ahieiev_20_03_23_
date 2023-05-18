package homework_11;

public class Apple extends Fruit {
    private final String name = "apple";
    float weight;

    public Apple(float w) {
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

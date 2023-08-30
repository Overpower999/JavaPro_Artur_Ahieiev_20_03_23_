package homework_11;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    protected List<T> fruit = new ArrayList<>();

    public Box(T fruit) {
        this.fruit.add(fruit);
    }

    public String getNameFruit() {
        return fruit.stream().findFirst().get().getName();
    }

    public void add(T f) {
        if (f.getClass() == fruit.stream().findFirst().get().getClass()) {
            System.out.println("Добавлчем 1 : " + f.getName());
        } else {
            System.out.println("В эту коробку можно положить только : " + getNameFruit());
        }
    }

    public void addN(List<T> f1) {
        if (f1 != null) {
            boolean b = true;
            for (T t : f1) {
                if (t.getClass() != fruit.stream().findFirst().get().getClass()) {
                    b = false;
                }

            }
            if (b) {
                fruit.addAll(f1);
                System.out.println("Добавлен фрукт в ящик");
                getWeight();
            } else {
                System.out.println("В эту коробку можно складывать только : " + getNameFruit());
            }
        } else {
            System.out.println("Передан пустой список фруктов");
        }
    }

    public float getWeight() {
        float weightAll = 0;
        for (T t : fruit) {
            weightAll += t.getWeight();
        }
        System.out.println("Вага фруктів в коробці = " + weightAll);
        return weightAll;
    }

    public boolean compare(Box b) {
        System.out.println("Сравниваем вес коробок: ");
        if (getWeight() == b.getWeight()) {
            System.out.println("Вес коробок однаковый!");
            return true;
        } else {
            System.out.println("Вес коробок разный!");
            return false;
        }
    }

    public void merge(Box b) {
        if (b.fruit.stream().findFirst().get().getClass() ==
                fruit.stream().findFirst().get().getClass()) {
            addN(b.fruit);
            b.fruit.clear();
            System.out.println(getNameFruit() + " пересипаные в одну коробку");
        } else {
            System.out.println("В коробках разные фрукти!");
        }
    }

}

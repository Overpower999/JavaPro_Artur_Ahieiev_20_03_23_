package homework15;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> lp = new ArrayList<>();

        lp.add(new Product("Book", 200, true));
        lp.add(new Product("Book", 260, false));
        lp.add(new Product("Book", 30, true));
        lp.add(new Product("Book", 320, true));
        lp.add(new Product("Book", 60, false));
        lp.add(new Product("Toy", 70, true));
        lp.add(new Product("Toy", 2000, true));
        lp.add(new Product("Toy", 74, false));
        lp.add(new Product("Toy", 238, true));

        getBooks(lp, "Book", 250);
        productdiscount(lp, "Book", 10);
        minPrice(lp, "Book");
        getLastAdd(lp);
        calc(lp, "Book");
        groupProd(lp);

    }


    public static void getBooks(List<Product> pl, String prodType, double maxprice) {
        if (!prodType.isEmpty()) {
            if (pl.stream().anyMatch(product -> prodType.equals(product.getType()))) {
                System.out.println("Список продуктів " + prodType + " і ціною більше " + maxprice + ":");
                List<Product> products = pl.stream().filter(product -> prodType.equals(product.getType()))
                        .filter(product -> maxprice < product.getPrice())
                        .collect(Collectors.toList());
                printList(products);
            } else {
                System.out.println("Продукт " + prodType + " не знайден");
            }
        }
    }


    public static void productdiscount(List<Product> pl, String prodType, int discount) {
        if (!prodType.isEmpty()) {
            if (pl.stream().anyMatch(product -> prodType.equals(product.getType()))) {
                System.out.println("Список продуктів " + prodType + " зі знижкою " + discount + ":");
                List<Product> products = pl.stream().filter(product -> prodType.equals(product.getType()))
                        .filter(Product::isDiscount)
                        .collect(Collectors.toList());
                products.stream().forEach(product -> product.setPrice(product.getPrice() * (100 - discount) / 100));

                printList(products);
            } else {
                System.out.println("Продукт " + prodType + " не знайден");
            }
        }
    }

    public static void minPrice(List<Product> pl, String prodType) {
        if (!prodType.isEmpty()) {
            if (pl.stream().anyMatch(product -> prodType.equals(product.getType()))) {
                double minp = pl.stream().filter(product -> prodType.equals(product.getType()))
                        .min(Product::compare).get().getPrice();
                Product p = pl.stream().filter(product -> prodType.equals(product.getType()))
                        .filter(product -> product.getPrice() == minp)
                        .findAny().get();
                System.out.println("Самий дешевий продукт в категорії " + p.getType() + " з ціною " + p.getPrice());
            } else {
                System.out.println("Продукт " + prodType + " не знайден");
            }
        }
    }

    public static void getLastAdd(List<Product> pl) {
        if (pl.stream().findAny().isPresent()) {
            System.out.println("Останні 3 додані продукти:");
            List<Product> p = pl.stream().sorted(Product::compareByDate)
                    .collect(Collectors.toList()).subList(0, 3);
            printList(p);
        } else {
            System.out.println("Список продуктів пустий ");
        }
    }


    public static void calc(List<Product> pl, String prodType) {
        if (pl.stream().findAny().isPresent() && !prodType.isEmpty()) {
            printList(pl.stream().filter(product -> prodType.equals(product.getType()))
                    .collect(Collectors.toList()));
            double sumAll = pl.stream().filter(product -> prodType.equals(product.getType()))
                    .filter(product -> LocalDateTime.now().getYear() == product.getDateAdd().getYear())
                    .filter(product -> product.getPrice() <= 75)
                    .mapToDouble(Product::getPrice).sum();

            System.out.println("Загальна вартість продуктів типу" + prodType +
                    " додані протягом поточного року, з ціною не вище 75: " + sumAll);
        } else {
            System.out.println("Список продуктів пустий ");
        }
    }


    public static void groupProd(List<Product> pl) {
        if (pl.stream().findAny().isPresent()) {

            Map<String, List<Product>> map = pl.stream().collect(Collectors.groupingBy(Product::getType));

            for (Map.Entry mp : map.entrySet()) {
                System.out.println(mp.getKey());
                List<Product> l = (List<Product>) mp.getValue();
                for (Product product : l) {
                    System.out.println("{Тип: " + product.getType() +
                            ",  ціна: " + product.getPrice() +
                            ", знижка: " + product.isDiscount() +
                            ", дата додавання: " + product.getDateAdd() + "}");
                }
            }
        } else {
            System.out.println("Список продуктів пустий ");
        }
    }

    public static void printList(List<Product> products) {
        if (products.stream().findAny().isPresent()) {
            System.out.println("Тип продукту | ціна  | дата оновлення ");
            for (Product product : products) {
                String s = "            ";
                System.out.println(product.getType() + s.substring(0, 12 - product.getType().length()) + " | "
                        + product.getPrice() + " | " + product.getDateAdd());
            }
        } else {
            System.out.println("Список продуктів пустий ");
        }
    }
}

package homework12.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBook {

    List<Record> records = new ArrayList<>();

    public void add(String name, String phone) {
        if (name != null) {
            if (phone != null) {
                records.add(new Record(name, phone));
            } else {
                System.out.println("Запись не создана, указан не верный телефон " + phone);
            }
        } else {
            System.out.println("Запись не создана, указано некоректное имя " + name);
        }
    }

    public void find(String name) {
        if (name != null) {
            if (records.stream().anyMatch(record -> name.contains(record.getName()))) {
                Record rec = records.stream().filter(recordf -> name.equals(recordf.getName())).findAny().get();
                rec.printRec();
            } else {
                System.out.println("Запис з іменем " + name + " не знайдено");
            }
        } else {
            System.out.println("Ім'я не передано (null)");
        }
    }

    public void findAll(String name) {
        if (name != null) {
            System.out.println("Шукаємо всі записи по імені");
            if (records.stream().anyMatch(record -> name.contains(record.getName()))) {
                List<Record> recs = records.stream().filter(
                        recordf -> name.equals(recordf.getName())).toList();
                for (Record r : recs) {
                    r.printRec();
                }
            } else {
                System.out.println("Записів з іменем " + name + " не знайдено");
            }
        } else {
            System.out.println("Ім'я не передано (null)");
        }
    }

}


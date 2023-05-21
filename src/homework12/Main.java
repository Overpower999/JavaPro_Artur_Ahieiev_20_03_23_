package homework12;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> flist = new ArrayList();
        flist.add("apple");
        flist.add("melon");
        flist.add("juice");
        flist.add("apple");
        flist.add("tree");
        flist.add("apple");
        flist.add("tree");
        flist.add("freeeedom");

        countOccurance(flist, "apple");

        int[] num = new int[]{1, 2, 3};

        toList(num);

        ArrayList<Double> flist1 = new ArrayList();
        flist1.add(1.2);
        flist1.add(1.2);
        flist1.add(1.2);
        flist1.add(2.3);
        flist1.add(2d);
        flist1.add(1d);
        flist1.add(5.8);
        flist1.add(7.9);
        flist1.add(9.8);
        findUnique(flist1);

        calcOccurance(flist);
        findOccurance(flist);

    }

    public static void countOccurance(ArrayList<String> a, String b) {
        int count = Collections.frequency(a, b);
        System.out.println("Слово " + b + " встречается " + count + " раз");
    }

    public static void toList(int[] a) {
        List<Integer> arrayList = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(arrayList);
    }

    public static void findUnique(ArrayList<Double> list) {
        List<Double> a = list.stream().distinct().collect(Collectors.toList());
        System.out.println(a);
    }

    public static void calcOccurance(ArrayList<String> arrayList) {
        List<String> a = arrayList.stream().distinct().collect(Collectors.toList());
        for (String s : arrayList) {
            System.out.println("Слово " + s + " встречается " + Collections.frequency(arrayList, s));
        }
    }

    public static void findOccurance(ArrayList<String> arrayList) {
        List<ListWords> uniqueList = new ArrayList<>();
        Set<String> uniqueValue = new HashSet<>();
        for (String s : arrayList) {
            if (uniqueValue.add(s)) {
                uniqueList.add(new ListWords(s, Collections.frequency(arrayList, s)));
            }
        }
        System.out.println("[");
        for (ListWords l1 : uniqueList) {
            l1.print();
        }
        System.out.println("]");
    }
}

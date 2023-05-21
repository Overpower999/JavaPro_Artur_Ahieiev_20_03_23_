package homework12;

public class ListWords {
    String name;
    int occurrence;

    public ListWords(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public void print() {
        System.out.println("{name: " + name + ", occurrence: " + occurrence + "}");
    }
}

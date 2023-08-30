package homework7;

public class ArrayValueCalculator {
    static int doCalc(String[][] arr) throws ArraySizeExeption, ArrayDataException {
        if (arr.length == 4 && arr[0].length == 4) {
            System.out.println("Длина масива правильная");
        } else {
            throw new ArraySizeExeption("Длина массива неправильная");
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new ArraySizeExeption("Длина массива неправильная");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("нельзя преобразовать ячейку " + i + "x" + j);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        try {
            int result = doCalc(new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"9", "10", "11", "12"}});
            System.out.println(result);
        } catch (ArraySizeExeption | ArrayDataException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            int result = doCalc(new String[][]{{"1", "a", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"9", "10", "11", "12"}});
            System.out.println(result);
        } catch (ArraySizeExeption | ArrayDataException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            int result = doCalc(new String[][]{{"1", "a", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}});
            System.out.println(result);
        } catch (ArraySizeExeption | ArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

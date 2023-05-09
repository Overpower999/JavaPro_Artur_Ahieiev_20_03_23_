package homework10;

public class ValueCalculator {
    private float[] array;
    private int size = 1000000;
    private int halfSize = size / 2;

    public ValueCalculator() {
        array = new float[size];
    }

    public float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public void runArrayCalculate() {
        long start = System.currentTimeMillis();
        float[] array2 = new float[halfSize];
        float[] array3 = new float[halfSize];
        for (int i = 0; i < array.length; i++) array[i] = 1.0f;
        System.arraycopy(array, 0, array2, 0, halfSize);
        System.arraycopy(array, halfSize, array3, 0, halfSize);

        new Thread() {
            public void run() {
                float[] a = calculate(array2);
                System.arraycopy(a, 0, array2, 0, a.length);
            }
        }.start();
        new Thread() {
            public void run() {
                float[] a2 = calculate(array3);
                System.arraycopy(a2, 0, array3, 0, a2.length);
            }
        }.start();
        System.arraycopy(array2, 0, array, 0, array2.length);
        System.arraycopy(array3, 0, array, halfSize, halfSize);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void main(String[] args) {
        ValueCalculator valueCalculator = new ValueCalculator();
        valueCalculator.runArrayCalculate();
    }

}

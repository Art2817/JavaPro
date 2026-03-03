package dz19;

import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Початковий масив:");
        System.out.println(Arrays.toString(array));
        ArrayUtils.mergeSort(array);
        System.out.println("Відсортований масив:");
        System.out.println(Arrays.toString(array));

        int target = array[3];
        int index = ArrayUtils.binarySearch(array, target);
        if (index != -1) {
            System.out.println("За індексом " + index + " знайдено число " + target);
        } else {
            System.out.println("Число не знайдено");
        }
    }
}
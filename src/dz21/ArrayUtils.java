package dz21;

import java.util.Random;

public class ArrayUtils {

    @MethodInfo(
            name = "randomNumbers",
            returnType = "int[]",
            description = "Generate array with random number"
    )
    @Author(
            firstName = "Artem",
            lastName = "Ch"
    )
    public int[] randomNumbers(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    @MethodInfo(
            name = "printArray",
            returnType = "String",
            description = "Prints numbers"
    )
    @Author(
            firstName = "Artem",
            lastName = "Ch"
    )
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
package dz21;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        ArrayUtils utils = new ArrayUtils();
        int[] array = utils.randomNumbers(10);

        System.out.println("Generated array:");
        utils.printArray(array);
        System.out.println("\nAnnotation information:\n");
        Method[] methods = ArrayUtils.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodInfo.class)) {

                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                Author author = method.getAnnotation(Author.class);

                System.out.println("Method: " + methodInfo.name());
                System.out.println("Return type: " + methodInfo.returnType());
                System.out.println("Description: " + methodInfo.description());
                System.out.println("Author: " + author.firstName() + " " + author.lastName() + "\n");
            }
        }
    }
}
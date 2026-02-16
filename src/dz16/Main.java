package dz16;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        FunctionalInterfaces.MathOperation addition = new FunctionalInterfaces.MathOperation() {
            public int operate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Addition result: " + addition.operate(5, 3));


        FunctionalInterfaces.StringManipulator toUpperCase = s -> s.toUpperCase();
        System.out.println("Uppercase: " + toUpperCase.manipulate("cherednychenko"));



        Function<String, Integer> counter = StringListProcessor::countUppercase;
        System.out.println("Uppercase count: " + counter.apply("CheREDnyChENKo"));

        Supplier<Integer> randomSupplier = () -> RandomNumberGenerator.generateRandomNumber(1, 100);
        System.out.println("Random number: " + randomSupplier.get());
    }
}
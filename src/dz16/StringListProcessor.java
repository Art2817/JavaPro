package dz16;

public class StringListProcessor {
    public static int countUppercase(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }
}

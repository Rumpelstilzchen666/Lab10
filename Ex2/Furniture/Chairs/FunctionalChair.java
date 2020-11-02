package Ex2.Furniture.Chairs;

public class FunctionalChair implements
        Ex2.Furniture.Styles.FunctionalFurniture, Chair {
    public static final int legCount = 3; // Чтобы не качался

    public static boolean sum(boolean a, boolean b) {
        return a || b;
    }

    public static int sum(char a, char b) {
        return a + b;
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static long sum(long a, long b) {
        return a + b;
    }

    public static String sum(double a, String b) {
        return a + b;
    }

    public static String sum(long a, String b) {
        return a + b;
    }

    public static String sum(String a, double b) {
        return a + b;
    }

    public static String sum(String a, long b) {
        return a + b;
    }

    public static String sum(String a, String b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "Функциональный стул.";
    }
}

package Ex2.Furniture.Chairs;

public class VictorianChair implements Ex2.Furniture.Styles.VictorianFurniture,
        Chair {
    public static final int legCount = DEFAULT_LEG_COUNT;
    private final int age;

    public VictorianChair(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Викторианский стул (сделан " + age + " лет назад).";
    }
}

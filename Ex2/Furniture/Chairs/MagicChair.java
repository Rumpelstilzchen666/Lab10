package Ex2.Furniture.Chairs;

import java.util.Random;

public class MagicChair implements Ex2.Furniture.Styles.MagicFurniture, Chair {
    public int legCount = DEFAULT_LEG_COUNT;
    private static final Random rand = new Random();

    public void doMagic() {
        legCount = Math.abs(rand.nextInt()) % 5 + 2;
        System.out.println("Вуаля, теперь у стула " + legCount + " нож" +
                (legCount < 5 ? "ки" : "ек") + '!');
    }

    @Override
    public String toString() {
        return "Магический стул (у него " + legCount + " нож" +
                (legCount < 5 ? "ки" : "ек") + ").";
    }
}

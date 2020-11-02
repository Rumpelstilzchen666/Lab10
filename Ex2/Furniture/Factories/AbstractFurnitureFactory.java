package Ex2.Furniture.Factories;

import Ex2.Furniture.Styles.*;

import java.util.Calendar;
import java.util.Random;

public abstract class AbstractFurnitureFactory {
    protected static final Calendar calendar = Calendar.getInstance();
    protected static final Random rand = new Random();

    protected static int getVictorianYear() {
        calendar.setTime(new java.util.Date());
        return calendar.get(Calendar.YEAR) - VictorianFurniture.START -
                (Math.abs(rand.nextInt()) %
                        (VictorianFurniture.END + 1 - VictorianFurniture.START));
    }

    public abstract FunctionalFurniture createFunctionalFurniture();

    public abstract MagicFurniture createMagicFurniture();

    public abstract VictorianFurniture createVictorianFurniture();
}

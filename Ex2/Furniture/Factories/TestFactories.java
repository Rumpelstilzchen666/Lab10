package Ex2.Furniture.Factories;

import Ex2.Furniture.Chairs.*;
import Ex2.Furniture.Styles.VictorianFurniture;

import java.util.Calendar;

public class TestFactories {
    public static boolean testFactories(boolean detailedReport) {
        boolean testOk = true;
        if(detailedReport) {
            System.out.println("Тест фабрики стульев!");
            System.out.println("Тест созданных стульев:");
        }
        AbstractFurnitureFactory cFactory = new ChairFactory();
        testOk = testOk && TestChairs.testFunctionalChair(
                (FunctionalChair) cFactory.createFunctionalFurniture(),
                detailedReport);
        testOk = testOk && TestChairs.testMagicChair((MagicChair) cFactory.createMagicFurniture(),
                detailedReport);
        testOk = testOk && TestChairs.testVictorianChair(
                (VictorianChair) cFactory.createVictorianFurniture(),
                detailedReport);

        if(detailedReport)
            System.out.println("Тест диапазона чисел у викторианских стульев:");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date());
        int year = calendar.get(Calendar.YEAR);
        cFactory = new ChairFactory();
        VictorianChair vChair;
        int nMore = 0, nLess = 0;
        for(int i = 0; i < 1000; i++) {
            vChair = (VictorianChair) cFactory.createVictorianFurniture();
            if(year - VictorianFurniture.START < vChair.getAge()) {
                if(detailedReport)
                    System.out.println(year - VictorianFurniture.START +
                            " !< " + vChair.getAge());
                nMore++;
            }
            if(year - VictorianFurniture.END > vChair.getAge()) {
                if(detailedReport)
                    System.out.println(year - VictorianFurniture.END + " !> " +
                            vChair.getAge());
                nLess++;
            }
        }
        if(detailedReport && (nLess != 0 || nMore != 0))
            System.out.println("nLess = " + nLess + "nMore = " + nMore +
                    "\n\n");
        return testOk && nLess == 0 && nMore == 0;
    }
}

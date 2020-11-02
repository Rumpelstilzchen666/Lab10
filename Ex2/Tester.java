package Ex2;

import Ex2.Client.Client;
import Ex2.Furniture.Chairs.Chair;
import Ex2.Furniture.Chairs.TestChairs;
import Ex2.Furniture.Factories.*;
import Ex2.Furniture.Furniture;

public class Tester {
    public static final String sep =
            "------------------------------------------------------------\n";

    public static void main(String[] args) {
        boolean testOk = true;
        testOk = testOk && TestChairs.testChairs(true);
        testOk = testOk && TestFactories.testFactories(true);

        AbstractFurnitureFactory chairFactory = new ChairFactory();
        Furniture[] chairs = {chairFactory.createFunctionalFurniture(),
                chairFactory.createMagicFurniture(),
                chairFactory.createVictorianFurniture()};
        Client client;
        for(int i = 0; i < 3; i++) {
            client = new Client();
            client.setChair((Chair) chairs[i]);
            testOk = testOk && client.sit();
        }
        client = new Client();
        testOk = testOk && !client.sit();
        System.out.println(Ex2.Tester.sep + "Тестирование окончено " +
                (testOk ? "" : "без") + "успешно!");
    }
}

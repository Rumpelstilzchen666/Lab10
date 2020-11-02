package Ex2.Furniture.Chairs;

public class TestChairs {
    public static boolean testChairs(boolean printReport) {
        if(printReport)
            System.out.println("Тестирование стульев:");
        boolean testOk = true;
        FunctionalChair fChair = new FunctionalChair();
        testOk = testOk && testFunctionalChair(fChair, printReport);

        MagicChair mChair = new MagicChair();
        testOk = testOk && testMagicChair(mChair, printReport);

        VictorianChair vChair = new VictorianChair(0);
        testOk = testOk && testVictorianChair(vChair, printReport);

        if(printReport)
            System.out.println(Ex2.Tester.sep +
                    "Тестирование стульев окончено " +
                    (testOk ? "" : "без") + "успешно!\n\n\n");
        return testOk;
    }

    public static boolean testFunctionalChair(FunctionalChair chair,
            boolean detailedReport) {
        if(detailedReport) {
            System.out.println("Тестирование функционального стула:");
            System.out.println(chair);
        }
        boolean testOk = true;
        if(-5 != FunctionalChair.sum(-5, -0)) {
            if(detailedReport)
                System.out.println("-5 != -5 + (-0) == " +
                        FunctionalChair.sum(-5, -0));
            testOk = false;
        }
        if(150 != FunctionalChair.sum('2', 'd')) {
            if(detailedReport)
                System.out.println("150 != '2' + 'd' == " +
                        FunctionalChair.sum('2', 'd'));
            testOk = false;
        }
        if(77.777777 != FunctionalChair.sum(1.234567, 76.54321)) {
            if(detailedReport)
                System.out.println("77.777777 != 1.234567 + 76.54321 == " +
                        FunctionalChair.sum(1.234567, 76.54321));
            testOk = false;
        }
        if(!"12345".equals(FunctionalChair.sum("123", 45))) {
                System.out.println("\"12345\" != \"123\" + 45 == " +
                        FunctionalChair.sum("123", 45));
            testOk = false;
        }
        if(detailedReport)
            System.out.println(Ex2.Tester.sep +
                    "Тестирование функционального стула окончено " +
                    (testOk ? "" : "без") + "успешно!\n\n");
        return testOk;
    }

    public static boolean testMagicChair(MagicChair chair,
            boolean detailedReport) {
        if(detailedReport) {
            System.out.println("Тестирование магического стула:");
            System.out.println(chair);
        }
        boolean testOk = true;
        for(int i = 0; i < 20; i++) {
            chair.doMagic();
            if(chair.toString().charAt(24) < '2' ||
                    chair.toString().charAt(24) > '6')
                testOk = false;
        }
        if(detailedReport)
            System.out.println(Ex2.Tester.sep +
                    "Тестирование магического стула окончено " +
                    (testOk ? "" : "без") + "успешно!\n\n");
        return testOk;
    }

    public static boolean testVictorianChair(VictorianChair chair,
            boolean detailedReport) {
        if(detailedReport) {
            System.out.println("Тестирование викторианского стула:");
            System.out.println(chair);
        }
        boolean testOk = true;
        for(double i = 0.1; i < 1000000; i *= 10) {
            chair = new VictorianChair((int) i);
            if((int) i != chair.getAge()) {
                testOk = false;
                System.out.println((int) i + " != vChair.getAge() == "
                        + chair.getAge());
            }
        }
        if(detailedReport)
            System.out.println(Ex2.Tester.sep +
                    "Тестирование викторианского стула окончено " +
                    (testOk ? "" : "без") + "успешно!\n\n");
        return testOk;
    }
}

package Ex2.Furniture.Factories;

import Ex2.Furniture.Chairs.*;
import Ex2.Furniture.Styles.*;

public class ChairFactory extends AbstractFurnitureFactory {
    @Override
    public FunctionalFurniture createFunctionalFurniture() {
        return new FunctionalChair();
    }

    @Override
    public MagicFurniture createMagicFurniture() {
        return new MagicChair();
    }

    @Override
    public VictorianFurniture createVictorianFurniture() {
        return new VictorianChair(getVictorianYear());
    }
}

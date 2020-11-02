package Ex2.Client;

import Ex2.Furniture.Chairs.Chair;

public class Client {
    private Chair chair = null;

    public final void setChair(Chair chair) {
        this.chair = chair;
    }

    public boolean sit() {
        System.out.println("Клиент садится на стул.");
        if(chair == null) {
            System.out.println("Клиент упал (стула нет).");
            return false;
        }
        else {
            System.out.println("Клиент сел на " + chair.toString());
            return true;
        }
    }
}

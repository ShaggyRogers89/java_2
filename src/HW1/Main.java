package HW1;

public class Main {
    public static void main(String[] args) {
        Obstructionable[] ob1 = new Obstructionable[]{
                new Treadmill("Treadmill"),
                new Wall("Wall1"),
                new Wall("Wall2")
        };


        RunJumpable[] r1 = {
                new Cat("Barsik"),
                new Human("Bob"),
                new Robot("Elon")
        };

        for (Obstructionable o :
                ob1) {
            o.obstructionable(r1);
        }

    }
}

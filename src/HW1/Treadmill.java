package HW1;

public class Treadmill implements Obstructionable{
    private String name;

    public Treadmill(String name) {
        this.name = name;
    }


    @Override
    public void obstructionable(RunJumpable[] r) {
        for (int i = 0; i < r.length; i++) {
            r[i].run();
            System.out.println(name);
        }
    }


}


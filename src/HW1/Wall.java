package HW1;

public class Wall implements Obstructionable {
    private String name;

    public Wall(String name) {
        this.name = name;
    }

    @Override
    public void obstructionable(RunJumpable[] r) {
        for (int i = 0; i < r.length; i++) {
            r[i].jump();
            System.out.println(name);
        }
    }

}

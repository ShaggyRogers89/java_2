package HW1;


public class Human implements RunJumpable {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Human " + name + " run");
    }

    @Override
    public void jump() {
        System.out.println("Human " + name + " jump");
    }




}

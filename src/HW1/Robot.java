package HW1;

public class Robot implements RunJumpable {
    private String name;


    public Robot(String name) {
        this.name = name;

    }

    @Override
    public void run() {
        System.out.println("Robot " + name + " run");
    }

    @Override
    public void jump() {
        System.out.println("Robot " + name + " jump");
    }


}

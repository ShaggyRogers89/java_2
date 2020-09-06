package HW1;

public class Cat implements RunJumpable{
    private String name;


    public Cat(String name) {
        this.name = name;

    }

    @Override
    public void run() {
        System.out.println("Cat " + name + " run");
    }

    @Override
    public void jump() {
        System.out.println("Cat " + name + " jump");
    }


}

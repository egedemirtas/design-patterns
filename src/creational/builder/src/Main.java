import model.PC;

public class Main {
    public static void main(String[] args) {
        PC pc = new PC.PCBuilder().setColor("black").setCpu("Nvidia").build();
        System.out.println("PC created: " + pc);
    }
}
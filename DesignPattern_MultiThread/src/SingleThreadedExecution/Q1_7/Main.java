package SingleThreadedExecution.Q1_7;
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Gate, hit CTRL+C to exit.");
        Gate gate = new Gate();

        new UserThread(gate, "Alice", "AAA").start();
        new UserThread(gate, "Brown", "BBB").start();
        new UserThread(gate, "Craon", "CCC").start();
    }
}


public class LambdaDemo {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running");
            }
        };
        r.run();

        String lambdaExample = " Lambda example!";
        Runnable r1 = () -> System.out.println("Running" + lambdaExample);
        r1.run();
    }
}

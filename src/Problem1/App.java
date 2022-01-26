package Problem1;
public class App {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i <= 100; i++) {
            System.out.print(i + " ");
            if (i%3 == 0) {
                System.out.print("Tri ");
            }
            if (i%5 == 0) {
                System.out.print("Max ");
            }
            System.out.println();
        }
    }
}

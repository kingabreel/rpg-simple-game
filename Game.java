import java.util.Scanner;

public class Game {
    static long xp = 0;
    static String name;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
         System.out.print("Hello strange, how can I call you? ");
         name = scanner.nextLine();

         initGame();
    }

    private static void initGame(){

    }
}
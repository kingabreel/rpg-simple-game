import java.util.Scanner;

public class Game {
    static long xp = 0;
    static String name;
    static Scanner scanner = new Scanner(System.in);
    static boolean gameRunning = false;
    static String[] monsterName = new String[30];
    static int[] xpNumber = new int[30];
    public static void main(String[] args) {
         System.out.print("Hello strange, how can I call you? ");
         name = scanner.nextLine();

         monsterNames();
         System.out.println(monsterName[3]);
    }

    private static void initGame(){
        //monsterName = monsterNames();
        System.out.println("Each round you will find a monster, you have to defeat him.\n");

        while(gameRunning){

        }
    }

    private static void monsterNames(){
        String[] monsterName = {
            "Dragão das Sombras",
            "Espectro de Gelo",
            "Grifo de Fogo",
            "Górgona de Pedra",
            "Lobisomem Lunar",
            "Banshee da Floresta",
            "Homem-Serpente",
            "Quimera das Trevas",
            "Manticora Sombria",
            "Esqueleto Maldito",
            "Elfo Noturno",
        };
    }
    private static void xpInit(){
        int[] xp = {
                1000,
                800,
                1200,
                600,
                750,
                900,
                500,
                1100,
                950,
                400,
                700,
        };
    }

}
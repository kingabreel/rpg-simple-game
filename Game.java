import java.util.Random;
import java.util.Scanner;

public class Game {
    static long xp = 0;
    static String name;
    static Scanner scanner = new Scanner(System.in);
    static boolean gameRunning = false;
    static String[] monsterName = new String[11];
    static int[] xpNumber = new int[11];
    public static void main(String[] args) {
         System.out.print("Hello strange, how can I call you? ");
         name = scanner.nextLine();

         initGame();
    }

    private static void initGame(){
        monsterName = monsterNames();
        int[] monsterHp = hpInit();
        Random random = new Random();

        System.out.println("Each round you will find a monster, you have to defeat him.\n");
        boolean monsterAlive = true;

        while(gameRunning){
            int randomIndex = random.nextInt(11);
            String battleMonster = monsterName[randomIndex];
            int xpNum = xpNumber[randomIndex];
            int hp = monsterHp[randomIndex];

            System.out.println("Monster found: " + battleMonster);

            while(monsterAlive){
                if(hp <= 0){
                    hp = 0;
                    monsterAlive = false;

                    System.out.println(xpNum + " xp recebidos");
                }

                System.out.print("What would you like to do:\n1-Attack\n2-Defend\n3-Run");

                int userChoice = scanner.nextInt();

                if(userChoice == 1){
                    int hp1 = hp;
                    hp -= random.nextInt(10);
                    System.out.println(hp1-hp + " hit on monster");
                } else if (userChoice == 2){
                    System.out.println("Defended");
                } else if (userChoice == 3){
                    System.out.println("Running");
                    System.out.println("You do not receive any xp");
                }
            }
        }
    }

    private static String[] monsterNames(){
        String[] monsterNames = {
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
            "Elfo Noturno"
        };
        return monsterNames;
    }
    private static int[] hpInit(){
        int[] hp = {
                30,
                25,
                20,
                40,
                100,
                10,
                40,
                60,
                8,
                35,
                75
        };
        return hp;
    }

    private static int[] xpInit(){
        int[] monsterXP = {
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
    }

}
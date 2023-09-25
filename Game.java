import java.util.Random;
import java.util.Scanner;

public class Game {
    static long xp = 0;
    static String name;
    static int hp;
    static String heroClass;
    static Scanner scanner = new Scanner(System.in);
    static boolean gameRunning = false;
    static String[] monsterName = new String[11];
    static int[] monsterHp = new int[11];
    static int[] monsterXp = new int[11];

    public static void main(String[] args) {
         System.out.print("Hello strange, how can I call you? ");
         name = scanner.nextLine();

         initGame();
    }

    private static void initGame(){
        monsterName = monsterNames();
        monsterHp = hpInit();
        monsterXp = xpInit();

        Random random = new Random();

        System.out.println("Each round you will find a monster, you have to defeat him.\n");
        boolean monsterAlive = true;

        while(gameRunning){
            heroClassChecker();

            int randomIndex = random.nextInt(11);
            String battleMonster = monsterName[randomIndex];
            int xpNum = monsterXp[randomIndex];
            int hp = monsterHp[randomIndex];

            System.out.println("Monster found: " + battleMonster);

            while(monsterAlive){
                if(hp <= 0){
                    hp = 0;
                    monsterAlive = false;

                    System.out.println(xpNum + " xp recebidos");
                    xp += xpNum;
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
                    monsterAlive = false;
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
        };
        return monsterXP;
    }

    private static void heroClassChecker(){
        if (xp < 1000){
            heroClass = "Ferro";
            hp = 50;
        } else if (xp > 1000 && xp <= 2000){
            heroClass = "Bronze";
            hp = 100;
        } else if (xp > 2000 && xp <= 5000){
            heroClass = "Prata";
            hp = 130;
        } else if (xp > 5000 && xp <= 6000){
            heroClass = "Ouro";
            hp = 170;
        } else if (xp > 6000 && xp <= 8000){
            heroClass = "Platina";
            hp = 250;
        } else if (xp > 8000 && xp <= 9000){
            heroClass = "Ascendente";
            hp = 300;
        } else if (xp > 9000 && xp <= 10500){
            heroClass = "Imortal";
            hp = 500;
        } else if (xp > 10000){
            heroClass = "Radiante";
            hp = 1000;
        }
    }
}
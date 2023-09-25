import java.util.Random;
import java.util.Scanner;

public class Game {
    static long xp = 0;
    static String name;
    static String heroType;
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
        System.out.println("What are you skills, what are you? \n1- Mage\n2- Warrior\n3- Monk\n4- Ninja");
        int userChoice = scanner.nextInt();

        heroType = (userChoice == 1) ? "Mage" : (userChoice == 2) ? "Warrior" : (userChoice == 3) ? "Monk" : (userChoice == 4) ? "Ninja" : "unknown";
        if (userChoice > 0 && userChoice < 5){
            initGame();
        }
    }

    private static void initGame(){
        monsterName = monsterNames();
        monsterHp = hpInit();
        monsterXp = xpInit();

        Random random = new Random();

        System.out.println("Each round you will find a monster, you have to defeat him.\n");
        gameRunning = true;
        while(gameRunning){
            heroClassChecker();

            int randomIndex = random.nextInt(11);
            String battleMonster = monsterName[randomIndex];
            int xpNum = monsterXp[randomIndex];
            int hpMonster = monsterHp[randomIndex];

            System.out.println("Monster found: " + battleMonster);
            boolean monsterAlive = true;

            while(monsterAlive){
                if(hpMonster <= 0){
                    hpMonster = 0;
                    monsterAlive = false;

                    System.out.println(xpNum + " xp recebidos");
                    xp += xpNum;
                }
                if (hp <= 0){
                    System.out.println("You are defeated.");
                    gameRunning = false;
                }

                System.out.print("What would you like to do:\n1-Attack\n2-Defend\n3-Run\n");

                int userChoice = scanner.nextInt();

                if(userChoice == 1){
                    int hp1 = hpMonster;
                    hpMonster -= random.nextInt(10);

                    System.out.println("===============\n");
                    System.out.println(heroType + " " + name + attackType());
                    System.out.println(hp1-hpMonster + " hit on monster");
                    System.out.println("\n===============");


                    int hp2 = hp;
                    hp -= random.nextInt(10);
                    System.out.println(battleMonster + " has attacked you, " + (hp2-hp) + " damage received");
                } else if (userChoice == 2){
                    System.out.println("Defended");

                    int hp2 = hp;
                    hp -= random.nextInt(5);
                    System.out.println(battleMonster + " has attacked you, " + (hp2-hp) + " damage received");
                } else if (userChoice == 3){
                    System.out.println("Running");
                    System.out.println("You do not receive any xp");
                    monsterAlive = false;
                } else if (userChoice == 0){
                    monsterAlive = false;
                    gameRunning = false;
                }
            }
        }
        System.out.println("O herói de nome " + name + " chegou ao nível " + heroClass);
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

    private static String attackType(){
        if(heroType.equals("Mage")){
            return " used magic to summon fire";
        } else if (heroType.equals("Warrior")){
            return " used sword to attack";
        } else if (heroType.equals("Monk")){
            return " used his hands to puch";
        } else if (heroType.equals("Ninja")){
            return " used his shuriken with poison to attack";
        }
        return "attacked";
    }
}
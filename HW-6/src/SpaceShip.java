import java.util.Random;
import java.util.Scanner;

public class SpaceShip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int asteroidsCount = 0;

        int x = 0;
        int y = 0;

        int oxygen = 200;
        int fuel = 100;

        String command = "";

        int armX = 1;
        int armY = 1;

        int target = 0;
        int magicNumber = 0;
        int magicNumber2 = 0;
        int guess = 0;

        int processedAsteroids = 0;
        int resources = 0;

        boolean scanned = false;
        boolean gameOver = false;

        System.out.println("How many asteroids would you like  to process?");
        asteroidsCount = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= asteroidsCount; i++) {

            x = random.nextInt(50) + 1;
            y = random.nextInt(50) + 1;

            System.out.printf("Asteroid %d is located at X - %d and Y - %d!\n", i, x, y);

            if (i == 1) {
                while (true) {

                    command = sc.nextLine();

                    if (!command.equals("launch")) {
                        System.out.println("The spaceship has not been launched into space!");
                        continue;
                    } else {
                        System.out.println("The spaceship has been launched into space!");
                        break;
                    }
                }
            }

            command = sc.nextLine();

            while (true) {

                if (command.equals("moveX")) {

                    command = sc.nextLine();
                    target = Integer.parseInt(sc.nextLine());

                    oxygen -= Math.abs(target - armX);
                    armX = target;

                    if (oxygen <= 24) {
                        System.out.println("You have reached critically low levels of oxygen!");
                        gameOver = true;
                        break;
                    }

                } else if (command.equals("moveY")) {

                    command = sc.nextLine();
                    target = Integer.parseInt(sc.nextLine());

                    oxygen -= Math.abs(target - armY);
                    armY = target;

                    if (oxygen <= 24) {
                        System.out.println("You have reached critically low levels of oxygen!");
                        gameOver = true;
                        break;
                    }

                }  else if (command.equals("scan")) {

                    magicNumber = random.nextInt(15) + 1;

                    System.out.println("The asteroid has been identified!");
                    scanned = true;


                } else if(command.equals("mine")) {

                    if (fuel <= 0) {
                        System.out.println("Not enough fuel, please tank!");
                        gameOver = true;
                        break;
                    }

                    if(!scanned) {

                        System.out.println("Incorrect order of the commands! First identify the asteroid!");

                    }else {

                        magicNumber2 = random.nextInt(20) + 1;
                        System.out.println("I generated a number in the range 1 - 20. Guess it in order for me to start processing the asteroid.");
                        guess = Integer.parseInt(sc.nextLine());

                        while(guess != magicNumber2){
                            fuel -= 3;

                            System.out.println("Incorrect answer, try again!");
                            guess = Integer.parseInt(sc.nextLine());
                        }

                        System.out.printf("The processing of the asteroid with coordinates  %d and %d for natural resources is done.\n", x, y);
                        resources += magicNumber * 2;

                        processedAsteroids++;
                        break;
                    }

                }else if (command.equals("return")) {

                    if (fuel < 10) {
                        System.out.println("Insufficient fuel to perform this action!");
                    } else {
                        fuel -= 10;
                        System.out.printf("Fuel level is %d liters!\n", fuel);
                        System.out.printf("Oxygen level is %d hours!\n", oxygen);
                        System.out.printf("Processed asteroids are: %d!\n", processedAsteroids);
                        System.out.printf("Resources: %d!\n", resources);
                        gameOver = true;
                        break;
                    }
                } else if(command.equals("report")){

                    System.out.printf("Fuel level is %d liters!\n", fuel);
                    System.out.printf("Oxygen level is %d hours!\n", oxygen);
                    System.out.printf("Processed asteroids are: %d!\n", processedAsteroids);
                    System.out.printf("Resources: %d!\n", resources);
                }

                command = sc.nextLine();

            }

            if(gameOver) {
                break;
            }
        }
        if (!gameOver) {
            System.out.println("The space mission has been completed successfully!");
        }
    }
}

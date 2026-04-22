import java.util.Scanner;
import java.time.LocalDate;
import java.util.Random;

public class ClientNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int d1, d2, d3, d4, d5, d6, d7, d8, d9;
        System.out.println("Enter the year you were born. ");
        int year = Integer.parseInt(sc.nextLine());

        int currentYear = LocalDate.now().getYear();
        int age = currentYear - year;

        // first digit1
        if (year == 1965) {
            d1 = 0;
        } else {

            int value1 = age / (rand.nextInt(7) + 1);

            if (value1 > 9) {
                value1 /= 10;
            }

            if (year < 1965) {
                if (value1 % 2 == 0) {
                    value1++;
                }
            } else {
                if (value1 % 2 != 0){
                    value1++;
                }
            }

            d1 = value1;

        }
        System.out.println("First digit: " + d1);

        //second digit generator
        if(d1 != 0){
            System.out.println("Enter your gender - male, female or none");
            String gender = sc.nextLine();

            switch(gender){
                case "male":
                    d2 = 1;
                    break;
                case "female":
                    d2 = 3;
                    break;
                case "none":
                    int value2;
                    do {
                        value2 = rand.nextInt(9) + 1;
                    } while (value2 == 1 || value2 == 3);

                    d2 = value2;
                    break;
                default:
                    d2 = 9;
                    break;
            }
        }else{
            d2 = 9;
        }

        System.out.println("Second digit: " + d2);

        //third digit generator
        int motherYear;
        int fatherYear;
        if (age < 18){
            System.out.println("Enter the year your mother was born in.");
            motherYear = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the year your father was born in.");
            fatherYear = Integer.parseInt(sc.nextLine());

            int mDigit = motherYear % 10;
            int fDigit = fatherYear % 10;

            if(mDigit == fDigit){
                d3 = (motherYear / 10) % 10;
            }else{
                d3 = fDigit;
            }
        }else{
            d3 = 0;
        }
        System.out.println("Third digit: " + d3);

        //fourth digit generator
        System.out.println("Enter your height in cm.");
        double height = Double.parseDouble(sc.nextLine());
        double heightM = height / 100;
        System.out.println("Enter your weight in kg.");
        double  weight = Double.parseDouble(sc.nextLine());

        double bmi = weight / Math.pow(heightM, 2);

        if (bmi < 16) d4 = 1;
        else if (bmi < 17) d4 = 2;
        else if (bmi < 18.5) d4 = 3;
        else if (bmi < 25) d4 = 4;
        else if (bmi < 30) d4 = 5;
        else if (bmi < 35) d4 = 6;
        else if (bmi < 40) d4 = 7;
        else d4 = 8;

        System.out.println("Fourth digit: " + d4);

        //fifth digit
        System.out.println("Choose a product and enter its number.");
        System.out.println("1.Veggies and fruits 2.Мeat 3.Alkolhol and cigarettes 4.Milk 5.Sweets");
        int product = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the consumption range: 1.rarely 2.sometimes 3.often ");
        int freq = Integer.parseInt(sc.nextLine());

        d5 = product + freq;

        System.out.println("Fifth digit: " + d5);

        //sixth digit generator
        int sum = d1 + d2 + d3 + d4 + d5;

        while (sum > 9) {
            int temp = 0;

            while (sum > 0) {
                temp += sum % 10;
                sum /= 10;
            }

            sum = temp;
        }

        d6 = sum;

        System.out.println("Sixth digit: " + d6);

        //seventh digit generator
        int sum6 = d1 + d2 + d3 + d4 + d5 + d6;

        if (sum6 > 10) {
            d7 = 7;
        }
        else if (sum6 < 10) {
            d7 = 6;
        }
        else if (d1 < d2 && d2 < d3 && d3 < d4 && d4 < d5 && d5 < d6) {
            d7 = 5;
        }
        else if (d1 == d2 && d2 == d3 && d3 == d4 && d4 == d5 && d5 == d6) {
            d7 = 4;
        }
        else if ((d1 % 2 == 0 && d2 % 2 == 0) ||
                (d3 % 2 != 0 && d4 % 2 != 0 && d5 % 2 != 0)) {
            d7 = 3;
        }
        else if (d1 % 2 == 0 && d3 % 2 == 0 && d5 % 2 == 0) {
            d7 = 0;
        }
        else if (d1 % 2 != 0 && d3 % 2 != 0 && d5 % 2 != 0) {
            d7 = 1;
        }
        else if (d1 % 2 == 0 || d3 % 2 == 0 || d5 % 2 == 0) {
            d7 = 2;
        }
        else {
            d7 = 9;
        }

        System.out.println("Seventh digit: " + d7);

        //eighth digit generator
        boolean adult = age >= 18;
        boolean overweight = d4 >= 5;
        boolean eatsSugarOften = (product == 5 && freq == 3);

        if (adult && overweight && eatsSugarOften) {
            do {
                d8 = rand.nextInt(9) + 1;
            } while (d8 % 2 == 0);
        } else if (!adult && d4 == 3 && product == 1 && freq == 1) {
            do {
                d8 = rand.nextInt(9) + 1;
            } while (d8 % 2 != 0);
        } else {
            d8 = 0;
        }
        System.out.println("Eighth digit: " + d8);

        //ninth digit generator
        int A = Math.max(Math.max(d1, d3), Math.max(d5, d7));
        int B = Math.max(Math.max(d2, d4), Math.max(d6, d8));

        if (A > B){
            d9 = A + 1;
        } else if (A < B) {
            d9 = A - 1;
        } else {
            d9 = 0;
        }

        if (d9 >= 9) {
            d9 = 0;
        } else if (d9 <= 0) {
            d9 = 1;
        }
        System.out.println("Ninth digit: " + d9);

        String clientNumber = "" + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9;
        System.out.println("Your client number is: " + clientNumber);

        String barcode = "";

        for (int i = 0; i < clientNumber.length(); i++) {
            char digit = clientNumber.charAt(i);

            switch (digit) {
                case '0': barcode += "*"; break;
                case '1': barcode += "!"; break;
                case '2': barcode += "@"; break;
                case '3': barcode += "#"; break;
                case '4': barcode += "$"; break;
                case '5': barcode += "%"; break;
                case '6': barcode += "^"; break;
                case '7': barcode += "&"; break;
                case '8': barcode += "/"; break;
                case '9': barcode += "+"; break;
            }
        }

        System.out.println(barcode);
    }
}























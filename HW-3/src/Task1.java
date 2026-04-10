import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Мазе бот v1 на Вашите услуги\n");

        String name = scanner.nextLine();
        String surname = scanner.nextLine();
        String number = scanner.nextLine();
        String age = scanner.nextLine();

        System.out.printf("Добре дошъл в мазето на баба %s %s\n", name, surname);
        System.out.printf("Ти се идентифицира с номер %s\n", number);
        System.out.printf("Ти си на %s години\n", age);

        String wine = "ябълково вино";
        String meat = "пушено месо";
        String jam = "сливов мармалад";
        String peppers = "мариновани чушки";
        String savings = "прасенце касичка";

        int wine_quantity = 10;
        int meat_quantity = 5;
        int jam_quantity = 9;
        int peppers_quantity = 4;
        double savings_leva = 184.35;

        String wine_code = "C7544_10";
        String meat_code = "M7441_5";
        String jam_code = "S6491_9";
        String peppers_code = "P7485_4";
        String savings_code = "B6584_184.35";

        System.out.println("Отчет за продуктите в мазето");
        System.out.println("======================================================");
        System.out.println("|продукт            |брой           |нов сериен номер");
        System.out.println("======================================================");
        System.out.printf("|%s      |%d             |%s\n", wine, wine_quantity, wine_code);
        System.out.printf("|%s        |%d              |%s\n", meat, meat_quantity, meat_code);
        System.out.printf("|%s    |%d              |%s\n", jam, jam_quantity, jam_code);
        System.out.printf("|%s   |%d              |%s\n", peppers, peppers_quantity, peppers_code);
        System.out.printf("|%s   |%f     |%s\n", savings, savings_leva, savings_code);
        System.out.println("======================================================");


    }
}

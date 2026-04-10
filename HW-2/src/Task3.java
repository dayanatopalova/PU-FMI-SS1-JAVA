public class Task3 {
    public static void main(String[] args) {

        int number = 345;
        int first_digit = number / 100;
        int second_digit = (number % 100) / 10;
        int third_digit = (number % 100) % 10;

        int sum = first_digit + second_digit + third_digit;

        System.out.printf("Сума на цифрите на числото 345: %d", sum);
    }
}

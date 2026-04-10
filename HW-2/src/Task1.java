public class Task1 {
    public static void main(String[] args) {

        float number = 5.75f;
        System.out.printf("float стойност: %.2f\n", number );

        //явно преобразуване
        int int_number = (int)number;
        System.out.printf("Преобразувана стойност към int: %d\n", int_number);

        int num = 10;
        //неявно преобразуване
        double double_number = num;
        System.out.printf("int към double: %.1f", double_number);
    }
}

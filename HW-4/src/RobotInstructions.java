import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class RobotInstructions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many pans are there in the kitchen?");
        int pans = Integer.parseInt(sc.nextLine());

        System.out.println("How many pots are there in the kitchen?");
        int pots = Integer.parseInt(sc.nextLine());

        System.out.println("How many centimeters wide is the kitchen?");
        double width = Double.parseDouble(sc.nextLine());

        System.out.println("How many centimeters long is the kitchen?");
        double length = Double.parseDouble(sc.nextLine());

        System.out.println("How many centimeters high is the kitchen?");
        double height = Double.parseDouble(sc.nextLine());

        System.out.println("What is the name of the head chef?");
        String name_head_chief = sc.nextLine();

        System.out.println("How many chefs work in the kitchen?");
        int chefs_count = Integer.parseInt(sc.nextLine());

        System.out.println("How many waiters work in the restaurant?");
        int waiters_count = Integer.parseInt(sc.nextLine());

        System.out.println("What is the name of the sauce chef?");
        String name_sauce_chief = sc.nextLine();

        System.out.println("What is the minimum temperature in the kitchen?");
        double min_temperature = Double.parseDouble(sc.nextLine());

        System.out.println("What is the maximum temperature in the kitchen?");
        double max_temperature = Double.parseDouble(sc.nextLine());

        System.out.println("How much money do you have in your bank account?");
        double deposit_account = Double.parseDouble(sc.nextLine());

        System.out.println("What is your restaurant’s daily revenue?");
        double daily_revenue = Double.parseDouble(sc.nextLine());

        System.out.println("What time do you open?\n(format hh:mm)");
        String opening_time = sc.nextLine();

        System.out.println("What time do you close?\n(format hh:mm)");
        String closing_time = sc.nextLine();

        double kitchen_area_meters = (width / 100.0) * (length / 100.0);
        double kitchen_volume_meters = (width / 100.0) * (length / 100.0) * (height / 100.0);


        System.out.println("Would you like to answer to some additional questions?");
        String answer = sc.nextLine();

        String answer_refrigerator;
        String answer_stove;
        String answer_oven;
        String answer_grill;
        String answer_ventilation;

        if ("yes".equals(answer)) {
            System.out.println("Do you have a refrigerator?");
            answer_refrigerator = sc.nextLine();
            System.out.println("Do you have a gas stove?");
            answer_stove = sc.nextLine();
            System.out.println("Do you have a combi oven?");
            answer_oven = sc.nextLine();
            System.out.println("Do you have an electric grill?");
            answer_grill = sc.nextLine();
            System.out.println("Do you have a ventilation hood?");
            answer_ventilation = sc.nextLine();
        } else {

            answer_refrigerator = "no";
            answer_stove = "no";
            answer_oven = "no";
            answer_grill = "no";
            answer_ventilation = "no";
        }

        // ---- meal choice ---
        System.out.println("What type of meal would you like to have?");
        System.out.println("Menu: Meat meal, Vegetarian meal, Dessert");
        String meal_choice = sc.nextLine();


        // ------------- MEAT -------------------
        if ("Meat meal".equalsIgnoreCase(meal_choice)) {

            System.out.println("What portion would you like to have?");
            System.out.println("Portions in grams: 450, 750, 950");
            int meat_meal_gram = Integer.parseInt(sc.nextLine());

            boolean meat_meal_rare = false;
            boolean meat_meal_medium = false;
            boolean meat_meal_well_done = false;

            if ("no".equalsIgnoreCase(answer_stove)
                    && "yes".equalsIgnoreCase(answer_grill)
                    && min_temperature >= 36
                    && max_temperature <= 48
                    && "yes".equalsIgnoreCase(answer_ventilation)
                    && meat_meal_gram == 450) {

                meat_meal_rare = true;
            }

            if ("yes".equalsIgnoreCase(answer_oven)
                    || (waiters_count + chefs_count == 5)
                    || meat_meal_gram == 750
                    || "Ivan".equalsIgnoreCase(name_head_chief)) {

                meat_meal_medium = true;
            }

            if (("22:00".equalsIgnoreCase(closing_time)
                    || "Petar".equalsIgnoreCase(name_sauce_chief)
                    || "Rado".equalsIgnoreCase(name_sauce_chief))
                    && (kitchen_area_meters == 45
                    || pans == 3
                    || pots == 2)) {

                meat_meal_well_done = true;
            }

            // --------- options for meat meal -------------
            if (meat_meal_rare && meat_meal_medium && meat_meal_well_done) {
                System.out.println("You can have your meat meal RARE, MEDIUM or WELL DONE.\nEnter your choice: ");
            } else if (meat_meal_rare && meat_meal_medium) {
                System.out.println("You can have your meat meal RARE or MEDIUM.\nEnter your choice: ");
            } else if (meat_meal_rare && meat_meal_well_done) {
                System.out.println("You can have your meat meal RARE or WELL DONE.\nEnter your choice: ");
            } else if (meat_meal_medium && meat_meal_well_done) {
                System.out.println("You can have your meat meal MEDIUM or WELL DONE.\nEnter your choice: ");
            } else if (meat_meal_rare) {
                System.out.println("You can have your meat meal RARE.\nEnter your choice: ");
            } else if (meat_meal_medium) {
                System.out.println("You can have your meat meal MEDIUM.\nEnter your choice: ");
            } else if (meat_meal_well_done) {
                System.out.println("You can have your meat meal WELL DONE.\nEnter your choice: ");
            } else {
                System.out.println("No available option for this meal.");
            }

            String meat_meal_type = "";
            if (!meat_meal_rare && !meat_meal_medium && !meat_meal_well_done) {
                System.out.println("System error... culinary chaos detected...");
            }else {
                meat_meal_type = sc.nextLine();
            }

        } else if ("Vegetarian meal".equals(meal_choice)) {

            boolean vegetarian_meal = false;
            boolean vegan_meal = false;
            boolean pescetarian_meal = false;

            if ("no".equalsIgnoreCase(answer_oven)
                    || "no".equalsIgnoreCase(answer_grill)
                    || "no".equalsIgnoreCase(answer_ventilation)) {

                vegetarian_meal = true;
            }

            if ("yes".equalsIgnoreCase(answer_refrigerator)
                    && "Manol".equalsIgnoreCase(name_head_chief)
                    && chefs_count >= 3 && chefs_count < 11
                    && waiters_count != 7) {

                vegan_meal = true;
            }

            if (("yes".equalsIgnoreCase(answer_grill)
                    || "yes".equalsIgnoreCase(answer))
                    && kitchen_volume_meters < 13
                    || ((deposit_account + daily_revenue) < 158000)) {

                pescetarian_meal = true;
            }

            if (vegetarian_meal && vegan_meal && pescetarian_meal) {
                System.out.println("You can have your meal VEGETARIAN, VEGAN or PESCETARIAN.\n Enter your choice: ");
                String meal_vegetarian_choice = sc.nextLine();
            } else if (vegetarian_meal && vegan_meal) {
                System.out.println("You can have your meal VEGETARIAN or VEGAN.\n Enter your choice: ");
                String meal_vegetarian_choice = sc.nextLine();
            } else if (vegetarian_meal && pescetarian_meal) {
                System.out.println("You can have your meal VEGETARIAN or PESCETARIAN.\n Enter your choice: ");
                String meal_vegetarian_choice = sc.nextLine();
            } else if (vegan_meal && pescetarian_meal) {
                System.out.println("You can have your meal VEGAN or PESCETARIAN.\n Enter your choice: ");
                String meal_vegetarian_choice = sc.nextLine();
            } else if (vegetarian_meal) {
                System.out.println("You can have your meat meal VEGETARIAN.\n Enter your choice: ");
                String meal_vegetarian_choice = sc.nextLine();
            } else if (vegan_meal) {
                System.out.println("You can have your meat meal VEGAN.\n Enter your choice: ");
                String meal_vegetarian_choice = sc.nextLine();
            } else if (pescetarian_meal) {
                System.out.println("You can have your meat meal PESCETARIAN.\n Enter your choice: ");
                String meal_vegetarian_choice = sc.nextLine();
            } else {
                System.out.println("No available option for this meal.");
            }

            String vegetarian_meal_type = "";
            if (!vegetarian_meal && !vegan_meal && !pescetarian_meal) {
                System.out.println("System error... culinary chaos detected...");
            } else{
                vegetarian_meal_type = sc.nextLine();
            }

        } else if ("Dessert".equalsIgnoreCase(meal_choice)) {

            System.out.println("Are you addicted to sugar?");
            String sugar_answer = sc.nextLine();

            boolean cake = false;
            boolean ice_cream = false;

            if (("yes".equalsIgnoreCase(answer_refrigerator)
                    && "19:00".equals(closing_time)
                    && "no".equalsIgnoreCase(answer_ventilation)
                    && deposit_account >= 15000 && deposit_account <= 50000)
                    || "Rumen".equalsIgnoreCase(name_head_chief)) {

                cake = true;
            }

            String meal_dessert_choice = "";

            if (cake) {
                System.out.println("You can have CAKE or ICE CREAM for dessert.\n Enter your choice: ");
                meal_dessert_choice = sc.nextLine();
            }

            String ice_cream_flavor = "";
            if ("ice cream".equalsIgnoreCase(meal_dessert_choice)){
                System.out.println("Choose a flavor: strawberry, banana, vanilla\nEnter your choice: ");
                ice_cream_flavor = sc.nextLine();
            }

            if ("no".equalsIgnoreCase(sugar_answer) || "strawberry".equalsIgnoreCase(ice_cream_flavor)) {
                ice_cream = true;

            }else if ("yes".equalsIgnoreCase(sugar_answer)){
                System.out.println("Sorry, but we can not offer you ice cream since you have a sugar addiction!\nIt is for your good!");
            }else{
                System.out.println("Sorry, but we can not offer you ice cream in this flavor!\nWe currently have only strawberry ice cream!");
            }

            if (!cake && !ice_cream) {
                System.out.println("System error... culinary chaos detected...");
            }

        }

        System.out.println("Thank you for dining with us!");

    }
}


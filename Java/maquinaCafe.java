import java.util.Scanner;

class maquinaCafe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waterAval = 400;
        int milkAval = 540;
        int beansAval = 120;
        int cupsAval = 9;
        int money = 550;
        boolean condition;
        boolean status = true;

        while (status) {
            System.out.println("");
            System.out.println("Write action (buy, fill, take, remaining, exit) :");

            String action = scanner.next();

            switch (action) {
                case "exit":
                    status = false;
                    break;
                case "remaining":
                    printStatus(waterAval, milkAval, beansAval, cupsAval, money);
                    break;
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino," +
                            " back - to main menu:");
                    String coffee = scanner.next();
                    switch (coffee) {
                        case "back":
                            break;
                        case "1":
                            condition = checkStatus(waterAval, milkAval, beansAval, cupsAval, coffee);
                            if (condition) {
                                break;
                            }
                            waterAval -= 250;
                            beansAval -= 16;
                            money += 4;
                            cupsAval--;
                            break;
                        case "2":
                            condition = checkStatus(waterAval, milkAval, beansAval, cupsAval, coffee);
                            if (condition) {
                                break;
                            }
                            waterAval -= 350;
                            milkAval -= 75;
                            beansAval -= 20;
                            money += 7;
                            cupsAval--;
                            break;
                        case "3":
                            condition = checkStatus(waterAval, milkAval, beansAval, cupsAval, coffee);
                            if (condition) {
                                break;
                            }
                            waterAval -= 200;
                            milkAval -= 100;
                            beansAval -= 12;
                            money += 6;
                            cupsAval--;
                            break;
                    }
                    break;

                case "fill":
                    System.out.println("Write hoy many ml of water do you want to add:");
                    int temp = scanner.nextInt();
                    waterAval += temp;
                    System.out.println("Write hoy many ml of milk do you want to add:");
                    temp = scanner.nextInt();
                    milkAval += temp;
                    System.out.println("Write hoy many grams of coffee beans do you want to add:");
                    temp = scanner.nextInt();
                    beansAval += temp;
                    System.out.println("Write hoy many disposable cups of coffee do you want to add:");
                    temp = scanner.nextInt();
                    cupsAval += temp;
                    break;

                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;

            }
        }
    }

    public static void printStatus(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static boolean checkStatus(int water, int milk, int beans, int cups, String a) {
        int waterNeed = 0;
        int milkNeed = 0;
        int beansNeed = 0;
        int cupsNeed = 1;
        boolean cond;
        switch (a) {
            case "1":
                waterNeed = 250;
                beansNeed = 16;
                milkNeed = 0;
                break;
            case "2":
                waterNeed = 350;
                milkNeed = 75;
                beansNeed = 20;
                break;
            case "3":
                waterNeed = 200;
                milkNeed = 100;
                beansNeed = 12;
                break;
        }
        if (water < waterNeed) {
            System.out.println("Sorry, not enough water!");
            cond = true;
        } else if (milk < milkNeed) {
            System.out.println("Sorry, not enough milk!");
            cond = true;
        } else if (beans < beansNeed) {
            System.out.println("Sorry, not enough coffee beans!");
            cond = true;
        } else if (cups < cupsNeed) {
            System.out.println("Sorry, not enough cups!");
            cond = true;
        } else {
            System.out.println("I have enough resources, making your coffee!");
            cond = false;
        }
        return cond;
    }
    
}


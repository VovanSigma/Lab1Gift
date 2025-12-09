package ua.lab1.gift.app;

import ua.lab1.gift.model.NewYearGift;
import ua.lab1.gift.model.candy.Candy;
import ua.lab1.gift.model.candy.ChocolateCandy;
import ua.lab1.gift.model.candy.JellyCandy;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NewYearGift gift = createSampleGift();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showAllCandies(gift);
                case "2" -> showTotalWeightAndPrice(gift);
                case "3" -> sortBySugar(gift);
                case "4" -> findBySugarRange(gift, scanner);
                case "0" -> {
                    System.out.println("Вихід...");
                    return;
                }
                default -> System.out.println("Невірний пункт меню");
            }
        }
    }

    private static NewYearGift createSampleGift() {
        NewYearGift gift = new NewYearGift();
        gift.addCandy(new ChocolateCandy("Корона горіхова", 25, 12, 350, 50));
        gift.addCandy(new ChocolateCandy("Рошен класична", 20, 10, 300, 45));
        gift.addCandy(new JellyCandy("Желейка яблучна", 15, 8, 280, "apple"));
        gift.addCandy(new JellyCandy("Желейка вишнева", 15, 9, 280, "cherry"));
        return gift;
    }

    private static void printMenu() {
        System.out.println("\n== Новорічний подарунок==");
        System.out.println("1. Показати всі цукерки");
        System.out.println("2. Показати загальну вагу та вартість подарунка");
        System.out.println("3. Відсортувати цукерки за вмістом цукру");
        System.out.println("4. Знайти цукерки за діапазоном вмісту цукру");
        System.out.println("0. Вихід");
        System.out.print("Ваш вибір: ");
    }

    private static void showAllCandies(NewYearGift gift) {
        System.out.println("\nЦукерки у подарунку:");
        for (Candy candy : gift.getCandies()) {
            System.out.println(" - " + candy);
        }
    }

    private static void showTotalWeightAndPrice(NewYearGift gift) {
        System.out.printf(
                "Загальна вага: %.0f г, загальна вартість: %.2f₴%n",
                gift.getTotalWeight(),
                gift.getTotalPrice()
        );
    }

    private static void sortBySugar(NewYearGift gift) {
        List<Candy> sorted = gift.sortBySugar();
        System.out.println("\nЦукерки, відсортовані за вмістом цукру:");
        for (Candy candy : sorted) {
            System.out.println(" - " + candy);
        }
    }

    private static void findBySugarRange(NewYearGift gift, Scanner scanner) {
        try {
            System.out.print("Мінімальний вміст цукру (г): ");
            double min = Double.parseDouble(scanner.nextLine());
            System.out.print("Максимальний вміст цукру (г): ");
            double max = Double.parseDouble(scanner.nextLine());

            List<Candy> found = gift.findBySugarRange(min, max);
            if (found.isEmpty()) {
                System.out.println("Цукерок з таким вмістом цукру не знайдено.");
            } else {
                System.out.println("Знайдені цукерки:");
                for (Candy candy : found) {
                    System.out.println(" - " + candy);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Помилка: потрібно ввести число.");
        }
    }
}

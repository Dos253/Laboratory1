package bsu.rfe.java.group7.lab1.Smolski.varB7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        List<Food> breakfast = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Обработка аргументов командной строки
        boolean calculateCalories = false;
        String typeToCount = null;

        for (String arg : args) {
            if (arg.equals("-calories")) {
                calculateCalories = true;
            } else if (arg.startsWith("-type=")) {
                typeToCount = arg.substring(6); // Извлекаем тип продукта
            }
        }

        // Цикл для добавления продуктов1
        while (true) {
            System.out.println("Выберите продукт для добавления в завтрак:");
            System.out.println("1. Мороженое");
            System.out.println("2. Сыр");
            System.out.println("3. Яблоко");
            System.out.println("0. Завершить добавление продуктов");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем оставшийся символ новой строки

            if (choice == 0) {
                break; // Выход из цикла
            }

            switch (choice) {
                case 1:

                    System.out.print("Введите первый тип сиропа (карамель/шоколад): ");
                    String syrup1 = scanner.nextLine();
                    System.out.print("Введите второй тип сиропа (карамель/шоколад): ");
                    String syrup2 = scanner.nextLine();
                    breakfast.add(new IceCream(syrup1 + " и " + syrup2));
                    break;

                case 2:
                    breakfast.add(new Cheese());
                    break;
                case 3:
                    System.out.print("Введите размер яблока (большое/маленькое): ");
                    String size = scanner.nextLine();
                    breakfast.add(new Apple(size));
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
                    break;
            }
        }

        // Подсчет калорий и количества каждого продукта
//        Map<String, Integer> productCount = new HashMap<>();
//        int totalCalories = 0;
//
//        for (Food food : breakfast) {
//            totalCalories += food.calculateCalories();
//            String productName = food.getClass().getSimpleName(); // Получаем имя класса продукта
//            productCount.put(productName, productCount.getOrDefault(productName, 0) + 1);
//        }
//
//        // Вывод результатов
//        System.out.println("Общая калорийность завтрака: " + totalCalories);
//        System.out.println("Количество каждого продукта в завтраке:");
//        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());

        Map<String, Integer> productCount = new HashMap<>();
        int totalCalories = 0;

        for (Food food : breakfast) {
            // Считаем калории для каждого продукта
            totalCalories += food.calculateCalories();

            // Получаем имя класса продукта
            String productName = food.getClass().getSimpleName();

            // Если задан тип для подсчета, проверяем соответствие
            if (typeToCount == null || food.getClass().getSimpleName().equals(typeToCount)) {
                productCount.put(productName, productCount.getOrDefault(productName, 0) + 1);
            }
        }

// Вывод результатов
        System.out.println("Общая калорийность завтрака: " + totalCalories);
        System.out.println("Количество каждого продукта в завтраке:");
        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        }


    }


package Seminar1;

    
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    private final static Scanner SCANNER = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        Map<Drinks, Integer> result = new HashMap<>();
        
        while (true) {
            System.out.println("Выберите Напиток ");
            System.out.println(Arrays.toString(Drinks.values()));//список напитков
            Drinks drink = userInput(Drinks::valueOf);
            System.out.println("Мой выбор: " + drink + "; Цена" + drink.getPrice());
            System.out.println("Какое количество  желаете ?");
            Integer drinkNumber = userInput(Integer::valueOf);
            System.out.println("Хотели бы что нибудь еще ? Yes/No");
            if (result.containsKey(drink)) result.put(drink, result.get(drink)+drinkNumber);
            else result.put(drink, drinkNumber);
            
            if (!"Yes".equalsIgnoreCase(userInput(String::valueOf))) break;
        }
        
        System.out.println("***************************************");
        int totalPrice = 0;
        for (Drinks drink : result.keySet()) {            
            System.out.println(drink + "(" + result.get(drink) + ") -> " + result.get(drink)*drink.getPrice());
            totalPrice+=result.get(drink)*drink.getPrice();
        }
        System.out.println("Итоговая цена: " + totalPrice);
    }
    
    private static <T> T userInput(Function<String, T> function) {
        while (true) {
            try {
                return function.apply(SCANNER.nextLine().trim().toUpperCase());
            } catch (Exception e) {
                System.out.println("Неверный ввод, попробуйте еще раз.");
            }
        }
    }
    
}


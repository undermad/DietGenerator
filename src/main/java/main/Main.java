package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws WrongProportionException {

        Map<Macro, Double> cucumberMacro = new HashMap<>();
        cucumberMacro.put(Macro.CARBO, 3.63);
        cucumberMacro.put(Macro.PROTEIN, 0.65);
        cucumberMacro.put(Macro.FAT, 0.11);

        Map<Macro, Double> riceMacro = new HashMap<>();
        riceMacro.put(Macro.CARBO, 44.08);
        riceMacro.put(Macro.PROTEIN, 4.2);
        riceMacro.put(Macro.FAT, 0.44);

        Map<Macro, Double> chickenMacro = new HashMap<>();
        chickenMacro.put(Macro.CARBO, 3.63);
        chickenMacro.put(Macro.PROTEIN, 30.6);
        chickenMacro.put(Macro.FAT, 1.6);

        Map<Macro, Double> oliveOilMacro = new HashMap<>();
        oliveOilMacro.put(Macro.CARBO, 0.0);
        oliveOilMacro.put(Macro.PROTEIN, 0.0);
        oliveOilMacro.put(Macro.FAT, 100.0);

        Product cucumber = new Product("Cucumber", 15, Type.VEGETABLE, cucumberMacro);
        Product rice = new Product("Rice", 204, Type.GRAIN, riceMacro);
        Product chicken = new Product("Chicken", 137, Type.MEAT, chickenMacro);
        Product oliveOil = new Product("Olive Oil", 884, Type.FAT_AND_OILS, oliveOilMacro);

        Map<Product, Integer> ingredients = new HashMap<>();
        ingredients.put(cucumber, 3);
        ingredients.put(rice, 20);
        ingredients.put(chicken, 70);
        ingredients.put(oliveOil, 7);

        List<DietType> dietFriendly = new ArrayList<>();
        dietFriendly.add(DietType.STANDARD);

        List<Equipment> equipment = new ArrayList<>();
        equipment.add(Equipment.POT);

        String methodology = """
                    Cut chicken in to small pieces.
                    Add olive oil and chicken to one kettle and heat on medium heat
                    until chicken get golden colour.
                    Add some salt to chicken for unkurw the taste.
                    At same time add rice to the kettle and boiling water - cook for 15min.
                    Slice cucumber add some salt and pepper.
                    Smash everything on the plate grab the fork and eat you delicious Ryz z kurwczakiem.
                """;


        Recipe riceWithChickenMotherFuckers = new Recipe(
                "Ryż z kurwczakiem",
                ingredients,
                dietFriendly,
                equipment,
                30,
                methodology);

//        System.out.println(riceWithChickenMotherFuckers.countKcal(100));

        Map<Product, Double> shoppingList = riceWithChickenMotherFuckers
                .countIngredients(1020);

        shoppingList.forEach((product, aDouble) -> {
            System.out.println(product.getName() + ": " + aDouble + "g");
        });


        Map<Macro, Double> recipeMacro = riceWithChickenMotherFuckers.countMacro(1020);
        recipeMacro.forEach((macro, aDouble) -> {
            System.out.println(macro.getName() + ": " + aDouble + "g");
        });


    }
}

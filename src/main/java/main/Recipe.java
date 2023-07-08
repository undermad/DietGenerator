package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {

    private String name;
    private Map<Product, Integer> ingredients;
    private List<DietType> dietTypes;
    private List<Equipment> equipments;
    private int timeToPrepare;
    private String methodology;

    public Recipe(String name,
                  Map<Product, Integer> ingredients,
                  List<DietType> dietTypes,
                  List<Equipment> equipments,
                  int timeToPrepare,
                  String methodology) throws WrongProportionException {

        this.name = name;

        double whole = 0;
        for (Integer proportion : ingredients.values()) {
            whole += proportion;
        }
        if (whole != 100) {
            throw new WrongProportionException("Wrong proportions");
        }
        this.ingredients = ingredients;

        this.dietTypes = dietTypes;
        this.equipments = equipments;
        this.timeToPrepare = timeToPrepare;
        this.methodology = methodology;
    }


    // this is useless...
    public double countKcal(double amount) {
        double totalKcal = 0;
        for (Map.Entry<Product, Integer> i : ingredients.entrySet()) {
            double grams = (i.getValue() * amount) / 100;
            double kcal = (i.getKey().getKcal() / 100) * grams;
            totalKcal += kcal;
        }
        return totalKcal;
    }

    // that is useful but doesn't work yet
    public Map<Product, Double> countIngredients(int kcal) {

        Map<Product, Double> shoppingList = new HashMap<>();
        for (Map.Entry<Product, Integer>
                ingredient : ingredients.entrySet()) {

            double specificProductInKcal = ((double) ingredient.getValue() / 100) * kcal;
            double requiredGrams = ingredient.getKey().countGramsFromKcal(specificProductInKcal);
            String formattedValue = String.format("%.2f", requiredGrams).replace(",", ".");
            double formattedValueAsDouble = Double.parseDouble(formattedValue);

            shoppingList.put(ingredient.getKey(), formattedValueAsDouble);
        }

        return shoppingList;
    }

    public Map<Macro, Double> countMacro(int kcal) {

        Map<Product, Double> productList = countIngredients(kcal);
        Map<Macro, Double> macros = new HashMap<>();
        macros.put(Macro.PROTEIN, 0.0);
        macros.put(Macro.CARBO, 0.0);
        macros.put(Macro.FAT, 0.0);


        for (Map.Entry<Product, Double> ingredient : productList.entrySet()) {
            Map<Macro, Double> macroInSpecificIngredient =
                    ingredient.getKey().countMacroFromGrams(ingredient.getValue());
            macros.put(
                    Macro.PROTEIN,
                    macros.get(Macro.PROTEIN) + macroInSpecificIngredient.get(Macro.PROTEIN));

            macros.put(
                    Macro.CARBO,
                    macros.get(Macro.CARBO) + macroInSpecificIngredient.get(Macro.CARBO));

            macros.put(
                    Macro.FAT,
                    macros.get(Macro.FAT) + macroInSpecificIngredient.get(Macro.FAT));

        }

        return macros;
    }


}

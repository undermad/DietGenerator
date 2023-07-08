package main;

import java.util.HashMap;
import java.util.Map;

public class Product {

    private String name;
    private double kcal;
    private Type type;
    private Map<Macro, Double> macro;

    public Product(String name, double kcal, Type type, Map<Macro, Double> macro) {
        this.name = name;
        this.kcal = kcal;
        this.macro = macro;
        this.type = Type.FRUIT;
    }

    public double countKcalFromGrams(double grams) {
        double kcalPerOneGram = this.kcal / 100;
        return grams * kcalPerOneGram;
    }

    public double countGramsFromKcal(double kcal) {
        double gramPerKcal = 100 / this.kcal;
        return kcal * gramPerKcal;
    }

    public Map<Macro, Double> countMacroFromGrams(double grams) {
        Map<Macro, Double> specificMacro = new HashMap<>();
        specificMacro.put(Macro.PROTEIN, countProteinFromGrams(grams));
        specificMacro.put(Macro.CARBO, countCarboFromGrams(grams));
        specificMacro.put(Macro.FAT, countFatFromGrams(grams));
        return specificMacro;
    }

    public double countProteinFromGrams(double grams) {
        double proteinsPerGram = this.macro.get(Macro.PROTEIN) / 100;
        return proteinsPerGram * grams;
    }

    public double countCarboFromGrams(double grams) {
        double carboPerGram = this.macro.get(Macro.CARBO) / 100;
        return carboPerGram * grams;
    }

    public double countFatFromGrams(double grams) {
        double fatPerGram = this.macro.get(Macro.FAT) / 100;
        return fatPerGram * grams;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public Map<Macro, Double> getMacro() {
        return macro;
    }
}

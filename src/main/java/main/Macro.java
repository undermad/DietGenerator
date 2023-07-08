package main;

public enum Macro {
    CARBO("Carbo", 4),
    PROTEIN("Protein", 4),
    FAT("Fat", 9);

    private String name;
    private int kcal;

    Macro(String name, int kcal) {
        this.name = name;
        this.kcal = kcal;
    }

    public String getName() {
        return name;
    }
}

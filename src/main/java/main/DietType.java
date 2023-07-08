package main;

public enum DietType {
    STANDARD("Standard"),
    VEGETARIAN("Vegatarian");

    private String name;

    DietType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

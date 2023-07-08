package main;

public enum Type {
    VEGETABLE("Vegetable"),
    FRUIT("Fruit"),
    GRAIN("Grain"),
    MEAT("Meat"),
    FAT_AND_OILS("Fat and Oils");

    private String name;

    Type(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package main;

enum Equipment {
    FRYING_PAN("Frying pan"),
    OVEN("Oven"),
    POT("Pot");

    private String name;

    Equipment(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package model;

public class Flora extends Species {

    private Boolean flower;
    private Boolean fruit;
    private double height; 

    public Flora (String name, String scientificName, Boolean flower, Boolean fruit, double height,
    SpeciesType type ){

    super(name, scientificName,type);

    this.flower = flower;
    this.fruit = fruit;
    this.height = height;
    }

    public Boolean getFlower() {
        return flower;
    }

    public void setFlower(Boolean flower) {
        this.flower = flower;
    }

    public Boolean getFruit() {
        return fruit;
    }

    public void setFruit(Boolean fruit) {
        this.fruit = fruit;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String flowersToString() {
        if (flower) {
            return "Have flowers ";
        } else {
            return "not have flowers";
        }
    }
    public String fruitsToString() {
        if (fruit) {
            return "Have fruits";
        } else {
            return "not have fruits";
        }
    }

    @Override
    public String typeToString() {
        if (getType() == SpeciesType.LAND_FLORA) {
            return "Flora : land";
        } else {
            return "Flora : aquatic";
        }
    }



    @Override
    public String toString() {
        return "Name : " + getName() +"\n"+ "Scientific Name: " + getScientificName()+"\n" + "Type: " + typeToString()+"\n" + "¿Flowers?: " + flowersToString()+"\n" + "¿Fruits?: "
                + fruitsToString()+"\n" + "Max Height: " + height;
    }
    
}

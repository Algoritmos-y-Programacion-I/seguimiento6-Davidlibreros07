package model;

public class Fauna extends Species {

    private Boolean migratory;
    private double weight;

    public Fauna (String name, String scientificName, Boolean migratory, double weight, SpeciesType type){

        super(name,scientificName,type);
        this.migratory = migratory;
        this.weight = weight;
    }

    public Boolean getMigratory() {
        return migratory;
    }

    public void setMigratory(Boolean migratory) {
        this.migratory = migratory;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String migratoryToString() {
        if (migratory) {
            return "migrate";
        } else {
            return "doesn´t migrate";
        }
    }

    @Override
    public String typeToString(){
        String typeString= "";
        if (getType() == SpeciesType.BIRD) {
            typeString= "Fauna : bird";
        } else if (getType() == SpeciesType.MAMMAL) {
            typeString= "Fauna : mammal";
        } else if (getType() == SpeciesType.AQUATIC_FAUNA) {
            typeString= "Fauna :  aquatic ";
            
        }
        return typeString;
    }
    @Override
    public String toString() {
        return "Name: "+getName()+"\n"+"Scientific Name: "+getScientificName()+"\n"+"Type: "+typeToString()+"\n"+"migratory :" + migratoryToString()+"\n" + "maximumWeight :" + weight;
    }


    
}

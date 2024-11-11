package model;

public class Species {

	private String name;
	private String scientificName;
	private SpeciesType type;

	public Species(String name, String scientificName, SpeciesType type) {

		this.name = name;
		this.scientificName = scientificName;
		this.type = type;

	}

	public SpeciesType getType() {
		return type;
	}

	public void setType(SpeciesType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public String typeToString() {
		return super.toString();
	}

}

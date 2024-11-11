package model;

public class SpeciesController {

	private Species[] species;

	public SpeciesController() {

		this.species = new Species[80];

	}

	//HACEMOS UN METODO PARA REGISTRAR A LAS ESPECIES DE FLORA

	public boolean registerSpecies(String name, String scientificName, int typeOfFlora, int optionFlowers, int optionFruits,
			double height) {
		SpeciesType type = SpeciesType.LAND_FLORA;
		boolean flower = false;
		boolean fruit = false;
		if (typeOfFlora == 1) {
			type = SpeciesType.LAND_FLORA;

		} else if (typeOfFlora == 2) {
			type = SpeciesType.AQUATIC_FLORA;

		}
		switch (optionFlowers) {
			case 1:
				flower = true;
				break;
			case 2:
				flower = false;
				break;

			default:
				flower = false;
				break;
		}
		switch (optionFruits) {
			case 1:
				fruit = true;
				break;
			case 2:
				fruit = false;
				break;

			default:
				fruit = false;
				break;
		}

		Species flora = new Flora(name, scientificName, flower, fruit, height, type);
		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = flora;
				return true;
			}

		}

		return false;

	}


	//HACEMOS OTRO PARA REGISTRAR LAS ESPECIES DE FAUNA

	public boolean registerSpecies(String name, String scientificName, int typeOfFauna, int optionMigratory,
			double weight) {
		boolean migratory = false;
		SpeciesType type = SpeciesType.MAMMAL;
		if (optionMigratory == 1) {
			migratory = true;
		} else if (optionMigratory == 2) {
			migratory = false;

		}

		switch (typeOfFauna) {
			case 1:
				type = SpeciesType.BIRD;
				break;
			case 2:
				type = SpeciesType.MAMMAL;
				break;
			case 3:
				type = SpeciesType.AQUATIC_FAUNA;
				break;
			default:
				type = SpeciesType.MAMMAL;
				break;
		}

		Species fauna = new Fauna(name, scientificName, migratory, weight, type);

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = fauna;
				return true;
			}

		}

		return false;

	}


	public String showSpeciesList() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + (i + 1) + ". " + species[i].getName();
			}
		}

		return msg;

	}

	public String showSpeciesEdit() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + (i + 1) + ". " + species[i].getName() + " , Type - " + species[i].typeToString();
			}
		}

		return msg;

	}

	public boolean deleteSpecie(int SpecieDelete) {
		boolean result = false;
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null && species[SpecieDelete - 1] != null) {
				species[SpecieDelete - 1] = null;
				result = true;
				break;

			}
		}
		return result;
	}

	public String showSpecies(int SpecieShow) {
		String msj = "";
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null && species[SpecieShow - 1] != null) {

				msj = species[SpecieShow - 1].toString();

				break;

			}
		}

		return msj;
	}

	public boolean modifySpecies(int specieEdit, int option, String newName, String newScientificName,
			int newTypeOfFlora, int newHeight, int newTypeOfFauna, int newWeight) {
		boolean result = false;
		switch (option) {
			case 1:
				for (int i = 0; i < species.length; i++) {
					if (species[i] != null && species[specieEdit - 1] != null) {
						species[specieEdit - 1].setName(newName);
						result = true;
					}
				}
				break;

			case 2:
				for (int i = 0; i < species.length; i++) {
					if (species[i] != null && species[specieEdit - 1] != null) {
						species[specieEdit - 1].setScientificName(newScientificName);
						result = true;
						
					}
				}
				break;
			case 3:
				for (int i = 0; i < species.length; i++) {
					if (species[i] != null && species[specieEdit - 1] != null) {
						if (species[specieEdit - 1] instanceof Flora) {
							
						if (species[specieEdit - 1].getType() == SpeciesType.LAND_FLORA) {
							species[specieEdit - 1].setType(SpeciesType.AQUATIC_FLORA);
						} else if (species[specieEdit - 1].getType() == SpeciesType.AQUATIC_FLORA) {
							species[specieEdit - 1].setType(SpeciesType.LAND_FLORA);
						}} else if (species[specieEdit - 1] instanceof Fauna) {
							Fauna fauna = (Fauna) species[specieEdit - 1];
							switch (newTypeOfFauna) {
								case 1:
								fauna.setType(SpeciesType.BIRD);
									break;
								case 2:
									fauna.setType(SpeciesType.MAMMAL);
									break;
								case 3:
									fauna.setType(SpeciesType.AQUATIC_FAUNA);
									break;
							
								default:
									break;
							}
							
						}
						result = true;
						
					}
				}
				break;
			case 4:
				for (int i = 0; i < species.length; i++) {
					if (species[i] != null && species[specieEdit - 1] != null) {
						if (species[specieEdit - 1] instanceof Flora) {
							Flora flora = (Flora) species[specieEdit - 1];
							if (flora.getFlower()) {
								flora.setFlower(false);
							} else {
								flora.setFlower(true);
							}
						} else if (species[specieEdit - 1] instanceof Fauna) {
							Fauna fauna = (Fauna) species[specieEdit - 1];
							if (fauna.getMigratory()) {
								fauna.setMigratory(false);
							} else {
								fauna.setMigratory(true);
							}

						}
						result = true;
						
					}
				}
				break;
			case 5:
			for (int i = 0; i < species.length; i++) {
				if (species[i] != null && species[specieEdit - 1] != null) {
					if(species[specieEdit - 1] instanceof Flora){
						Flora flora = (Flora) species[specieEdit - 1];
						if(flora.getFruit()){
							flora.setFruit(false);
						}else{
							flora.setFruit(true);
						}
					}else if(species[specieEdit - 1] instanceof Fauna){
						Fauna fauna = (Fauna) species[specieEdit - 1];
						fauna.setWeight(newWeight);
					}
					result = true;
					
						}
				}
					break;

				case 6:
					for(int i = 0; i < species.length; i++){
						if(species[i] != null && species[specieEdit - 1] != null){
							if (species[specieEdit - 1] instanceof Flora) {
								Flora flora = (Flora) species[specieEdit - 1];
								flora.setHeight(newHeight);
								result = true;
								break;

								
							}
						}	
								
			}

			break;		
			
		}
		return result;
		}

}

package prosjektKode;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Character {
	
	//BASICS
	protected String name;
	protected String gender;
	protected String race;
	protected String classes;
	
	//HEALTH & STAMINA
	protected int health;
	protected int stamina;
	
	//ABILITY
	protected int strength;
	protected int dexterity;
	protected int constitution;
	protected int intelligence;
	protected int wisdom;
	protected int charisma;
	
	
	//EQUIPMENT
	protected List<String> equipment = new ArrayList<String>();
	

	//DETAILS
	protected String backstory;
	protected String appearance;
	protected String other;
	
	
	//OTHER VARIABLES
	protected List<String> availableGenders = Arrays.asList("Male", "Female", "Unspecified");
	protected List<String> availableClasses = Arrays.asList("Fighter", "Wizard", "Rogue", "Bard");
	protected List<String> fighterEquipment = Arrays.asList("Longsword", "Shield", "Chain mail");
	protected List<String> wizardEquipment = Arrays.asList("Arcane focus", "Quarterstaff","Spellbook");
	protected List<String> rogueEquipment = Arrays.asList("Shortbow(20 arrows)", "Dagger", "Leather armor");
	protected List<String> bardEquipment = Arrays.asList("Lute", "Shortsword", "Leather armor");
	
	
	
	
	//---------------------METHODS---------------------------
	
	public Character(String name, String gender, String classes, int strength, 
			int dexterity, int constitution, int intelligence, int wisdom, int charisma,
			String appearance, String backstory, String other) {
		setName(name);
		setGender(gender);
		setClasses(classes);
		setStrength(strength);
		setDexterity(dexterity);
		setConstitution(constitution);
		setIntelligence(intelligence);
		setWisdom(wisdom);
		setCharisma(charisma);
		setAppearance(appearance);
		setBackstory(backstory);
		setOther(other);
	}
	
	
	//BASICS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if (!this.availableGenders.contains(gender)) {
			throw new IllegalArgumentException("Not a valid gender option");
		}
		this.gender = gender;
		
	}
	
	public String getClasses() {
		return this.classes;
	}
	public void setClasses(String classes) {
		if(!availableClasses.contains(classes)) {
			throw new IllegalArgumentException("Not a valid class");
		}
		this.classes = classes;
		
		if(classes.equals("Fighter")) {
			this.equipment = this.fighterEquipment;
		}
		else if (classes.equals("Wizard")) {
			this.equipment = this.wizardEquipment;
		}
		else if (classes.equals("Rogue")) {
			this.equipment = this.rogueEquipment;
		}
		else if (classes.equals("Bard")) {
			this.equipment = this.bardEquipment;
		}
	}
	
	public String getRace() {
		return this.race;
	}
	
	
	//HEALTH & STAMINA
	public int getHealth() {
		return health;
	}
	private void setHealth() {
		this.health = this.constitution * 10;
		if(this.health > 210 || this.health < 10) {
			throw new IllegalArgumentException("Health must be an integer value between 10 and 210");
		}
	}
	
	public int getStamina() {
		return stamina;
	}
	private void setStamina() {
		this.stamina = this.constitution + 25;
		if(this.stamina > 46 || this.stamina < 25) {
			throw new IllegalArgumentException("Stamina must be an integer value between 25 and 46");
		}
	}
	
	
	//ABILITIES
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		if (strength < 1 || strength > 20) {
			throw new IllegalArgumentException("Strength has to be an integer between 1 and 20");
		}
		this.strength = strength;
	}
	
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		if (dexterity < 1 || dexterity > 20) {
			throw new IllegalArgumentException("Dexterity has to be an integer between 1 and 20");
		}
		this.dexterity = dexterity;
	}
	
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		if (constitution < 1 || constitution > 20) {
			throw new IllegalArgumentException("Constitution has to be an integer between 1 and 20");
		}
		this.constitution = constitution;
		setHealth();
		setStamina();
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		if (intelligence < 1 || intelligence > 20) {
			throw new IllegalArgumentException("Intelligence has to be an integer between 1 and 20");
		}
		this.intelligence = intelligence;
	}
	
	public int getWisdom() {
		return wisdom;
	}
	public void setWisdom(int wisdom) {
		if (wisdom < 1 || wisdom > 20) {
			throw new IllegalArgumentException("Wisdom has to be an integer between 1 and 20");
		}
		this.wisdom = wisdom;
	}
	
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		if (charisma < 1 || charisma > 20) {
			throw new IllegalArgumentException("Charisma has to be an integer between 1 and 20");
		}
		this.charisma = charisma;
	}
	
	
	//DETAILS
	public String getBackstory() {
		return backstory;
	}
	public void setBackstory(String backstory) {
		this.backstory = backstory;
	}
	
	public String getAppearance() {
		return appearance;
	}
	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}
	
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	
	//EQUIPMENT
	public List<String> getEquipment() {
		return equipment;
	}
	
	//toString
	public String toString() {
		return "name: " + name + "\ngender: " + gender + "\nrace: " + race + "\nclass: " + classes
				+ "\nhealth: " + health + "\nstamina: " + stamina + "\nstrength: " + strength + "\ndexterity: " + dexterity
				+ "\nconstitution: " + constitution + "\nintelligence: " + intelligence + "\nwisdom: " + wisdom
				+ "\ncharisma: " + charisma + "\nequipment: " + equipment + "\nappearance: " + appearance + "\nbackstory: " + backstory
				+ "\nother: " + other;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Character Bruenor = new Human("Bruenor", "Male", "Fighter", 15,14,13,12,10,8, null, null, null);
		CharManager manager = new CharManager();
		manager.writeToFile("characterTestSheet", Bruenor);
		manager.readFromFile("characterTestSheet");
	}
}

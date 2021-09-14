package prosjektKode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CharManager implements FileManaging{
	
	public String name;
	public String gender;
	public String race;
	public String classes;
	
	//HEALTH & STAMINA
	public int health;
	public int stamina;
	
	//ABILITY
	public int strength;
	public int dexterity;
	public int constitution;
	public int intelligence;
	public int wisdom;
	public int charisma;
	
	
	//EQUIPMENT
	public List<String> equipment = new ArrayList<String>();
	
	
	//DETAILS
	public String backstory = "";
	public String appearance = "";
	public String other = "";
	
	//OTHER
	private List<String> availableRaces = Arrays.asList("Human", "Elf", "Orc");

	
	//---------------------METHODS-----------------------------
	
	public String getStringValueOnly(String string) {
		return string.substring(string.indexOf(" ") + 1);
		
	}
	
	public List<String> getListValuesOnly(String string){
		String listString = string.substring(string.indexOf("[")+1, string.length()-1);
		String[] listValues = listString.split(",");
		List<String> values = Arrays.asList(listValues[0], listValues[1], listValues[2]);
		return values;
	}
	
	public void getTextFields(Scanner scanner) {
		String wholeString = "";
		while(scanner.hasNext()) {
			if (scanner.next().equals("appearance:")) {
				while(scanner.hasNext()) {
					String scan = scanner.next();
					wholeString += " " + scan;
				}
			}
		}
		
		if (!(wholeString == null)) {
			this.appearance = wholeString.substring(wholeString.indexOf(" ")+1, wholeString.indexOf("backstory:"));
			this.backstory = wholeString.substring(wholeString.indexOf("backstory:")+11, wholeString.indexOf("other:"));
			this.other = wholeString.substring(wholeString.indexOf("other:")+7);
		}
		
		
	}
	
	public void isBuildValid() {
		if(!this.availableRaces.contains(this.race)) {
			throw new IllegalArgumentException("Build is not valid!");
		}
		
		if (this.race.equals("Human")) {
			try {
				Character character = new Human(this.name, this.gender, this.classes, this.strength, this.dexterity, 
	    				this.constitution, this.intelligence-1, this.wisdom+1, this.charisma-1,
	    				this.appearance, this.backstory, this.other);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Build is not valid!");
				e.printStackTrace();
			}
		}
    	else if (this.race.equals("Elf")) {
    		try {
    			Character character = new Elf(this.name, this.gender, this.classes, this.strength+1, this.dexterity-1, 
	    				this.constitution, this.intelligence, this.wisdom-1, this.charisma,
	    				this.appearance, this.backstory, this.other);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Build is not valid!");
				e.printStackTrace();
			}
		}
    	else if (this.race.equals("Orc")) {
    		try {
    			Character character = new Orc(this.name, this.gender, this.classes, this.strength-1, this.dexterity, 
	    				this.constitution-1, this.intelligence+1, this.wisdom, this.charisma,
	    				this.appearance, this.backstory, this.other);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Build is not valid!");
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void writeToFile(String filename, Character character) throws FileNotFoundException {
		PrintWriter writer;
		writer = new PrintWriter(filename);
		writer.println(character);
		writer.flush();
		writer.close();
	}
	
	@Override
	public void readFromFile(String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filename));
		this.name = getStringValueOnly(scanner.nextLine());
		this.gender = getStringValueOnly(scanner.nextLine()); 
		this.race = getStringValueOnly(scanner.nextLine());
		this.classes = getStringValueOnly(scanner.nextLine());
		this.health = Integer.parseInt(getStringValueOnly(scanner.nextLine()));
		this.stamina = Integer.parseInt(getStringValueOnly(scanner.nextLine()));
		this.strength = Integer.parseInt(getStringValueOnly(scanner.nextLine()));
		this.dexterity = Integer.parseInt(getStringValueOnly(scanner.nextLine()));
		this.constitution = Integer.parseInt(getStringValueOnly(scanner.nextLine()));
		this.intelligence = Integer.parseInt(getStringValueOnly(scanner.nextLine()));
		this.wisdom = Integer.parseInt(getStringValueOnly(scanner.nextLine()));
		this.charisma = Integer.parseInt(getStringValueOnly(scanner.nextLine()));
		this.equipment = getListValuesOnly(scanner.nextLine());
		this.getTextFields(scanner);
		this.isBuildValid();
		
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		CharManager manager = new CharManager();
		manager.readFromFile("CharManagerTestSheet");
		
	}



	
	
	
}

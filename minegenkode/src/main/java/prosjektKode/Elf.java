package prosjektKode;

public class Elf extends Character implements CommonFeatures{

	public Elf(String name, String gender, String classes, int strength, int dexterity, int constitution, int intelligence, int wisdom,
			int charisma, String appearance, String backstory, String other) {
		super(name, gender, classes, strength, dexterity, constitution, intelligence, wisdom, charisma, appearance, backstory, other);
		// TODO Auto-generated constructor stub
		this.racialPerks();
		this.racialDisadvantage();
		this.setRace();
		this.checkAbilitySum();
	}

	@Override
	public void racialPerks() {
		// TODO Auto-generated method stub
		this.dexterity += 1;
		this.wisdom += 1;
		
	}

	@Override
	public void racialDisadvantage() {
		// TODO Auto-generated method stub
		this.strength -= 1;
	}

	@Override
	public void setRace() {
		// TODO Auto-generated method stub
		this.race = "Elf";
		
	}
	
	@Override
	public void checkAbilitySum() {
		// TODO Auto-generated method stub
		if(this.strength + this.dexterity + this.constitution + this.intelligence + this.wisdom + this.charisma != 73) {
			throw new IllegalArgumentException("The sum of ability scores must be 73!");
		}
		
	}

}

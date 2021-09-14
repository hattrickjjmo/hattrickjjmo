package prosjektKode;

public class Human extends Character implements CommonFeatures{

	public Human(String name, String gender, String classes, int strength, int dexterity, int constitution, int intelligence, int wisdom,
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
		this.intelligence += 1;
		this.charisma += 1;
		
	}

	@Override
	public void racialDisadvantage() {
		// TODO Auto-generated method stub
		this.wisdom -= 1;
		
	}

	@Override
	public void setRace() {
		// TODO Auto-generated method stub
		this.race = "Human";
	}

	@Override
	public void checkAbilitySum() {
		// TODO Auto-generated method stub
		if(this.strength + this.dexterity + this.constitution + this.intelligence + this.wisdom + this.charisma != 73) {
			throw new IllegalArgumentException("The sum of ability scores must be 73!");
		}
		
	}

	
	

}

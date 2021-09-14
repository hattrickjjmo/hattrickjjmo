package prosjektKode;

import java.util.Arrays;

import org.junit.jupiter.api.*;


public class CharacterTest {

	private Character char1;
	private Character char2;
	private Character char3;
	private Character char4;
	
	@BeforeEach
	public void setup() {
		
		char1 = new Character("Bruenor", "Unspecified", "Fighter", 15,14,13,12,10,8, "Pale", "Soldier", "Traumatized");
		char2 = new Human("Brennan", "Male", "Rogue", 15,14,13,12,10,8, "Short", "Thief", "Unhappy");
		char3 = new Elf("Lydia", "Female", "Wizard", 15,14,13,12,10,8, "Pretty", "Courtmage", "Immersed");
		char4 = new Orc("Gronk", "Male", "Bard", 15,14,13,12,10,8, "Green", "Beggar", "Cheerful");
	}
	
	@Test
	public void testCharacterFighter() {
		
		//Character 1: Bruenor, no gender, Fighter, no race
		
		Assertions.assertEquals("Bruenor", char1.getName());
		Assertions.assertEquals("Unspecified", char1.getGender());
		Assertions.assertEquals("Fighter", char1.getClasses());
		Assertions.assertNull(char1.getRace(), "Race not set yet");
		
		Assertions.assertEquals(130, char1.getHealth(), "Should equal CON * 10");
		Assertions.assertEquals(38, char1.getStamina(), "Should equal CON + 25");
		
		Assertions.assertEquals(15, char1.getStrength());
		Assertions.assertEquals(14, char1.getDexterity());
		Assertions.assertEquals(13, char1.getConstitution());
		Assertions.assertEquals(12, char1.getIntelligence());
		Assertions.assertEquals(10, char1.getWisdom());
		Assertions.assertEquals(8, char1.getCharisma());
		
		Assertions.assertEquals("Pale", char1.getAppearance());
		Assertions.assertEquals("Soldier", char1.getBackstory());
		Assertions.assertEquals("Traumatized", char1.getOther());
		
		Assertions.assertEquals(char1.fighterEquipment, char1.getEquipment());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Character("Bruenor", "Unspecified", "Fighter", 0,14,13,12,10,8, "Pale", "Soldier", "Traumatized");
		}, "Check if ability point given below 1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Character("Bruenor", "Unspecified", "Fighter", 21,14,13,12,10,8, "Pale", "Soldier", "Traumatized");
		}, "Check if ability point given above 20");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {char1.setGender("Binary");}, "Check if setting gender to not in available genders");
	}
	
	@Test
	public void testHumanRogue() {

		//Character 2: Brennan, Male, Rogue, Human
		
		Assertions.assertEquals("Male", char2.getGender());
		Assertions.assertEquals("Rogue", char2.getClasses());
		Assertions.assertEquals("Human", char2.getRace());
		
		Assertions.assertEquals(13, char2.getIntelligence(), "Should be +1 for Humans");
		Assertions.assertEquals(9, char2.getWisdom(), "Should be -1 for Humans");
		Assertions.assertEquals(9, char2.getCharisma(), "Should be +1 for Humans");
		
		Assertions.assertEquals(char2.rogueEquipment, char2.getEquipment());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Human("Brennan", "Male", "Rogue", 15,15,15,15,15,15, "Short", "Thief", "Unhappy");;
		}, "Check if ability points sum don't equal 73 (above)");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Human("Brennan", "Male", "Rogue", 1,1,1,1,1,1, "Short", "Thief", "Unhappy");;
		}, "Check if ability points sum don't equal 73 (below)");
	}
	
	@Test
	public void testElfWizard() {

		//Character 3: Lydia, Female, Wizard, Elf
		
		Assertions.assertEquals("Female", char3.getGender());
		Assertions.assertEquals("Wizard", char3.getClasses());
		Assertions.assertEquals("Elf", char3.getRace());
		
		Assertions.assertEquals(15, char3.getDexterity(), "Should be +1 for Elves");
		Assertions.assertEquals(14, char3.getStrength(), "Should be -1 for Elves");
		Assertions.assertEquals(11, char3.getWisdom(), "Should be +1 for Elves");
		
		Assertions.assertEquals(char3.wizardEquipment, char3.getEquipment());
		
	}
	
	@Test
	public void testOrcBard() {

		//Character 4: Gronk, Male, Bard, Orc
		Assertions.assertEquals("Bard", char4.getClasses());
		Assertions.assertEquals("Orc", char4.getRace());
		
		Assertions.assertEquals(16, char4.getStrength(), "Should be +1 for Orcs");
		Assertions.assertEquals(11, char4.getIntelligence(), "Should be -1 for Orcs");
		Assertions.assertEquals(14, char4.getConstitution(), "Should be +1 for Orcs");
		
		Assertions.assertEquals(140, char4.getHealth(), "Check Health after CON change");
		Assertions.assertEquals(39, char4.getStamina(), "Check Stamina after CON change");
		
		Assertions.assertEquals(char4.bardEquipment, char4.getEquipment());
	}
	
	@Test
	public void testAbilityChange() {
		
		char1.setStrength(16);
		Assertions.assertEquals(16, char1.getStrength(), "Check if abilty can be changed");
	}
	
	@Test
	public void testEquipmentChange() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {char1.setClasses("Berserker");}, "Check if setting class to not in available classes");
		char2.setClasses("Bard");
		Assertions.assertEquals(char2.bardEquipment, char2.getEquipment(), "Check if equipment changed after class change");
		
	}
	
}

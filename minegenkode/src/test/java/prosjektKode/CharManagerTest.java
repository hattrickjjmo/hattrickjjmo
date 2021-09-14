package prosjektKode;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharManagerTest {
	
	private CharManager manager;
	
	@BeforeEach
	public void setup() {
		manager = new CharManager();
	}
	
	@Test
	public void testGetStringValueOnly() {
		String s = "name: Jonah";
		Assertions.assertEquals("Jonah", manager.getStringValueOnly(s));
	}
	
	@Test
	public void testGetListValuesOnly() {
		String s = "equipment: [Longjohns, Knife, Halberd]";
		Assertions.assertEquals(Arrays.asList("Longjohns", "Knife", "Halberd"), manager.getListValuesOnly(s));
	}
	
	@Test
	public void testReadFromFile() {
		Assertions.assertThrows(FileNotFoundException.class, () -> {manager.readFromFile("doesNotExist");});
	}

}

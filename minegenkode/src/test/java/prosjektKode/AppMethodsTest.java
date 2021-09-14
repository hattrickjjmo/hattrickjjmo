package prosjektKode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class AppMethodsTest {

	private AppMethods methods;
	
	@BeforeEach
	public void setup() {
		methods = new AppMethods();
	}
	
	@Test
	public void testIsNumeric() {
		Assertions.assertFalse(methods.isNumeric("yolo"));
		Assertions.assertTrue(methods.isNumeric("15"));
	}
	
}

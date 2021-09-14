package prosjektKode;

import java.io.FileNotFoundException;

public interface FileManaging {

	public void writeToFile(String filename, Character character) throws FileNotFoundException;
	public void readFromFile(String filename) throws FileNotFoundException;
}

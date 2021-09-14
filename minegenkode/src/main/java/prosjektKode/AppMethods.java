package prosjektKode;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;


public class AppMethods {
	
	
	//ABILITY
    public boolean isNumeric(String strNum) {  //tip: https://www.baeldung.com/java-check-string-number
        try {
            double d = Double.parseDouble(strNum);
        } 
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public void checkAbilitiesValid(TextField strField, TextField dexField, 
										TextField conField, TextField intField, TextField wisField, TextField chrField,
										Tab raceTab, TabPane tabPane, Tab abilityTab) {
    	String str = strField.getText();
    	String dex = dexField.getText();
    	String con = conField.getText();
    	String intel = intField.getText();
    	String wis = wisField.getText();
    	String chr = chrField.getText();
    	if(isNumeric(str) == false || isNumeric(dex) == false || isNumeric(con) == false 
    		|| isNumeric(intel) == false || isNumeric(wis) == false || isNumeric(chr) == false) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Error Dialog");
    		alert.setHeaderText("Input Error");
    		alert.setContentText("Please write an integer between 1 and 20 in the input fields!");
    		alert.showAndWait();
    	}
    	else {
    		int Strength = Integer.parseInt(str);
    		int Dexterity = Integer.parseInt(dex);
    		int Constitution = Integer.parseInt(con);
    		int Intelligence = Integer.parseInt(intel);
    		int Wisdom = Integer.parseInt(wis);
    		int Charisma = Integer.parseInt(chr);
    		if((Strength + Dexterity + Constitution + Intelligence + Wisdom + Charisma) != 72) {
    			Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("Error Dialog");
        		alert.setHeaderText("Input Error");
        		alert.setContentText("The sum of ability scores must be 72!");
        		alert.showAndWait();
    		}
    		else if((Strength < 1 || Strength > 20) || (Dexterity < 1 || Dexterity > 20) || (Constitution < 1 || Constitution > 20) 
    				|| (Intelligence < 1 || Intelligence > 20) || (Wisdom < 1 || Wisdom > 20) || (Charisma < 1 || Charisma > 20)) {
    			Alert alert = new Alert(AlertType.ERROR);
        		alert.setTitle("Error Dialog");
        		alert.setHeaderText("Input Error");
        		alert.setContentText("The value of a field can not exceed 20 or be below 1!");
        		alert.showAndWait();
    		}
    		else {
    			raceTab.setDisable(false);
            	tabPane.getSelectionModel().select(raceTab);
            	abilityTab.setDisable(true);
    		}
    	}
    }
    
    
}

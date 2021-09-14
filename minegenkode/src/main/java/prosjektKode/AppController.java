package prosjektKode;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import prosjektKode.Character;

public class AppController {
	
	//VARIABLES
	private String name;
	private String gender;
	private String race;
	private String classes;
	
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	
	private String appearance;
	private String backstory;
	private String other;
	
	//SETTERS
	
	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	

	//TABS
    @FXML private TabPane tabPane;
    @FXML private Tab introTab;
    @FXML private Tab abilityTab;
    @FXML private Tab raceTab;
    @FXML private Tab classTab;
    @FXML private Tab descriptionTab;
    @FXML private Tab endTab;
    
    //INTRO TAB
    @FXML private TextField loadField;
    @FXML private Button openBtn;
	@FXML private TextField nameField;
	@FXML private ChoiceBox genderChoice;
	@FXML private Button loadBtn;
	@FXML private Button introNxtBtn;
	ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female", "Unspecified");
	
	//ABILITY TAB
	@FXML private TextField strField;
    @FXML private TextField dexField;
    @FXML private TextField conField;
    @FXML private TextField intField;
    @FXML private TextField wisField;
    @FXML private TextField chrField;
    @FXML private Button abilityNxtBtn;
	
	
	//RACE TAB
    @FXML private ToggleGroup Race;
    @FXML private Button raceNxtBtn;
    @FXML private RadioButton humanToggle;
    @FXML private RadioButton elfToggle;
    @FXML private RadioButton orcToggle;
    
    
    //CLASS TAB
    @FXML private ToggleGroup Class;
    @FXML private RadioButton fighterToggle;
    @FXML private RadioButton wizardToggle;
    @FXML private RadioButton rogueToggle;
    @FXML private RadioButton bardToggle;
    @FXML private Button classNxtBtn;
    
    //DESRIPTION TAB
    @FXML private TextArea appText;
    @FXML private TextArea backText;
    @FXML private TextArea otherText;
    
    //SAVE & END TAB
    @FXML private Button endBtn;
    
    
    //APP METHODS
    AppMethods methods = new AppMethods();
    
    //FILE HANDLING
    CharManager manager = new CharManager();
    String filename = "characterSheet";
    

    
    //-------------------METHODS------------------------
    
    //INTRO & INITIALIZE
    @FXML
    private void initialize() {
    	genderChoice.setItems(genderList);
    	genderChoice.setValue("Male");
    	abilityTab.setDisable(true);
    	raceTab.setDisable(true);
    	classTab.setDisable(true);
    	descriptionTab.setDisable(true);
    	endTab.setDisable(true);
    	
    }
    
  //INTRO
	
	
  	public void onBrowseBtnClick() { //tip: https://stackoverflow.com/questions/35450990/how-to-get-file-path-from-javafx-filechooser

          FileChooser fileChooser = new FileChooser();
          fileChooser.setTitle("Upload File Path");
          fileChooser.getExtensionFilters().addAll(
                  new FileChooser.ExtensionFilter("ALL FILES", "*.*"),
                  new FileChooser.ExtensionFilter("ZIP", "*.zip"),
                  new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                  new FileChooser.ExtensionFilter("TEXT", "*.txt"),
                  new FileChooser.ExtensionFilter("IMAGE FILES", "*.jpg", "*.png", "*.gif")
          );


          File file = fileChooser.showOpenDialog(openBtn.getScene().getWindow());

          if (file != null) {
              // pickUpPathField it's your TextField fx:id
              loadField.setText(file.getPath());

          } else  {
              System.out.println("error"); // or something else
          }

      }
  	
  	public void onLoadBtnClick() throws FileNotFoundException {
  		
  		filename = loadField.getText();
      	try {
      		manager.readFromFile(filename);
  		} catch (Exception e) {
  			Alert alert = new Alert(AlertType.ERROR);
      		alert.setTitle("Error Dialog");
      		alert.setHeaderText("File Error");
      		alert.setContentText("Please select a valid file!");
      		alert.showAndWait();
  		}
      	
      	nameField.setText(manager.name);
      	genderChoice.setValue(manager.gender);
      	strField.setText(Integer.toString(manager.strength));
      	dexField.setText(Integer.toString(manager.dexterity));
      	conField.setText(Integer.toString(manager.constitution));
      	intField.setText(Integer.toString(manager.intelligence));
      	wisField.setText(Integer.toString(manager.wisdom));
      	chrField.setText(Integer.toString(manager.charisma));
      	appText.setText(manager.appearance);
      	backText.setText(manager.backstory);
      	otherText.setText(manager.other);
      	
      	if(manager.race.equals("Human")) {
      		intField.setText(Integer.toString(manager.intelligence - 1));
      		chrField.setText(Integer.toString(manager.charisma - 1));
      		wisField.setText(Integer.toString(manager.wisdom + 1));
      		Race.selectToggle(humanToggle);
      	}
      	else if(manager.race.equals("Elf")) {
      		dexField.setText(Integer.toString(manager.dexterity - 1));
      		wisField.setText(Integer.toString(manager.wisdom - 1));
      		strField.setText(Integer.toString(manager.strength + 1));
      		Race.selectToggle(elfToggle);
      	}
      	else if(manager.race.equals("Orc")) {
      		strField.setText(Integer.toString(manager.strength - 1));
      		conField.setText(Integer.toString(manager.constitution - 1));
      		intField.setText(Integer.toString(manager.intelligence + 1));
      		Race.selectToggle(orcToggle);
      	}
      	
      	if(manager.classes.equals("Fighter")) {
      		Class.selectToggle(fighterToggle);
      	}
      	else if(manager.classes.equals("Wizard")) {
      		Class.selectToggle(wizardToggle);
      	}
      	else if(manager.classes.equals("Rogue")) {
      		Class.selectToggle(rogueToggle);
      	}
      	else if(manager.classes.equals("Bard")) {
      		Class.selectToggle(bardToggle);
      	}
      	
      }
  	
  	public void onIntroButtonClick() {
      	name = nameField.getText();
      	gender = (String) genderChoice.getValue();
      	if (!genderList.contains(gender)) {
      		Alert alert = new Alert(AlertType.ERROR);
      		alert.setTitle("Error Dialog");
      		alert.setHeaderText("Input Error");
      		alert.setContentText("...How did you fuck up the gender, like wow man....\nThis is some weird error...");
      		alert.showAndWait();
  		}
      	else {
      		abilityTab.setDisable(false);
          	tabPane.getSelectionModel().select(abilityTab);
          	introTab.setDisable(true);
      	}
      }
  	
  	public void introKeyReleasedProperty() {
      	String name = nameField.getText();
      	boolean isDisabled = name.isEmpty();
      	introNxtBtn.setDisable(isDisabled);
      }
  	
  	
  	//ABILITY
  	public void abilityKeyReleasedProperty() {
      	String str = strField.getText();
      	String dex = dexField.getText();
      	String con = conField.getText();
      	String intel = intField.getText();
      	String wis = wisField.getText();
      	String chr = chrField.getText();
      	
      	boolean isDisabled = (str.isEmpty()) || (dex.isEmpty()) || (con.isEmpty()) 
      							|| (intel.isEmpty()) || (wis.isEmpty()) || (chr.isEmpty());
      	abilityNxtBtn.setDisable(isDisabled);
      	
      }
      
      public void onAbilityNxtButtonClick() {
      	methods.checkAbilitiesValid(strField, dexField, conField, intField, wisField, chrField, raceTab, tabPane, abilityTab);
      	this.setStrength(Integer.parseInt(strField.getText()));
      	this.setDexterity(Integer.parseInt(dexField.getText()));
      	this.setConstitution(Integer.parseInt(conField.getText()));
      	this.setIntelligence(Integer.parseInt(intField.getText()));
      	this.setWisdom(Integer.parseInt(wisField.getText()));
      	this.setCharisma(Integer.parseInt(chrField.getText()));
      	
      }
      
      public void onAbilityPrvButtonClick() {
      	
      	tabPane.getSelectionModel().select(introTab);
      	abilityTab.setDisable(true);
      	introTab.setDisable(false);
      }
      	
  	
      //RACE
      public void onToggleRaceClick() {
      	raceNxtBtn.setDisable(false);
      }
      
      public void onRaceNxtButtonClick() {
      	race = Race.getSelectedToggle().toString();
      	race = (race.substring(race.indexOf("'")+1, race.length()-1));
      	classTab.setDisable(false);
      	tabPane.getSelectionModel().select(classTab);
      	raceTab.setDisable(true);
      	
      }
      
      public void onRacePrvButtonClick() {
      	tabPane.getSelectionModel().select(abilityTab);
      	raceTab.setDisable(true);
      	abilityTab.setDisable(false);
      }
      
      
    //CLASS
      public void onToggleClassClick() {
      	classNxtBtn.setDisable(false);
      }
      
      public void onClassNxtButtonClick() {
      	classes = Class.getSelectedToggle().toString();
      	classes = (classes.substring(classes.indexOf("'")+1, classes.length()-1));
      	descriptionTab.setDisable(false);
      	tabPane.getSelectionModel().select(descriptionTab);
      	classTab.setDisable(true);
      }
      
      public void onClassPrvButtonClick() {
      	tabPane.getSelectionModel().select(raceTab);
      	classTab.setDisable(true);
      	raceTab.setDisable(false);
      }
      
      
    //DESCRIPTION
      public void onDescriptNxtButtonClick() {
      	appearance = appText.getText();
      	backstory = backText.getText();
      	other = otherText.getText();
      	descriptionTab.setDisable(true);
      	endTab.setDisable(false);
      	tabPane.getSelectionModel().select(endTab);
      	
      }
      
      public void onDescriptPrvButtonClick() {
      	descriptionTab.setDisable(true);
      	classTab.setDisable(false);
      	tabPane.getSelectionModel().select(classTab);
      }
      
  	
    //SAVE & END
      public void onEndPrvButtonClick() {
      	endTab.setDisable(true);
      	descriptionTab.setDisable(false);
      	tabPane.getSelectionModel().select(descriptionTab);
      }

      public void handleCloseButtonAction(ActionEvent event) throws FileNotFoundException {
      	
      	Stage stage = (Stage) endBtn.getScene().getWindow();
          stage.close();
          
		if (race.equals("Human")) {
			Character character = new Human(name, gender, classes, strength, dexterity, 
					constitution, intelligence, wisdom, charisma,
					appearance, backstory, other);
		  	manager.writeToFile(filename, character);
		}
          
      	else if (race.equals("Elf")) {
      		Character character = new Elf(name, gender, classes, strength, dexterity, 
      				constitution, intelligence, wisdom, charisma,
      				appearance, backstory, other);
          	manager.writeToFile(filename, character);
      	}
      	else if (race.equals("Orc")) {
      		Character character = new Orc(name, gender, classes, strength, dexterity, 
      				constitution, intelligence, wisdom, charisma,
      				appearance, backstory, other);
          	manager.writeToFile(filename, character);
      	}
          
      	
      	
      	
      	
      }
    
    
    
}

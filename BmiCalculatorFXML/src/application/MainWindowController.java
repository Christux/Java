package application;

import bmi.Gender;
import bmi.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainWindowController {

	@FXML
	private TextField tflFirstName;

	@FXML
	private TextField tflLastName;

	@FXML
	private ToggleGroup gGender;

	@FXML
	private TextField tflSize;

	@FXML
	private TextField tflWeight;

	@FXML
	private TextField tflBmi;

	@FXML
	private TextField tflDiag;

	@FXML
	private TextField tflMinWeight;

	@FXML
	private TextField tflMaxWeight;

	@FXML
	private TextField tflIdealWeight;

	@FXML
	private Button button;

	@FXML
	public void run() {

		p.setFirstname(tflFirstName.getText());
		p.setLastname(tflLastName.getText());

		if(gGender.getSelectedToggle().getUserData().toString().equals("M")) p.setGender(Gender.M);
		else p.setGender(Gender.F);

		p.setSize(Double.parseDouble(tflSize.getText())*1e-2);
		p.setWeight(Double.parseDouble(tflWeight.getText()));

		tflBmi.setText(((Double) p.computeIMC()).toString());
		tflDiag.setText(p.diagnosys());
		tflMinWeight.setText(((Double) p.computeMinWeight()).toString());
		tflMaxWeight.setText(((Double) p.computeMaxWeight()).toString());
		tflIdealWeight.setText(((Double) p.computeIdealWeight()).toString());
	}


	@FXML
	public void checkFirstNames() {
		 checkField(tflFirstName,"^[a-z A-Z]+$");
	}
	
	@FXML
	public void checkLastNames() {
		 checkField(tflLastName,"^[a-z A-Z]+$");
	}
	
	@FXML
	public void checkSize() {
		 checkField(tflSize,"^[0-9]+$");
	}
	
	@FXML
	public void checkWeight() {
		 checkField(tflWeight,"^[0-9]+$");
	}
	
	public void buttonValidate() {
		
		button.setDisable(
				!isValid(tflFirstName,"^[a-z A-Z]+$")
				|| !isValid(tflLastName,"^[a-z A-Z]+$")
				|| !isValid(tflSize,"^[0-9]+$")
				|| !isValid(tflWeight,"^[0-9]+$"));
	}
	
	private Person p = new Person();
	private String error = "-fx-focus-color: red;";
	private String noerror = "-fx-focus-color: blue;";
	
	public boolean isValid(TextField tf, String reg) {
		
		return !tf.getText().isEmpty() && tf.getText().matches(reg);
	}

	private void checkField(TextField tf, String reg) {

		if(!isValid(tf,reg)) {
			tf.setStyle(error);
		}
		else {
			tf.setStyle(noerror);
		}
		
		buttonValidate();
	}


}

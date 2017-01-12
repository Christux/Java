package application;

import bmi.Gender;
import bmi.Person;
import javafx.fxml.FXML;
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
	public void run() {
		
		Person p = new Person();
		
		if(!checkValidity()) {
    		
    	}
    	else {
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
    }
		
	
private boolean matchWithRegex(TextField tf, String reg) {
	
	String error = "-fx-text-box-border: red;";
	String noerror = "-fx-text-box-border: green;";
	
	if(!tf.getText().matches(reg)) {
		tf.setStyle(error);
		return false;
	}
	
	tf.setStyle(noerror);
	return true;
}
	
private boolean checkValidity() {
		
		if(!matchWithRegex(tflFirstName,"^[a-z A-Z]+$")) return false;
		if(!matchWithRegex(tflLastName,"^[a-z A-Z]+$")) return false;
		if(!matchWithRegex(tflSize,"^[0-9]+$")) return false;
		if(!matchWithRegex(tflWeight,"^[0-9]+$")) return false;
		
    	return true;
    }
	
}

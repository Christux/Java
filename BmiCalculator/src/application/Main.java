package application;
	
import bmi.Gender;
import bmi.Person;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	
	private TextField tflFirstName;
	private TextField tflLastName;
	private TextField tflSize;
	private TextField tflWeight;
	
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
	
	@Override
	public void start(Stage primaryStage) {
		
		Person p = new Person();
		
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,300,420);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		    			
			GridPane gridpane = new GridPane();
			root.setCenter(gridpane);
		    gridpane.setPadding(new Insets(5));
		    gridpane.setHgap(5);
		    gridpane.setVgap(5);
		    ColumnConstraints column1 = new ColumnConstraints(100);
		    ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
		    column2.setHgrow(Priority.ALWAYS);
		    gridpane.getColumnConstraints().addAll(column1, column2);
		    	    
		    Text scenetitle = new Text("Body Mass Index calculator");
		    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
		    
		    
		    Label lblFirstName = new Label("Firstname");
		    tflFirstName = new TextField ();
		    Label lblLastName = new Label("Lastname");
		    tflLastName = new TextField ();
		    
		    Label lblGender = new Label("Gender");
		    
		    HBox genderHBox = new HBox();
		    
		    final ToggleGroup gGender = new ToggleGroup();

		    RadioButton btGenderM = new RadioButton("Male");
		    btGenderM.setToggleGroup(gGender);
		    btGenderM.setUserData("M");
		    btGenderM.setSelected(true);

		    RadioButton btGenderF = new RadioButton("Female");
		    btGenderF.setToggleGroup(gGender);
		    btGenderF.setUserData("F");
		    genderHBox.getChildren().addAll(btGenderM,btGenderF);
		     
		    Label lblSize = new Label("Size (cm)");
		    tflSize = new TextField ();
		    
		    Label lblWeight = new Label("Weight (kg)");
		    tflWeight = new TextField ();
		    
		    Button runButton = new Button("Compute BMI");
		    runButton.setPrefSize(100, 20);
		    
		    Label lblBmc = new Label("BMC");
		    TextField tflBmc = new TextField ();
		    tflBmc.setDisable(true);
		    
		    Label lblDiag = new Label("Diagnosys");
		    TextField tflDiag = new TextField ();
		    tflDiag.setDisable(true);
		    
		    Label lblMinWeight = new Label("Minimum weight");
		    TextField tflMinWeight = new TextField ();
		    tflMinWeight.setDisable(true);
		    
		    Label lblMaxWeight = new Label("Maximum weight");
		    TextField tflMaxWeight = new TextField ();
		    tflMaxWeight.setDisable(true);
		    
		    Label lblIdealWeight = new Label("Ideal weight");
		    TextField tflIdealWeight = new TextField ();
		    tflIdealWeight.setDisable(true);
		    
		    
		    /*
		     * Grid
		     */
		    int j=0;
		    
		    // Title
		    GridPane.setHalignment(scenetitle, HPos.CENTER);
		    GridPane.setColumnSpan(scenetitle, 2);
		    GridPane.setMargin(scenetitle, new Insets(10,0,20,0));
		    gridpane.add(scenetitle, 0, j++, 2, 1);
		    
		    
		    // Labels Column
		    GridPane.setHalignment(lblFirstName, HPos.RIGHT);
		    gridpane.add(lblFirstName, 0, j++);
		    GridPane.setHalignment(lblLastName, HPos.RIGHT);
		    gridpane.add(lblLastName, 0, j++);
		    GridPane.setHalignment(lblGender, HPos.RIGHT);
		    gridpane.add(lblGender, 0, j++);
		    GridPane.setHalignment(lblSize, HPos.RIGHT);
		    gridpane.add(lblSize, 0, j++);
		    GridPane.setHalignment(lblWeight, HPos.RIGHT);
		    gridpane.add(lblWeight, 0, j++);
		    j++; // button
		    GridPane.setHalignment(lblBmc, HPos.RIGHT);
		    gridpane.add(lblBmc, 0, j++);
		    GridPane.setHalignment(lblDiag, HPos.RIGHT);
		    gridpane.add(lblDiag, 0, j++);
		    GridPane.setHalignment(lblMinWeight, HPos.RIGHT);
		    gridpane.add(lblMinWeight, 0, j++);
		    GridPane.setHalignment(lblMaxWeight, HPos.RIGHT);
		    gridpane.add(lblMaxWeight, 0, j++);
		    GridPane.setHalignment(lblIdealWeight, HPos.RIGHT);
		    gridpane.add(lblIdealWeight, 0, j++);

		    j=1;
		    
		    // TextBoxes column
		    GridPane.setHalignment(tflFirstName, HPos.LEFT);
		    gridpane.add(tflFirstName, 1, j++);
		    GridPane.setHalignment(tflLastName, HPos.LEFT);
		    gridpane.add(tflLastName, 1, j++);
		    GridPane.setHalignment(genderHBox, HPos.LEFT);
		    gridpane.add(genderHBox, 1, j++);
		    GridPane.setHalignment(tflSize, HPos.LEFT);
		    gridpane.add(tflSize, 1, j++);
		    GridPane.setHalignment(tflWeight, HPos.LEFT);
		    gridpane.add(tflWeight, 1, j++);
		    
		    // button
		    GridPane.setHalignment(runButton, HPos.CENTER);
		    GridPane.setColumnSpan(runButton, 2);
		    GridPane.setMargin(runButton, new Insets(10,0,20,0));
		    gridpane.add(runButton, 0, j++);
		    
		    GridPane.setHalignment(tflBmc, HPos.RIGHT);
		    gridpane.add(tflBmc, 1, j++);
		    GridPane.setHalignment(tflDiag, HPos.RIGHT);
		    gridpane.add(tflDiag, 1, j++);
		    GridPane.setHalignment(tflMinWeight, HPos.RIGHT);
		    gridpane.add(tflMinWeight, 1, j++);
		    GridPane.setHalignment(tflMaxWeight, HPos.RIGHT);
		    gridpane.add(tflMaxWeight, 1, j++);
		    GridPane.setHalignment(tflIdealWeight, HPos.RIGHT);
		    gridpane.add(tflIdealWeight, 1, j++);
		    
		    		    
		    /*
		     * Attach events
		     */
		    runButton.setOnAction((event)->{
		    	
		    	if(!checkValidity()) {
		    		
		    	}
		    	else {
		    		p.setFirstname(tflFirstName.getText());
			    	p.setLastname(tflLastName.getText());
			    	
			    	if(gGender.getSelectedToggle().getUserData().toString().equals("M")) p.setGender(Gender.M);
			    	else p.setGender(Gender.F);

			    	p.setSize(Double.parseDouble(tflSize.getText())*1e-2);
			    	p.setWeight(Double.parseDouble(tflWeight.getText()));
			    	
			    	tflBmc.setText(((Double) p.computeIMC()).toString());
			    	tflDiag.setText(p.diagnosys());
			    	tflMinWeight.setText(((Double) p.computeMinWeight()).toString());
			    	tflMaxWeight.setText(((Double) p.computeMaxWeight()).toString());
			    	tflIdealWeight.setText(((Double) p.computeIdealWeight()).toString());
		    	}
		    });
		    
		    
		    primaryStage.setTitle("Simple body mass index calculator");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

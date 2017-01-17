package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GameOfLife.fxml"));
			BorderPane root = (BorderPane)loader.load();
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("GameOfLife.fxml"));
			//BorderPane root = new BorderPane();
			
			Scene scene = new Scene(root,400,460);
			//Scene scene = new Scene(root,n*cellWidth,m*cellWidth+30);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
	        primaryStage.setTitle("Game Of Life");
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

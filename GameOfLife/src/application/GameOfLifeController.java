package application;

import java.net.URL;
import java.util.ResourceBundle;

import core.gameoflife.GameOfLifeClassicRules;
import core.gameoflife.IGameOfLife;
import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameOfLifeController implements Initializable {
	
	private final int m=20;
	private final int n=20;
	private final int cellWidth=20;
	
	private GCellGrid cg;
	private IGameOfLife gol;
	
	private Timeline timeline;
	
	private void glider(int i, int j) {
		gol.bornCell(i+2, j);
		gol.bornCell(i+2, j+1);
		gol.bornCell(i+2, j+2);
		gol.bornCell(i+1, j+2);
		gol.bornCell(i, j+1);
	}
	
	private void blinker(int i, int j) {
		gol.bornCell(i, j);
		gol.bornCell(i, j+1);
		gol.bornCell(i, j+2);
	}
	
	private void setup() {
		blinker(3,15);
		glider(2,2);
	}
	
	private void draw() {
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				cg.setCellState(i, j, gol.isAlive(i, j));
			}
		}
	}
	
	private void randomize() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				
				if((int)(Math.random()*3)==1){
					gol.bornCell(i, j);
				}
			}
		}
	}
	
	
	
	@FXML
	HBox cellgrid;
	
	/*@FXML
	MenuItem exit;*/
	
	@FXML
	Button runButton;
	
	/*@FXML
    Button resetButton;
	
	@FXML
    Button randButton;*/
	
	@FXML
	public void exit() {
		Platform.exit();
	}
	
	@FXML
	public void clickOnGrid(MouseEvent event) {

		int j = ((int)event.getX()/cellWidth)%n;
		int i = ((int)event.getY()/cellWidth)%m;

		if(gol.isAlive(i, j)) {
			gol.killCell(i, j);
		}
		else {
			gol.bornCell(i, j);
		}

		cg.setCellState(i, j, gol.isAlive(i, j));
	}
	      
	@FXML
	public void pauseStart() {
		
		if(timeline.getStatus()==Status.RUNNING) {
			timeline.pause();
			runButton.setText("Play");
		}
		else {
			timeline.play();
			runButton.setText("Pause");
		}
	}
	
	@FXML
	public void reset() {
		
		gol.reset();
		timeline.pause();
		runButton.setText("Play");
		draw();
	}
	
	@FXML
	public void random() {
		
		gol.reset();
		randomize();
		timeline.pause();
		runButton.setText("Play");
		draw();
	}
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cg = new GCellGrid(m,n,cellWidth);
		gol = new GameOfLifeClassicRules(m,n);
		setup();
		draw();
		cellgrid.getChildren().add(cg.getGroup());
		
		timeline = new Timeline(new KeyFrame(
		        Duration.millis(200),
		        ae -> {
		            	gol.nextStep();
		            	draw();
		            }
				));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	
}

package application;

import java.net.URL;
import java.util.ResourceBundle;

import core.gameoflife.DayAndNight;
import core.gameoflife.GameOfLifeClassic;
import core.gameoflife.HighLife;
import core.gameoflife.IGameOfLife;
import core.gameoflife.Library;
import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class GameOfLifeController implements Initializable {
	
	private final int m=30;
	private final int n=40;
	private final int cellWidth=20;
	
	private final double minTimeStep=20;
	private final double maxTimeStep=500;
	
	private GCellGrid cg;
	private IGameOfLife gol;
	
	private Timeline timeline;
	
	private void setup() {
		/*blinker(3,15);
		glider(2,2);*/
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
				
				if((int)(Math.random()*2)==1){
					gol.bornCell(i, j);
				}
			}
		}
	}
	
	@FXML
	HBox cellgrid;
	
	@FXML
	MenuItem pauseStart;
	
	@FXML
	Button runButton;
	
	@FXML
	Slider speedSlider;
	
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
	public void speedChange() {
		
		double speed = minTimeStep + (1-speedSlider.getValue())*maxTimeStep;
		
		resetTimer(speed);
	}
	
	public void resetTimer(final double timeStep) {
		
		KeyFrame keyFrame =new KeyFrame(
		        Duration.millis(timeStep),
		        ae -> {
		            	gol.nextStep();
		            	draw();
		            }
				);
		
		timeline.stop();
        timeline.getKeyFrames().setAll(
                keyFrame
        );
        timeline.play();
	}
	
	@FXML
	public void pauseStart() {
		
		if(timeline.getStatus()==Status.RUNNING) {
			pauseAnim();
		}
		else {
			playAnim();
		}
	}
	
	public void pauseAnim() {
		timeline.pause();
		runButton.setText("Play");
		pauseStart.setText("Play");
	}
	
	public void playAnim() {
		timeline.play();
		runButton.setText("Pause");
		pauseStart.setText("Pause");
	}
	
	@FXML
	public void reset() {
		
		pauseAnim();
		gol.reset();
		draw();
	}
	
	@FXML
	public void random() {
		
		pauseAnim();
		gol.reset();
		randomize();
		draw();
	}
	
	/*
	 * Changing rules
	 */
	
	@FXML
	public void changeRulesToClassic() {
		gol = new GameOfLifeClassic(m,n,gol.getCells(),gol.getNeighboors());
	}
	
	@FXML
	public void changeRulesToHighLife() {
		gol = new HighLife(m,n,gol.getCells(),gol.getNeighboors());
	}
	
	@FXML
	public void changeRulesToDayAndNight() {
		gol = new DayAndNight(m,n,gol.getCells(),gol.getNeighboors());
	}
	
	/*
	 * Import patterns
	 */
	@FXML
	public void importClock() {
		reset();
		gol.importPattern(4, 4, Library.clock);
		draw();
	}
	
	@FXML
	public void importGalaxy() {
		reset();
		gol.importPattern(4, 4, Library.galaxy);
		draw();
	}
	
	@FXML
	public void importStar() {
		reset();
		gol.importPattern(4, 4, Library.star);
		draw();
	}
	
	@FXML
	public void importAirforce() {
		reset();
		gol.importPattern(4, 4, Library.airforce);
		draw();
	}
	
	@FXML
	public void importOctagon() {
		reset();
		gol.importPattern(4, 4, Library.octagon);
		draw();
	}
	
	@FXML
	public void importChristux() {
		reset();
		gol.importPattern(4, 4, Library.christux);
		draw();
	}
	
	@FXML
	public void importPhoenix() {
		reset();
		gol.importPattern(4, 4, Library.phoenix);
		draw();
	}
	
	@FXML
	public void importGlider() {
		reset();
		gol.importPattern(1, 1, Library.glider);
		draw();
	}
	
	@FXML
	public void importTripole() {
		reset();
		gol.importPattern(4, 4, Library.tripole);
		draw();
	}
	
	@FXML
	public void importPentadecathlon() {
		reset();
		gol.importPattern(4, 4, Library.pentadecathlon);
		draw();
	}
	
	@FXML
	public void importGospergun() {
		reset();
		gol.importPattern(3, 1, Library.gospergun);
		draw();
	}
	
	/*
	 * About
	 */
	@FXML
	public void about() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("About");
		alert.setHeaderText("Game Of Life");
		alert.setContentText("Copyright Christux 2017");
		alert.showAndWait();
	}
	
	/*
	 * 	(non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cg = new GCellGrid(m,n,cellWidth);
		gol = new GameOfLifeClassic(m,n);
		setup();
		draw();
		cellgrid.getChildren().add(cg.getGroup());
		
		double timestep=200;
		timeline = new Timeline(new KeyFrame(
		        Duration.millis(timestep),
		        ae -> {
		            	gol.nextStep();
		            	draw();
		            }
				));
		timeline.setCycleCount(Animation.INDEFINITE);
		speedSlider.setValue(1-(timestep-minTimeStep)/maxTimeStep);
		//timeline.play();
		pauseAnim();
	}
	
	
}

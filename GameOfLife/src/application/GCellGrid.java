package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class GCellGrid {
	
	private int m;
	private int n;
	private GCell[] cells;

	public GCellGrid(int m, int n, int width) {
		this.m=m;
		this.n=n;
		this.cells=new GCell[m*n];
		
		// Init cell grid
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				cells[i*n+j] = new GCell(j*(width), i*(width), width);
			}
		}
	}
	
	public Group getGroup() {
		Group g=new Group();
		for(int i=0; i<m*n; i++) {
			g.getChildren().add(cells[i].getPolygon());
		}
		return g;
	}
	
	public void setCellState(int i, int j, boolean isAlive) {
		
		if(isAlive) {
			cells[i*n+j].getPolygon().setFill(Color.CORAL);
		}
		else {
			cells[i*n+j].getPolygon().setFill(Color.CADETBLUE);
		}
	}
}

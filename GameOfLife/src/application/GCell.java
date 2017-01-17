package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class GCell {
	
	private Polygon polygon;
	
	public GCell(double i, double j, double width) {
		
		polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
            i, j,
            i+width, j,
            i+width, j+width,
            i, j+width});
        polygon.setStroke(Color.LIGHTGRAY);
	}
	
	public Polygon getPolygon() {
		return polygon;
	}
}

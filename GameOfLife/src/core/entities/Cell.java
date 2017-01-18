package core.entities;

public class Cell {
	
	private boolean state;
	private int nbNeighboors;

	public Cell() {
		this.state=false;
		this.nbNeighboors=0;
	}
	
	public void kill() {
		setState(false);
	}
	
	public void born() {
		setState(true);
	}

	public boolean isAlive() {
		return state;
	}

	private void setState(boolean state) {
		this.state = state;
	}
	
	public void setNeighboor(int value) {
		this.nbNeighboors=value;
	}
	
	public int getNeighboor() {
		return this.nbNeighboors;
	}

}

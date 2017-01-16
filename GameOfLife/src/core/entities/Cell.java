package core.entities;

public class Cell {
	
	private boolean state;

	public Cell() {
		this.state=false;
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

}

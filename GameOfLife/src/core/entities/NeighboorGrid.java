package core.entities;

public class NeighboorGrid {
	
	private int m;
	private int n;
	private int[] neighboors;

	public NeighboorGrid(int m, int n) {
		this.m=m;
		this.n=n;
		this.neighboors=new int[m*n];
	}
	
	public void setNeighboor(int i, int j, int value) {
		this.neighboors[i*n+j]=value;
	}

	public int getNeighboor(int i, int j) {
		return this.neighboors[i*n+j];
	}
	
	@Override
	public String toString() {

		String grid="";

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				grid+=getNeighboor(i,j)+" ";
			}
			grid+="\n";
		}
		return grid;
	}
}

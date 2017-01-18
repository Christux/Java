package core.gameoflife;

import core.entities.CellGrid;

public interface IGameOfLife {
	
	boolean isAlive(int i, int j);
	void bornCell(int i, int j);
	void killCell(int i, int j);
	void nextStep();
	void reset();
	
	CellGrid getCells();
	void importPattern(int i, int j, String[] figure);
}

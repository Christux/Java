package core.gameoflife;

public interface IGameOfLife {
	
	boolean isAlive(int i, int j);
	void bornCell(int i, int j);
	void killCell(int i, int j);
	void nextStep();
}

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import core.gameoflife.GameOfLifeClassicRules;
import core.gameoflife.IGameOfLife;

public class GameOfLifeTest {

	@Test
	public void test() {
		
		IGameOfLife gol = new GameOfLifeClassicRules(4,6);
		
		gol.bornCell(2, 1);
		gol.bornCell(2, 2);
		gol.bornCell(2, 3);
		gol.nextStep();
		
		assertEquals(false, gol.isAlive(2, 1));
		assertEquals(true, gol.isAlive(2, 2));
		assertEquals(true, gol.isAlive(1, 2));
	}

}

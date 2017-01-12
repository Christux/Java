package bmiTests;
import static org.junit.Assert.*;

import org.junit.Test;

import bmi.Gender;
import bmi.Person;

public class PersonTest {

	@Test
	public void personInit() {
		Person p = new Person("Jules","Cesar",65,1.65,Gender.M);
		
		assertEquals("Cesar", p.getLastname());
		assertEquals(1.65, p.getSize(),1e-5);
	}
	
	@Test
	public void imcComputationTest() {
		Person p = new Person("Jules","Cesar",65,1.65,Gender.M);
		assertEquals(23.87511, p.computeIMC(),1e-5);
	}
	
	@Test
	public void diagnosysTest() {
		Person p = new Person("Jules","Cesar",65,1.65,Gender.M);
		assertEquals("Normal", p.diagnosys());
		
		p = new Person("Jules","Cesar",95,1.65,Gender.M);
		assertEquals("Obesity", p.diagnosys());
	}
	
	@Test
	public void minWeightTest() {
		Person p = new Person("Jules","Cesar",65,1.65,Gender.M);
		assertEquals(51.7275, p.computeMinWeight(),1e-5);
	}
	
	@Test
	public void maxWeightTest() {
		Person p = new Person("Jules","Cesar",65,1.65,Gender.M);
		assertEquals(68.0625, p.computeMaxWeight(),1e-5);
	}
	
	@Test
	public void idealWeightTest() {
		Person p = new Person("Jules","Cesar",65,1.65,Gender.M);
		assertEquals(59.895, p.computeIdealWeight(),1e-5);
		
		p = new Person("Juliette","Cesar",65,1.65,Gender.F);
		assertEquals(57.1725, p.computeIdealWeight(),1e-5);
	}

}

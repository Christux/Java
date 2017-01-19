package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import list.SimpleList;

/**
 * Tests for simple list
 * 
 * @author Christux
 *
 */
public class TestSimpleList {

	@Test
	public void testCount() {
		SimpleList<Integer> list = new SimpleList<Integer>();
		list.add(new Integer(0));
		list.add(new Integer(2));
		list.add(new Integer(-4));
		list.add(new Integer(7));
		list.add(new Integer(-2));
		
		assertEquals(5, list.count());
	}
	
	@Test
	public void testGet() {
		SimpleList<Integer> list = new SimpleList<Integer>();
		list.add(new Integer(0));
		list.add(new Integer(2));
		list.add(new Integer(-4));
		list.add(new Integer(7));
		list.add(new Integer(-2));
		
		assertEquals(new Integer(-4), list.get(2));
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetOutOfRange() {
		SimpleList<Integer> list = new SimpleList<Integer>();
		list.add(new Integer(0));
		list.get(12);
	}
	
	@Test
	public void testGetLast() {
		SimpleList<Integer> list = new SimpleList<Integer>();
		list.add(new Integer(0));
		list.add(new Integer(2));
		list.add(new Integer(-4));
		list.add(new Integer(7));
		list.add(new Integer(-2));
		
		assertEquals(new Integer(-2), list.getLast());
	}
	
	@Test
	public void testDelete() {
		SimpleList<Integer> list = new SimpleList<Integer>();
		list.add(new Integer(0));
		list.add(new Integer(2));
		list.add(new Integer(-4));
		list.add(new Integer(7));
		list.add(new Integer(-2));
		
		assertEquals(5, list.count());
		
		list.delete(2);
		
		assertEquals(4, list.count());
		assertEquals(new Integer(7), list.get(2));
		
		list.delete(0);
		
		assertEquals(3, list.count());
		assertEquals(new Integer(2), list.get(0));
	}
	
	@Test
	public void testDeleteObject() {
		SimpleList<Integer> list = new SimpleList<Integer>();
		Integer a=new Integer(0);
		Integer b=new Integer(-4);
		list.add(a);
		list.add(new Integer(2));
		list.add(b);
		list.add(new Integer(7));
		list.add(new Integer(-2));
		
		assertEquals(5, list.count());
		
		list.delete(b);
		
		assertEquals(4, list.count());
		assertEquals(new Integer(7), list.get(2));
	}
	
	@Test
	public void testFindObject() {
		SimpleList<Integer> list = new SimpleList<Integer>();
		Integer a=new Integer(0);
		Integer b=new Integer(-4);
		list.add(a);
		list.add(new Integer(2));
		list.add(b);
		list.add(new Integer(7));
		list.add(new Integer(-2));
		
		assertEquals(5, list.count());
		assertEquals(0, list.find(a));
		assertEquals(2, list.find(b));
	}
	
	@Test
	public void testInsert() {
		SimpleList<Integer> list = new SimpleList<Integer>();
		list.add(new Integer(0));
		list.add(new Integer(2));
		list.add(new Integer(-4));
		list.add(new Integer(7));
		list.add(new Integer(-2));
		
		list.insert(2,new Integer(666));
		
		assertEquals(new Integer(666), list.get(2));
		assertEquals(new Integer(-4), list.get(3));
	}

}

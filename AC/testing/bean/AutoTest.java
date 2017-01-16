package bean;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AutoTest extends TestCase {
		Auto a;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		a = new Auto();
	}
	
	public void testAddAccessorio(){
		Accessorio acc = new Accessorio();
		ArrayList<Accessorio> lista = a.getListaAccessorio();
		assertFalse(lista.contains(acc));
		a.addAccessorio(acc);
		assertTrue(lista.contains(acc));
	}
	
	public static Test suite() {
		return new TestSuite(AutoTest.class);
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}

package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	@Test
	public void testPlanetSizeWhen100x100() {
		PlanetExplorer planetExplorer = new PlanetExplorer(100, 100, "");
		
		int planetSize = planetExplorer.getPlanetWidth() * planetExplorer.getPlanetHeight();
		
		assertEquals(10000, planetSize);
	}
	
	@Test
	public void testPlanetSizeWhen10x20(){
		PlanetExplorer planetExplorer = new PlanetExplorer(10, 20, "");
		
		int planetSize = planetExplorer.getPlanetWidth() * planetExplorer.getPlanetHeight();
		
		assertEquals(200, planetSize);
	}
	
	@Test
	public void testExplorerLanding(){
		PlanetExplorer planetExplorer = new PlanetExplorer(100, 100, "");
		
		String landingCommand = planetExplorer.executeCommand(""); 
		
		assertEquals("(0,0,N)", landingCommand);
	}
}

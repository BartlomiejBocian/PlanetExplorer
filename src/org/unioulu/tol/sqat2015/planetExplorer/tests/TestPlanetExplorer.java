package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat2015.planetExplorer.PlanetExplorer;

public class TestPlanetExplorer {

	@Test
	public void testPlanetSizeWhen100() {
		PlanetExplorer planetExplorer = new PlanetExplorer(100, 100, "");
		
		int planetSize = planetExplorer.getPlanetWidth() * planetExplorer.getPlanetHeight();
		
		assertEquals(10000, planetSize);
	}
}

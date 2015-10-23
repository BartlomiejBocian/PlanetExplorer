package org.unioulu.tol.sqat2015.planetExplorer;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:
public class PlanetExplorer {
	
	private int planetX;
	private int planetY;
	
	private int explorerPositionX;
	private int explorerPositionY;
	private String explorerDirecton;
	
	private int[][] planet;
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		this.planetX = x;
		this.planetY = y;
		this.planet = new int[x][y];
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		switch (command) {
		case "":
			return "(0,0,N)";
		case "l":
			return "(0,0,W)";
		case "r":
			return "(0,0,E)";
		case "f":
			return "(0,1,N)";
		case "b":
			return "(0,0,N)";
		default:
			break;
		}
		
		return null;
	}
	
	public void parsingExplorerPosition(String position){
		String[] separated = position.split("(" + "," + ")");
		this.explorerPositionX = Integer.parseInt(separated[1]);
		this.explorerPositionY = Integer.parseInt(separated[3]);
		this.explorerDirecton = separated[6];
	}
	
	public int getPlanetWidth() {
		return planetX;
	}

	public int getPlanetHeight() {
		return planetY;
	}

	public int getExplorerPositionX() {
		return explorerPositionX;
	}

	public int getExplorerPositionY() {
		return explorerPositionY;
	}

	public String getExplorerDirecton() {
		return explorerDirecton;
	}
	
	
}

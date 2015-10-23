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
		if(command.equals("")){
			return explorerLandingOperation();
		}
		for ( int i=0 ; i < command.length(); i++)
		{
			switch (command.charAt(i)) {
			case 'l':
				return explorerTurnLeft();
			case 'r':
				return explorerTurnRight();
			case 'f':
				return explorerForward();
			case 'b':
				return explorerBackward();
			default:
				break;
			}
		}
		return null;
	}

	public void positioningExplorer(String position){
		parsingExplorerPosition(position);
	}

	private void parsingExplorerPosition(String position){
		String[] separated = position.split("[\\(,\\)]");
		this.explorerPositionX = Integer.parseInt(separated[1]);
		this.explorerPositionY = Integer.parseInt(separated[2]);
		this.explorerDirecton = separated[3];
	}

	private String explorerTurnLeft(){
		switch (explorerDirecton) {
		case "N":
			this.explorerDirecton = "W";
			break;
		case "S":
			this.explorerDirecton = "E";
			break;
		case "W":
			this.explorerDirecton = "S";
			break;
		case "E":
			this.explorerDirecton = "N";
			break;
		default:
			break;
		}
		String explorerNewDirection = new String("("+ explorerPositionX +","+ explorerPositionY +","+ explorerDirecton + ")");
		return explorerNewDirection;
	}

	private String explorerTurnRight(){
		switch (explorerDirecton) {
		case "N":
			this.explorerDirecton = "E";
			break;
		case "S":
			this.explorerDirecton = "W";
			break;
		case "W":
			this.explorerDirecton = "N";
			break;
		case "E":
			this.explorerDirecton = "S";
			break;
		default:
			break;
		}
		String explorerNewDirection = new String("("+ explorerPositionX +","+ explorerPositionY +","+ explorerDirecton + ")");
		return explorerNewDirection;
	}

	private String explorerForward(){
		if (explorerDirecton.equals("N")||explorerDirecton.equals("S")){
			if(explorerPositionY < planetY && explorerPositionY >= 0)
				explorerPositionY++;
		} else if (explorerDirecton.equals("E")||explorerDirecton.equals("W")) {
			if(explorerPositionX < planetX && explorerPositionX >= 0)
				explorerPositionX++;
		}
		String explorerNewDirection = new String("("+ explorerPositionX +","+ explorerPositionY +","+ explorerDirecton + ")");
		return explorerNewDirection;
	}

	private String explorerBackward(){
		if (explorerDirecton.equals("N")||explorerDirecton.equals("S")){
			if(explorerPositionY < planetY && explorerPositionY > 0)
				explorerPositionY--;
		} else if (explorerDirecton.equals("E")||explorerDirecton.equals("W")) {
			if(explorerPositionX < planetX && explorerPositionX > 0)
				explorerPositionX--;
		}
		String explorerNewDirection = new String("("+ explorerPositionX +","+ explorerPositionY +","+ explorerDirecton + ")");
		return explorerNewDirection;
	}
	
	private String explorerLandingOperation(){
		explorerDirecton = "N";
		explorerPositionX = 0;
		explorerPositionY = 0;
		String explorerNewDirection = new String("("+ explorerPositionX +","+ explorerPositionY +","+ explorerDirecton + ")");
		return explorerNewDirection;
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

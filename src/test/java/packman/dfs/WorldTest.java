package packman.dfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Point;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import packman.dfs.World.Node;

public class WorldTest {

	private Point packman;
	private Point food;
	private Point maze;
	private char[][] mazeContents;
	
	@Test
	public void findPaths() {
		World world = new World(mazeContents,packman,food);
		assertEquals(this.expectedResult(), world.findPathsAsString());
	}
	@Test 
	public void shouldNotGoParent() {
		assertNull(midleNodeIn3x3World().getLeft().getRight());
		assertNull(midleNodeIn3x3World().getRight().getLeft());
		assertNull(midleNodeIn3x3World().getUp().getDown());
		assertNull(midleNodeIn3x3World().getDown().getUp());
	}
	@Test 
	public void shouldGoLeft() {
		Node left = midleNodeIn3x3World().getLeft();
		assertNotNull(left);
		assertEquals(new Point(0,1), left.point);
		assertNull(left.getLeft());
	}
	@Test 
	public void shouldGoRight() {
		Node right = midleNodeIn3x3World().getRight();
		assertNotNull(right);
		assertEquals(new Point(2,1), right.point);
		assertNull(right.getRight());
	}
	@Test 
	public void shouldGoUp() {
		Node up = midleNodeIn3x3World().getUp();
		assertNotNull(up);
		assertEquals(new Point(1,0), up.point);
		assertNull(up.getUp());
	}
	@Test 
	public void shouldGoDown() {
		Node down = midleNodeIn3x3World().getDown();
		assertNotNull(down);
		assertEquals(new Point(1,2), down.point);
		assertNull(down.getDown());
	}
	@Test 
	public void shouldGetValue() {
		Node node = new World(new char[][]{{'%','-','%'}}).new Node(new Point(1, 0), null);
		assertEquals('-', node.getValue());
	}
	private Node midleNodeIn3x3World() {
		return new World(new char[3][3]).new Node(new Point(1, 1), null);
	}
	@Before
	public void setup() {
		try (Scanner scan = new Scanner(giveMazeData())) {
			int y = scan.nextInt();
			int x = scan.nextInt();
			packman = new Point(x, y);
			y = scan.nextInt();
			x = scan.nextInt();
			food = new Point(x, y); 
			y = scan.nextInt();
			x = scan.nextInt();
			maze = new Point(x, y);
			mazeContents = new char[(int) maze.getX()][];
			x=0;
			scan.nextLine();
			while ( scan.hasNextLine()) {
				mazeContents[x++] =scan.nextLine().toCharArray();
			}
		}
	}
	public String giveMazeData() {
		return
		"3 9\n"+ 
		"5 1\n"+  
		"7 20\n"+  
		"%%%%%%%%%%%%%%%%%%%%\n"+
		"%--------------%---%\n"+  
		"%-%%-%%-%%-%%-%%-%-%\n"+  
		"%--------P-------%-%\n"+  
		"%%%%%%%%%%%%%%%%%%-%\n"+  
		"%.-----------------%\n"+  
		"%%%%%%%%%%%%%%%%%%%%\n";  		
	}
	public String expectedResult() {
		return
				"33\n"+
				"3 9\n"+
				"3 10\n"+
				"3 11\n"+
				"3 12\n"+
				"3 13\n"+
				"3 14\n"+
				"3 15\n"+
				"3 16\n"+
				"2 16\n"+
				"1 16\n"+
				"1 17\n"+
				"1 18\n"+
				"2 18\n"+
				"3 18\n"+
				"4 18\n"+
				"5 18\n"+
				"5 17\n"+
				"5 16\n"+
				"5 15\n"+
				"5 14\n"+
				"5 13\n"+
				"5 12\n"+
				"5 11\n"+
				"5 10\n"+
				"5 9\n" +
				"5 8\n"+
				"5 7\n"+
				"5 6\n"+
				"5 5\n"+
				"5 4\n"+
				"5 3\n"+
				"5 2\n"+
				"5 1\n"+
				"32\n"+
				"3 9\n"+
				"3 10\n"+
				"3 11\n"+
				"3 12\n"+
				"3 13\n"+
				"3 14\n"+
				"3 15\n"+
				"3 16\n"+
				"2 16\n"+
				"1 16\n"+
				"1 17\n"+
				"1 18\n"+
				"2 18\n"+
				"3 18\n"+
				"4 18\n"+
				"5 18\n"+
				"5 17\n"+
				"5 16\n"+
				"5 15\n"+
				"5 14\n"+
				"5 13\n"+
				"5 12\n"+
				"5 11\n"+
				"5 10\n"+
				"5 9\n"+
				"5 8\n"+
				"5 7\n"+
				"5 6\n"+
				"5 5\n"+
				"5 4\n"+
				"5 3\n"+
				"5 2\n"+
				"5 1\n";
	}               
 }
package packman.dfs;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class World {

	final private char[][] mazeContents;
	final private Point packman;
	final private Point food;

	public World(char[][] mazeContents, Point packman, Point food) {
		this.mazeContents = mazeContents;
		this.packman = packman;
		this.food = food;
	}

	public World(char[][] mazeContents) {
		this.mazeContents = mazeContents;
		this.packman = null;
		this.food = null;
	}

	public List<List<Point>> findPaths() {
		final List<List<Point>> paths = new ArrayList<>();
		Node start = new Node(packman, null);
		paths.add(findPath(start, start.getRight()));
		paths.add(findPath(start, start.getLeft()));
		return paths;
	}

	private List<Point> findPath(Node start, Node next) {
		List<Point> path = new ArrayList<Point>() {{add(start.point);}}; 
		if ( visit(next,path) )
			return path;
		else
			return Collections.emptyList();
	}
	
	private boolean visit(Node node, List<Point> path) {
		if ( node==null) return false;
		if ( path.contains(node.point)) return false;
		if ( isWall(node) ) return false;
		path.add(node.point); 
		if ( isFood(node) ) return true;
		if ( visit(node.getDown(),path) ) return true;
		if ( visit(node.getRight(),path) ) return true;
		if ( visit(node.getUp(),path) ) return true;
		if ( visit(node.getLeft(),path) ) return true;
		return false;
	}

	private boolean isWall(Node node) {
		return '%'==node.getValue();
	}

	private boolean isFood(Node node) {
		return '.'==node.getValue();
	}

	public class Node {
		final Point point;
		final Point parent;
		public Node(Point me, Point parent) {
			super();
			this.point = me;
			this.parent = parent;
		}
		public char getValue() {
			return mazeContents[point.y][point.x];
		}
		Node getLeft() {
			return retNodeIfValid(new Point(point.x-1, point.y));
		}
		Node getRight() {
			return retNodeIfValid(new Point(point.x+1, point.y));
		}
		Node getUp() {
			return retNodeIfValid(new Point(point.x, point.y-1));
		};
		Node getDown() {
			return retNodeIfValid(new Point(point.x, point.y+1));
		};
		private Node retNodeIfValid(Point pointAfter) {
			if (!isInside(pointAfter)) return null;
			if ( parent != null ) {
				if ( pointAfter.equals(parent)) return null;
			}
			return new Node(pointAfter, this.point);
		};
		private boolean isInside(Point thePoint) {
			boolean xInside, yInside;
			xInside = thePoint.x >= 0 && thePoint.x < mazeContents[0].length;
			yInside = thePoint.y >= 0 && thePoint.y < mazeContents.length;
			return xInside && yInside;
		};
	}
	
	public String findPathsAsString() {
		StringBuilder s = new StringBuilder();
		for (List<Point> path : findPaths()) {
			s.append(path.size());
			s.append('\n');
			for (Point point : path) {
				s.append(point.y+" "+point.x);
				s.append('\n');
			}
		}
		return s.toString();
	}
}

/**
 * 
 */
package geometry;

/**
 * @author Kosta
 *
 */
import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	
	protected Point startPoint;
	protected Point endPoint;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected= selected;
	}
	
	@Override
	public String toString() {
		return "("+startPoint.getX() + ", " + startPoint.getY()+ ")------>"+
				"("+ endPoint.getX()+ ", " + endPoint.getY()+ ")";
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line temp = (Line)obj;
			if(this.startPoint.equals(temp.getEndPoint())
					&& this.endPoint.equals(temp.getEndPoint())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(),
				endPoint.getX(), endPoint.getY());
		
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			Line temp = (Line)o;
			return ((int)(this.length()-temp.length()));
		}
		return 0;
	}
	
	public void moveOn(int x, int y) {
		int midX = (startPoint.x + endPoint.x)/2;
		int midY = (startPoint.y + endPoint.y)/2;
		int dx = x-midX;
		int dy = y-midY;
		this.startPoint.moveBy(dx, dy);
		this.endPoint.moveBy(dx, dy);
		
	}
	
	public void moveBy (int dx, int dy) {
		this.startPoint.moveOn(this.startPoint.getX() +dx, this.startPoint.getY()+dy);
		this.endPoint.moveOn(this.endPoint.getX() +dx, this.endPoint.getY()+dy);
		
	}
	
	public boolean contains(int x, int y) {
		return (length()- (this.startPoint.distance(x, y)+
				this.endPoint.distance(x, y))) <= 2;
	}
	
	public boolean contains(Point p) {
			return contains(p.getX(),p.getY());
		}
		
	public double length() {
			return startPoint.distance(endPoint.getX(), endPoint.getY());
		}
		
	public Point getStartPoint() {
		return startPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
}

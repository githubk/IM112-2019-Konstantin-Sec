package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	
	private Point center;
	private int radius;
	
	public Circle() {
		
	}
	
	public Circle (Point c, int r) {
		this.center = c;
		this.radius = r;			
	}
	
	public Circle (Point c, int r, boolean selected) {
		this.center = c;
		this.radius = r;
		this.selected = selected;
	}
	
	public double circumference() {
		return 2 * radius * Math.PI;	
	}
	
	public double area() {
		return radius * radius * Math.PI;
	}
	
	public boolean contains(int x, int y) {
		return center.distance(x, y) <= radius;
	}
	
	public void draw(Graphics g) {
		g.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
		if(selected) {
			g.drawRect(center.getX() - radius - 3, center.getY() - 3, 6, 6);
			g.drawRect(center.getX() + radius - 3, center.getY() - 3, 6, 6);
			g.drawRect(center.getX() - 3, center.getY() - radius - 3, 6, 6);
			g.drawRect(center.getX() - 3, center.getY() + radius - 3, 6, 6);
		}
	
	}
	
	@Override
	public String toString() {
		return "Center: " +center +", radius: " +radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle temp = (Circle)obj;
			if(temp.getCenter().equals(center) && temp.getRadius() == radius) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void moveOn(int x, int y) {
		center.moveOn(x, y);
	}

	@Override
	public void moveBy(int dx, int dy) {
		center.moveBy(dx, dy);
	}	
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			Circle temp = (Circle)o;
			return ((int)(this.area() - temp.area()));
		}
		return 0;
	}
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int r){
			this.radius = r;
	}

}

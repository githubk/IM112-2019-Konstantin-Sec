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

public class Rectangle extends Shape {
	
	private Point upperLeft;
	private int width;
	private int height;
	
	public Rectangle () {
		
	}
	
	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft=upperLeft;
		this.width=width;
		this.height=height;
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft,width,height);
		this.selected=selected;
	}
	
	public int area() {
		return width*height;
	}
	
	public int circumference() {
		return 2*width + 2*height;
	}
	
	public boolean contains(int x, int y) {
		boolean containsX = false;
		if(x >= upperLeft.getX() && x <= (upperLeft.getX() + width)) {
			containsX = true;
		}
		
		boolean containsY = false;
		if(y >= upperLeft.getY() && y <= (upperLeft.getY() + height)) {
			containsY = true;
		}
		return containsX && containsY;
	}
	
	@Override
	public String toString() {
		return "Upper left point: " + upperLeft + ", width: " + width + ", height: " + height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle temp = (Rectangle)obj;
			if(this.getUpperLeft().equals(temp.getUpperLeft()) &&
					this.width == temp.getWidth() && 
					this.height == temp.getHeight()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle)o;
			return this.area() - temp.area();
		}
		return 0;
	}
	
	
	
	public void moveOn(int x, int y) {
		upperLeft.moveOn(x, y);
		
	}

	
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
		
	}
	
	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}


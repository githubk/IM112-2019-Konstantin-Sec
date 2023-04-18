package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	
private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int r, int iR) {
		super(center, r);
		this.innerRadius = iR;
	}
	
	public Donut(Point center, int r, int iR, boolean selected) {
		super(center, r);
		this.innerRadius = iR;	
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(super.getCenter().getX() - innerRadius, super.getCenter().getY() - innerRadius, innerRadius*2, innerRadius*2);
		if(selected) {
			g.drawRect(getCenter().getX() - innerRadius - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() + innerRadius - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - innerRadius - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() + innerRadius - 3, 6, 6);
		}
	}
	
	@Override
	public boolean contains(int w, int h) {
		return super.contains(w, h) && super.getCenter().distance(w, h) > innerRadius;
	}
	
	@Override
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;	
	}
	
	@Override
	
	public double circumference() {
		return super.circumference() + (2 * innerRadius * Math.PI);	
	}
	
	@Override
	public String toString() {
		return super.toString() + ", inner radius: " +innerRadius;	
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut temp = (Donut) obj;
			if(super.equals(new Circle(temp.getCenter(), temp.getRadius())) && temp.getInnerRadius() == innerRadius) {
				return true;
			}
		}
		return false;
			
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerR) {
		this.innerRadius = innerR;
	}
	
	
}

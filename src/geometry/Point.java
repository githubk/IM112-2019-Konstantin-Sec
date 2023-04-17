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

public class Point extends Shape {
	
	protected int x;
	protected int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);
		this.selected=selected;
		
	}
	
	@Override
	public String toString() {
		return "( "+ x + "," + y +")";
		
	}
	
	@Override
	public boolean equals (Object obj) {
		if (obj instanceof Point) {
			Point temp = (Point) obj;
			if(this.x==temp.getX()&& this.y==temp.getY()) {
				return true;
			}
		}
		
	
	return false;
	
	}
	
	@Override
	/*Tacka se iscrtava pomocu dve crte koje se seku
	u poziciji x,y*/
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(x + 2, y, x - 2, y);
		g.drawLine(x, y + 2, x, y - 2);
	}
	
	@Override
	/*Racuna udaljenost 2 tacke od koordinantnog pocetka(0,0) 
	i vraca razliku izmedju dve udaljenosti kao ceo broj*/
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point temp = (Point)o;
			return ((int)(this.distance(0, 0) - temp.distance(0, 0))); 
		}
		return 0;
	}
	
	
	public void moveOn(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	
	public void moveBy(int dx, int dy) {
		this.x=this.x+dx;
		this.y=this.y+dy;
	}
	//Proverava da li se tacka nalazi unutar objekta
	public boolean contains(int x, int y) {
		return distance(x, y) <= 2;
	}

	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}

	public double distance(int x, int y) {
		int dX = this.x - x;
		int dY = this.y - y;
		return Math.sqrt(dX * dX + dY * dY);
	}
	

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	
	

}

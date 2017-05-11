package domain;

import java.awt.Graphics;

public abstract class Vorm implements Drawable {
	
	private boolean visible;
	
	public abstract boolean equals(Object object);
	public abstract String toString();
	public abstract Omhullende getOmhullende() throws DomainException;
	public abstract void teken(Graphics graphics);
	
	public Vorm() {
		this.visible = true;
	}
	
	public void setVisible(boolean b){
		this.visible = b;
	}
	public boolean isVisible(){
		return this.visible;
	}
}

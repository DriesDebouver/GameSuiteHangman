package domain;

import java.awt.Graphics;

public class Omhullende extends Vorm {
	private Punt positieLinksBoven;
	private int breedte;
	private int hoogte;
	
	public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) throws DomainException {
		this.setPositieLinksBoven(positieLinksBoven);
		this.setBreedte(breedte);
		this.setHoogte(hoogte);
	}
	
	public void setPositieLinksBoven(Punt positieLinksBoven) throws DomainException {
		if (positieLinksBoven == null) {
			throw new DomainException("linkerBovenhoek mag niet null zijn.");
		}
		this.positieLinksBoven = positieLinksBoven;
	}
	
	public void setBreedte(int breedte) throws DomainException {
		if (breedte < 0) {
			throw new DomainException("Breedte moet groter dan 0 zijn!");
		}
		this.breedte = breedte;
	}
	
	public void setHoogte(int hoogte) throws DomainException {
		if (hoogte < 0) {
			throw new DomainException("Hoogte moet groter dan 0 zijn!");
		}
		this.hoogte = hoogte;
	}
	
	public Punt getPositieLinksBoven() {
		return positieLinksBoven;
	}
	
	public int getBreedte() {
		return breedte;
	}
	
	public int getHoogte() {
		return hoogte;
	}
	
	public int getMinX() {
		return this.getPositieLinksBoven().getX();
	}
	
	public int getMinY() {
		return this.getPositieLinksBoven().getY();
	}
	
	public int getMaxX() {
		return this.getPositieLinksBoven().getX() + this.getBreedte();
	}
	
	public int getMaxY() {
		return this.getPositieLinksBoven().getY() + this.getHoogte();
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Omhullende) {
			Omhullende omhullende = (Omhullende) object;
			if ((omhullende.getPositieLinksBoven().equals(this.getPositieLinksBoven())) &&
					(omhullende.getBreedte() == this.getBreedte()) &&
					(omhullende.getHoogte() == this.getHoogte()) ) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String omhullendeString = "Omhullende: " + this.getPositieLinksBoven() + " - " + this.getBreedte() + " - " + this.getHoogte();
		return omhullendeString;
	}
	
	@Override
	public Omhullende getOmhullende() throws DomainException {
		return new Omhullende(this.getPositieLinksBoven(), this.getBreedte(), this.getHoogte());
	}
	
	@Override
	public void teken(Graphics graphics) {
		try {
			Rechthoek omhullendeRechthoek = new Rechthoek(this.getPositieLinksBoven(), this.getBreedte(), this.getHoogte());
			if (this.isVisible()) {
				omhullendeRechthoek.teken(graphics);
			}
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

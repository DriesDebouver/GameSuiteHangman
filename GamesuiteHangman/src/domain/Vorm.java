package domain;
public abstract class Vorm implements Drawable {
	
	public abstract boolean equals(Object object);
	public abstract String toString();
	public abstract Omhullende getOmhullende() throws DomainException;
}

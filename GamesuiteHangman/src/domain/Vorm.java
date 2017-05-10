package domain;
public abstract class Vorm {
	
	public abstract boolean equals(Object object);
	public abstract String toString();
	public abstract Omhullende getOmhullende() throws DomainException;
}

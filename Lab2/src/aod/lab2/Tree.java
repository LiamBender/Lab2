package aod.lab2;

/**
 * Trädet
 * 
 * Själva interfacet för trädet
 *
 * @author Liam Bendiksen
 * @version 2026-04-20
 */

public interface Tree<T> {
	
	public void add(T item); // Lägger till specifikt värde
	
	public boolean searchFor(T itemToSearchFor); // True eller false för sökning av item
	
	public int size(); // Storlek
	
	public void clear(); // Nollställning
	
	public boolean remove(T itemToRemove); // Tar bort specifikt värde
}

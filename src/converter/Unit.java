package converter;
/**
 * 
 * @author 5810545416-Thanut
 *
 */
public interface Unit {
	/**
	 * 
	 * @return return the value of a standard unit
	 */
	public double getValue();
	
	/**
	 * 
	 * @return return a printable name of the unit
	 */
	public String toString();
}

package converter;
/**
 * 
 * @author 5810545416-Thanut
 *
 */
public class UnitConverter {
	/**
	 * 
	 * @param amount is the user's input value that they want to convert to other unit
	 * @param fromUnit is the unit of the value that user type in
	 * @param toUnit is the unit that user want to convert to
	 * @return Value that calculated to the unit that user want to know
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit){
		return (amount*fromUnit.getValue())/toUnit.getValue(); 
	}
	 /**
	  * 
	  * @return array of all unit that Length have
	  */
	public Unit[] getUnits(){
		return Length.values();
	}
}

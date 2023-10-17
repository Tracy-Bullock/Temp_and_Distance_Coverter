package conversionProgram;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.JOptionPane;

///////////////////////////////////
//class to covert celsius to fahr
/////////////////////////////////
public class CelsiusToFahr {
	
	private double celsius, fahr;
	private String initValue, newValue;
	
	//////////////////////////////////////////
	// set location and format for decimals
	////////////////////////////////////////
	DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
	DecimalFormat temp = new DecimalFormat("#0.0", symbols);
	
	////////////////////////////////////////////////////
	// method to set the conversion value and convert
	//////////////////////////////////////////////////
	public void setConversion(String usrInput) {
		
		try {
			celsius = Double.parseDouble(usrInput);
			fahr = (celsius * 9/5) + 32;
			initValue = temp.format(celsius) + "°C";
			newValue = temp.format(fahr) + "°F";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "\n     Invalid Temperature", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	///////////////////////////////////////////////////////
	// method to get the conversion value and return it
	/////////////////////////////////////////////////////
	public String getConversion() {
		
		if (initValue == null) {
			return null;
		} else {
			return initValue + " = " + newValue;
		}
	}

}

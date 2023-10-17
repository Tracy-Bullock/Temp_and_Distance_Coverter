package conversionProgram;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.JOptionPane;

/////////////////////////////////
// class to covert km to miles
///////////////////////////////
public class KmToMiles {
	
	private double miles, km;
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
			km = Double.parseDouble(usrInput);
			if (km <= 0) {
				initValue = null;
				throw new Exception();
			} else {
				miles = km / 1.609344;
				initValue = temp.format(km) + " km";
				newValue = temp.format(miles) + " mi";
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "\nYou must enter a numeric distance greater than 0!    ", "Error", JOptionPane.ERROR_MESSAGE);
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

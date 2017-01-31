package romannumber;

import java.util.*;

public class FromRomanToArabic {

	Map<String, Integer> romanValues;
	
	public FromRomanToArabic() {
		romanValues = new HashMap<>();
		romanValues.put("I", 1);
		romanValues.put("V", 5);
		romanValues.put("X", 10);
		romanValues.put("C", 100);
	}
	
	public Integer calculate(String romanNumber) {
		Integer res = 0;
		String nextChar;
		Integer actual, previous = -1;
		for (int i = romanNumber.length() -1; i >=0 ; i--) {
			nextChar = String.valueOf(romanNumber.charAt(i));
			actual = getValor(nextChar);
			verificaOrdenCorrecto(actual, previous);
			res = assignaSigno(actual, previous);
			previous = actual;
		}
		return res;
		
	}

	private void verificaOrdenCorrecto(Integer actual, Integer previous) {
		if (previous == -1) {
			return;
		}
		if (previous == actual) {
			return;
		}
		if ( (actual == 1) &&  (previous != 10) && (previous != 5) ) {
			throw new WrongOrderInRomanNumberException();
		}
		
	}

	private Integer getValor(String nextChar) {
		Integer val = this.romanValues.get(nextChar);
		if (val == null) {
			return 0;
		}
		return val;
	}

	private Integer assignaSigno(Integer actual, Integer previous) {
		if (actual >= previous) {
			return actual;
		} else {
			return (-1)*actual;
		}
	}


}

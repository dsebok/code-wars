package com.codewars.depiphron.roman_numerals;

public class Conversion {

	public static final String MAXIMUM_VALUE_EXCEEDED = "That's too much for the romans!";
	private final NumeralDescriptor singleDescriptor = new NumeralDescriptor("I", "V", "X");
	private final NumeralDescriptor decimalDescriptor = new NumeralDescriptor("X", "L", "C");
	private final NumeralDescriptor hundredDescriptor = new NumeralDescriptor("C", "D", "M");
	private final NumeralDescriptor thousandDescriptor = new NumeralDescriptor("M", "?", "?");

	public String solution(int n) {
		if (n >= 4000) {
			throw new TransformationException(MAXIMUM_VALUE_EXCEEDED);
		}
		int singleDigit = n % 10;
		int decimalDigit = n / 10 % 10;
		int hundredDigit = n / 100 % 10;
		int thousandDigit = n / 1000 % 10;

		String singleRoman = singleDescriptor.transform(singleDigit);
		String decimalRoman = decimalDescriptor.transform(decimalDigit);
		String hundredRoman = hundredDescriptor.transform(hundredDigit);
		String thousandRoman = thousandDescriptor.transform(thousandDigit);

		return thousandRoman + hundredRoman + decimalRoman + singleRoman;
	}

	private class NumeralDescriptor {
		private final String single;
		private final String fivefold;
		private final String tenfold;

		private NumeralDescriptor(String single, String fivefold, String tenfold) {
			this.single = single;
			this.fivefold = fivefold;
			this.tenfold = tenfold;
		}

		private String transform(int digit) {
			String result = "";  
			if (digit < 1) {
				return result;
			}
			if (digit < 4) {
				while (digit-- > 0) {
					result += single;
				}
			} else if (digit == 4) {
				result = single + fivefold;
			} else if (digit < 9) {
				result = fivefold;
				while (digit-- > 5) {
					result += single;
				}
			} else if (digit == 9) {
				result = single + tenfold;
			}
			return result;
		}
	}
}

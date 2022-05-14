package com.codewars.depiphron.roman_numerals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConversionTest {

	private Conversion conversion;
	
	@BeforeEach
	public void setup() {
		conversion = new Conversion();
	}
	
	@Test
	public void solution_shouldWork_whenInputIsZero() {
		// GIVEN
		int i = 0;
		// WHEN
		String actual = conversion.solution(i);
		// THEN
		assertEquals("", actual);
	}
	
	@Test
	public void solution_shouldWork_whenInputIsSingleDigit() {
		// GIVEN
		int i = 7;
		// WHEN
		String actual = conversion.solution(i);
		// THEN
		assertEquals("VII", actual);
	}
	
	@Test
	public void solution_shouldWork_whenInputHasTwoDigits() {
		// GIVEN
		int i = 13;
		// WHEN
		String actual = conversion.solution(i);
		// THEN
		assertEquals("XIII", actual);
	}
	
	@Test
	public void solution_shouldWork_whenInputHasThreeDigits() {
		// GIVEN
		int i = 844;
		// WHEN
		String actual = conversion.solution(i);
		// THEN
		assertEquals("DCCCXLIV", actual);
	}
	
	@Test
	public void solution_shouldWork_whenInputHasFourDigits() {
		// GIVEN
		int i = 2962;
		// WHEN
		String actual = conversion.solution(i);
		// THEN
		assertEquals("MMCMLXII", actual);
	}
	
	@Test
	public void solution_shouldWork_whenInputIsMaximum() {
		// GIVEN
		int i = 3999;
		// WHEN
		String actual = conversion.solution(i);
		// THEN
		assertEquals("MMMCMXCIX", actual);
	}
	
	@Test
	public void solution_shouldThrowException_whenInputIsBeyondMaximum() {
		// GIVEN
		int i = 4000;
		// WHEN
		TransformationException e = assertThrows(TransformationException.class, () -> {
			conversion.solution(i);
		});
		// THEN
		assertEquals(Conversion.MAXIMUM_VALUE_EXCEEDED, e.getMessage());
	}
	
}

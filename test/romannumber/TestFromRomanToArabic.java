package romannumber;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFromRomanToArabic {
	
	private FromRomanToArabic trans;

	@Before
	public void setUp() throws Exception {
		trans = new FromRomanToArabic();

	}

	@Test
	public void when_I_returns_1() {
		int res = trans.calculate("I");	
		assertEquals(1, res);
	}

	
	@Test
	public void when_V_returns_5() {
		assertEquals(new Integer(5), trans.calculate("V"));
	}


	@Test
	public void when_VI_returns_6() {
		assertEquals(new Integer(6), trans.calculate("VI"));
	}
	
	@Test
	public void when_IV_returns_4() {
		assertEquals(new Integer(4), trans.calculate("IV"));
	}

	
	@Test
	public void when_XCIV_returns_94() {
		assertEquals(new Integer(94), trans.calculate("XCIV"));
	}

	
	@Test(expected=WrongRomanNumberException.class)
	public void when_H_found_throws_exception() {
		trans.calculate("XCHIV");
	}
	
	@Test(expected=WrongOrderInRomanNumberException.class)
	public void when_I_out_of_order_throws_exception() {
		trans.calculate("IC");
	}

}

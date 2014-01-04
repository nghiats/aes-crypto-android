package com.evgenii.aescrypto.test;

import java.util.ArrayList;

import android.test.AndroidTestCase;

import com.evgenii.aescrypto.JsFunctionCall;

public class JsFunctionCallTest extends AndroidTestCase {

	public void testInit_shouldSetNameAndParams() {
		final ArrayList<Object> params = new ArrayList<Object>();
		params.add("milk");
		params.add(2);

		final JsFunctionCall jsFunctionCall = new JsFunctionCall("drink",
				params);

		assertEquals("drink", jsFunctionCall.getName());

		final ArrayList<Object> jsParams = jsFunctionCall.getParams();
		assertEquals(2, jsParams.size());
		assertEquals("milk", jsParams.get(0));
		assertEquals(2, jsParams.get(1));
	}

	public void testToString() {
		final ArrayList<Object> params = new ArrayList<Object>();
		params.add("Milk");
		params.add(2);

		final JsFunctionCall jsFunctionCall = new JsFunctionCall("drink",
				params);

		assertEquals("drink('Milk', 2);", jsFunctionCall.toString());

	}

	public void testParamToString_string() {
		assertEquals("'Boy\'s bike'",
				JsFunctionCall.paramToString("Boy's bike"));
	}

	public void testParamToString_integer() {
		assertEquals("123", JsFunctionCall.paramToString(123));
	}

	public void testParamToString_float() {
		assertEquals("123.22", JsFunctionCall.paramToString(123.22));
	}
}
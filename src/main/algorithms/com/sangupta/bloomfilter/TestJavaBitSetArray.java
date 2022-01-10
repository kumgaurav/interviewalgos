package com.sangupta.bloomfilter;

import java.io.IOException;

import org.junit.Test;

import com.sangupta.bloomfilter.core.JavaBitSetArray;

import junit.framework.Assert;

/**
 * 
 * @author sangupta
 *
 */
public class TestJavaBitSetArray {
	
	private static final int MILLION = 1000 * 1000;
	
	@Test
	public void testJavaBitSetArray() {
		JavaBitSetArray bits = null;
		
		try {
			bits = new JavaBitSetArray(MILLION);
			for(int i = 0; i < MILLION; i++) {
				Assert.assertFalse(bits.getBit(i));
				bits.setBit(i);
				Assert.assertTrue(bits.getBit(i));
				bits.clearBit(i);
				Assert.assertFalse(bits.getBit(i));
			}
		} finally {
			if(bits != null) {
				try {
					bits.close();
				} catch(IOException e) {
					// eat up
				}
			}
		}
	}

}
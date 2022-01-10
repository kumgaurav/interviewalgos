package com.sangupta.bloomfilter;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import com.sangupta.bloomfilter.core.BitArray;
import com.sangupta.bloomfilter.core.FastBitArray;
import com.sangupta.bloomfilter.core.FileBackedBitArray;
import com.sangupta.bloomfilter.core.JavaBitSetArray;
import com.sangupta.bloomfilter.core.MMapFileBackedBitArray;

/**
 * JUnit tests for various implementations of {@link BitArray}s like 
 * {@link FileBackedBitArray}, {@link JavaBitSetArray} and {@link FastBitArray}
 * 
 * @author sangupta
 * @since 1.0
 */
public class TestBitArrays {
	
	private static final int MILLION_ELEMENTS = 1 * 1000 * 1000;
	
	@Test
	public void testJavaBitArray() {
		BitArray bitArray = new JavaBitSetArray(MILLION_ELEMENTS);
		testArray(bitArray, MILLION_ELEMENTS);
	}
	
	@Test
	public void testFileBackedBitArray() {
		FileBackedBitArray bitArray = null;
		try {
			File file = File.createTempFile("bitarray", ".bits");
			file.deleteOnExit();
			
			bitArray = new FileBackedBitArray(file, MILLION_ELEMENTS);
			
			testArray(bitArray, MILLION_ELEMENTS / 1000);
		} catch(Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		} finally {
			if(bitArray != null) {
				try {
					bitArray.close();
				} catch (IOException e) {
					// eat up
				}
			}
		}
	}
	
	@Test
	public void testMMapFileBackedBitArray() {
		MMapFileBackedBitArray bitArray = null;
		try {
			File file = File.createTempFile("bitarray", ".bits");
			file.deleteOnExit();
			
			bitArray = new MMapFileBackedBitArray(file, MILLION_ELEMENTS);
			
			testArray(bitArray, MILLION_ELEMENTS);
		} catch(Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		} finally {
			if(bitArray != null) {
				try {
					bitArray.close();
				} catch (IOException e) {
					// eat up
				}
			}
		}
	}
	
	private void testArray(BitArray bitArray, int maxElements) {
		// start iterating
		for(int index = 0; index < maxElements; index++) {
			Assert.assertFalse(bitArray.getBit(index));
			bitArray.setBit(index);
			Assert.assertTrue(bitArray.getBit(index));
			bitArray.clearBit(index);
			Assert.assertFalse(bitArray.getBit(index));
		}
	}

}
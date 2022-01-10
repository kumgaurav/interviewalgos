/**
 * 
 */
package com.sangupta.bloomfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Test;

import com.sangupta.bloomfilter.impl.InMemoryBloomFilter;

/**
 * JUnit tests for {@link InMemoryBloomFilter}
 * 
 * @author sangupta
 *
 */
public class TestBloomFilter {
	
	private static final int MAX = 1000 * 1000;
	
	private static final double FPP = 0.01;
	
	@Test
	public void testDefaultFilter() {
		BloomFilter<String> filter = new InMemoryBloomFilter<String>(10 * MAX, FPP);
		
		// generate two one-million uuid arrays
		List<String> contained = new ArrayList<String>();
		List<String> unused = new ArrayList<String>();
		for(int index = 0; index < MAX; index++) {
			contained.add(UUID.randomUUID().toString());
			unused.add(UUID.randomUUID().toString());
		}
		
		// now add to filter
		for(String uuid : contained) {
			filter.add(uuid);
		}
		
		// now start checking
		for(String uuid : contained) {
			Assert.assertTrue(filter.contains(uuid));
		}
		int fpp = 0;
		for(String uuid : unused) {
			boolean present = filter.contains(uuid);
			if(present) {
				// false positive
				Assert.assertEquals(false, contained.contains(uuid));
				fpp++;
			}
		}
		
		// add another one million more uuids
		List<String> more = new ArrayList<String>();
		for(int index = 0; index < MAX; index++) {
			more.add(UUID.randomUUID().toString());
		}
		for(String uuid : more) {
			filter.add(uuid);
		}
		
		// check again
		for(String uuid : more) {
			Assert.assertTrue(filter.contains(uuid));
		}
		for(int index = 0; index < MAX; index++) {
			String uuid = UUID.randomUUID().toString();
			boolean present = filter.contains(uuid);
			if(present) {
				// false positive
				Assert.assertEquals(false, contained.contains(uuid));
				fpp++;
			}
		}
		System.out.println("False positives found in two millions: " + fpp);
	}

}
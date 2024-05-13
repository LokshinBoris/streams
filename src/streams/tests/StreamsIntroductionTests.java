package streams.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static streams.StreamIntroductionMethods.*;

import java.util.Arrays;
import java.util.NoSuchElementException;
class StreamsIntroductionTests {

	@Test
	void sumIfTest() {
		int[] ar = {1,2,3,4,5,6};
		assertEquals(12, sumIf(ar, n -> n % 2 == 0));
		
	}
	@Test
	void sumDistinctTest() {
		int [] ar= {1, 2, 10, 1, 1};
		assertEquals(13, sumDistinct(ar));
	}
	@Test
	void maxIfTest() {
		int [] ar = {1, 7,-3, 23, 13, 101};
		assertEquals(101, maxIf(ar, n -> n % 2 != 0));
		assertThrowsExactly(NoSuchElementException.class,
				() -> maxIf(ar, n -> n % 2 == 0));
	}
	@Test
	void sortDistinctTest() {
		int [] ar= {1, 10, 1, 1, 2};
		int [] expected = {1, 2, 10};
		assertArrayEquals(expected, sortDistinct(ar));
	}
	@Test
	void forEachIfTest() {
		int [] ar= {1, 10, 1, 1, 2};
		forEachIf(ar, n -> n % 2 != 0, n -> System.out.print(n + " "));
	}
	@Test
	void  getRandomArrayTest() {
		int ar[] = getRandomArray(10, 12, 1000);
		assertEquals(1000, ar.length);
		assertTrue(Arrays.stream(ar).allMatch(n -> n >= 10 && n < 12));
		assertEquals(21, sumDistinct(ar));
	}
	
	@Test
	void displayShuffleTest()
	{
		int [] ar= {10,20,30,40,50};
		for(int i=0;i<10;i++) 
			{
				displayShuffle(ar);
				System.out.println();
			}
	}
	
	@Test
	void  getMinMaxAvgTest() throws Exception 
	{
		int [] ar= {10,20,30,40,50};
		MinMaxAvg minMaxAvgExp = new MinMaxAvg (10 , 50 ,30.0 );
		assertEquals(minMaxAvgExp,getMinMaxAvg(ar));
		int [] ar1= {15};
		MinMaxAvg minMaxAvgExp1 = new MinMaxAvg (15 , 15 ,15.0 );
		assertEquals(minMaxAvgExp1,getMinMaxAvg(ar1));
		assertThrowsExactly(NoSuchElementException.class,() -> getMinMaxAvg(null));
	}

}

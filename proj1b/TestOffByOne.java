import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
	@Test
	public void testEqualChars() {
		assertTrue(offByOne.equalChars('a', 'b'));
		assertTrue(offByOne.equalChars('x', 'y'));
		assertTrue(offByOne.equalChars('d', 'c'));
		assertFalse(offByOne.equalChars('m', 'b'));
		assertFalse(offByOne.equalChars('a', 'B'));
		assertTrue(offByOne.equalChars('&', '%'));
	}   
}

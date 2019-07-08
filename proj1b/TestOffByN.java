import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static OffByN obn = new OffByN(3);
    
    // Your tests go here.
	@Test
	public void testEqualChars() {
		assertTrue(obn.equalChars('a', 'd'));
		assertTrue(obn.equalChars('u', 'x'));
		assertTrue(obn.equalChars('A', 'D'));
		assertFalse(obn.equalChars('a', 'c'));
		assertFalse(obn.equalChars('a', 'B'));
		assertFalse(obn.equalChars('&', '%'));
	}   
}
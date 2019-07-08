import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne obo = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } 

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cadfascaact"));
        assertTrue(palindrome.isPalindrome("manonam"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("dog"));
    }

    @Test
    public void testIsPalindrome1() {
    assertFalse(palindrome.isPalindrome("cadfascaact", obo));
    assertTrue(palindrome.isPalindrome("flake", obo));
    assertTrue(palindrome.isPalindrome("astb", obo));
    assertFalse(palindrome.isPalindrome("dog", obo));
    assertTrue(palindrome.isPalindrome("B", obo));
    }
}

public class Palindrome {

	public Deque<Character> wordToDeque(String word) {
		Deque<Character> charlist = new LinkedListDeque<Character>();
		for (int i = 0; i <= word.length() - 1; i++) {
			charlist.addLast(word.charAt(i));
		}
		return charlist;
	} 

	public boolean isPalindrome(String word) {
		Deque<Character> wordchar = wordToDeque(word);
		String actual = "";
		for (int i = 0; i <= word.length() - 1; i++) {
			actual += wordchar.removeLast();
		}
		if (actual.equals(word)) { //cannot use "=="
			return true;
		}
		return false;
	}

	//overload isPalindrome
	public boolean isPalindrome(String word, CharacterComparator cc) {
		Deque<Character> wordchar = wordToDeque(word);
		if (word.length() == 1) {
			return true;
		}
		/*
		0, length-1
		1,length-2
		2,length-3
		*/
		for (int i = 0; i <= Math.floor(word.length() / 2) - 1; i++) {
			if (cc.equalChars(wordchar.get(i), wordchar.get(word.length() - i - 1))) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}

}
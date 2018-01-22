package ua.tarset.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
	private static final String STR = "There is a string of characters. It is necessary to calculate the frequency of occurrence of each character of English alphabet in this string (large and small characters count as the same).";
	private static int numberOfLetters = 0;
	private static Map<String, Letter> letters = new HashMap<>();
	private static SortedSet<String> keyToHashLetters = new TreeSet<>();
	
	public static void main(String args[]) {
		calcFrequencyOfOccurrenceOfEachChar();
		outputResult();
	}
	
	public static void calcFrequencyOfOccurrenceOfEachChar() {
		for (char symbol: STR.toCharArray())
			if (symbol >= 'A' && symbol <= 'Z' || symbol >= 'a' && symbol <= 'z') { //select only Latin letters
				numberOfLetters++;
				//if need - remodel characters in small
				String letter = symbol < 'a' ? String.valueOf((char) (symbol + 32)) : String.valueOf(symbol); 
				//if such a letter is already included in the collection, then we increase its counter
				//otherwise creating model a letter and put it into a collection
				if (letters.get(letter) != null) 
					letters.get(letter).numberOfRepetitions++;
				else 
					addToColectionLetter(letter);
			}
	}
	
	public static void addToColectionLetter(String letter) {
		keyToHashLetters.add(letter);
		Letter clsLetter = new Letter();
		clsLetter.letter = letter;
		clsLetter.numberOfRepetitions++;
		letters.put(letter, clsLetter);
	}
	
	public static void outputResult() {
		for (String key: keyToHashLetters) {
			Letter letter = letters.get(key);
			System.out.println(letter.letter + ": " + ((float) letter.numberOfRepetitions * 100 / numberOfLetters) + "%");
		}
	}
	
}

class Letter {
	String letter;
	int numberOfRepetitions = 0;
}
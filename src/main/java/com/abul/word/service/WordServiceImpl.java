package com.abul.word.service;

import com.abul.word.model.WordStructure;
import org.apache.commons.lang3.Validate;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class WordServiceImpl implements WordService {

    @Override
    public WordStructure getWordStructure(final String word) {
        Validate.notNull(word, "word must not be null");

        final boolean palindrome = isPalindrome(word.toLowerCase());
        final boolean anagramOfPalindrome;
        if (palindrome) {
            anagramOfPalindrome = true;
        } else {
            anagramOfPalindrome = isAnagramOfPalindrome(word.toLowerCase());

        }

        return WordStructure.builder().palindrome(palindrome).anagramOfPalindrome(anagramOfPalindrome).build();
    }

    private boolean isPalindrome(final String word) {
        if (word.length() == 0 || word.length() == 1 || (word.length() == 2 && word.charAt(0) == word.charAt(1))) {
            return true;
        }

        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }

        return isPalindrome(word.substring(1, word.length() - 1));
    }

    /**
     * Returns if a word is an anagram of palindrome. A word is an anagram of palindrome if the number of odd
     * character frequency count is less than 2.
     *
     * @param word the word to check
     * @return true if word is an anagram of palindrome otherwise false;
     */
    private boolean isAnagramOfPalindrome(final String word) {
        final Map<Integer, Integer> characterFrequencies = word.chars().boxed().sorted().collect(groupingBy(Function.identity(), summingInt(e -> 1)));
        final Integer oddFrequenciesCount = characterFrequencies.values().stream().reduce(0, (count, frequency) -> frequency % 2 != 0 ? count + 1 : count);
        return oddFrequenciesCount < 2;
    }
}

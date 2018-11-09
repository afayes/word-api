package com.abul.word.service;

import com.abul.word.model.WordStructure;
import org.apache.commons.lang3.Validate;

public class WordServiceImpl implements WordService {
    @Override
    public WordStructure getWordStructure(final String word) {
        Validate.notNull(word, "word must not be null");

        final boolean palindrome = isPalindrome(word.toLowerCase());

        return WordStructure.builder().palindrome(palindrome).build();
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
}

package com.abul.word.service;

import com.abul.word.model.WordStructure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordServiceTest {

    private WordService wordService;

    @BeforeEach
    void setUp() {
        wordService = new WordServiceImpl();
    }

    @DisplayName("Get word structure when word is null should throw NullPointerException")
    void getWordStructureWhenWordIsNullShouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> wordService.getWordStructure(null));
    }

    @ParameterizedTest()
    @DisplayName("Get word structure when word is palindrome should return palindrome is true")
    @ValueSource(strings = {"", "a", "aa", "aA", "Aa", "eve", "anna", "kayak", "sagas", "solos"})
    void getWordStructureWhenWordIsPalindromeShouldReturnPalindromeIsTrue(final String word) {
        final WordStructure wordStructure = wordService.getWordStructure(word);

        assertTrue(wordStructure.isPalindrome(), "Word should be palindrome");
    }

    @ParameterizedTest()
    @DisplayName("Get word structure when word is not palindrome should return palindrome is false")
    @ValueSource(strings = {"ab", "foo", "bar", "buzz", "fizz", "cloud"})
    void getWordStructureWhenWordIsNotPalindromeShouldReturnPalindromeIsFalse(final String word) {
        final WordStructure wordStructure = wordService.getWordStructure(word);

        assertFalse(wordStructure.isPalindrome(), "Word should not be palindrome");
    }

    @ParameterizedTest()
    @DisplayName("Get word structure when word is an anagram of palindrome should return anagram of palindrome is true")
    @ValueSource(strings = {"", "a", "aA", "Aa", "foo", "kkppd", "buzzbu", "pizizp", "gggoo"})
    void getWordStructureWhenWordIsAnAnagramOfPalindromeShouldReturnAnagramOfPalindromeIsTrue(final String word) {
        final WordStructure wordStructure = wordService.getWordStructure(word);

        assertTrue(wordStructure.isAnagramOfPalindrome(), "Word should be an anagram of palindrome");
    }

    @ParameterizedTest()
    @DisplayName("Get word structure when word is not an anagram of palindrome should return anagram of palindrome is false")
    @ValueSource(strings = {"ab", "abc", "abcd", "eved", "five", "pizza", "eleven",})
    void getWordStructureWhenWordIsNotAnAnagramOfPalindromeShouldReturnAnagramOfPalindromeIsFalse(final String word) {
        final WordStructure wordStructure = wordService.getWordStructure(word);

        assertFalse(wordStructure.isAnagramOfPalindrome(), "Word should not be an anagram of palindrome");
    }
}

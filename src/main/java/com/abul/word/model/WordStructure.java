package com.abul.word.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the structure of a word. Specifies if a word is either a palindrome or an anagram of a palindrome.
 * <p>
 * A word is defined to be a palindrome if it is spelt the same backwards as it is forwards, for example, 'kayak'.
 * <p>
 * A word is defined to be an anagram of a palindrome if its letters can be rearranged to form a palindrome
 * (a sequence of characters that is the same backwards as it is forwards), for example, 'bzzubu' can be
 * arranged to spell 'buzzub', which is a palindrome.
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class WordStructure {

    private String word;

    private boolean palindrome;

    private boolean anagramOfPalindrome;
}

package com.abul.word.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WordStructure {

    private String word;

    private boolean palindrome;

    private boolean anagramOfPalindrome;
}

package com.abul.word.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class WordStructure {

    private String word;

    private boolean palindrome;

    private boolean anagramOfPalindrome;
}

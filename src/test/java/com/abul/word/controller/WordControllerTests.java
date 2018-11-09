/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.abul.word.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.abul.word.controller.WordController.URL;
import static com.abul.word.controller.WordController.URL_GET_WORD_STRUCTURE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WordControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest()
    @DisplayName("Get word structure when word is palindrome should return palindrome is true")
    @ValueSource(strings = {"a", "aa", "aA", "Aa", "eve", "anna", "kayak", "sagas", "solos"})
    public void getWordStructureWhenWordIsPalindromeShouldReturnPalindromeIsTrue(final String word) throws Exception {

        mockMvc.perform(get(URL + URL_GET_WORD_STRUCTURE, word)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.palindrome").value(true));

    }

    @ParameterizedTest()
    @DisplayName("Get word structure when word is not palindrome should return palindrome is false")
    @ValueSource(strings = {"ab", "foo", "bar", "buzz", "fizz", "cloud"})
    public void getWordStructureWhenWordIsNotPalindromeShouldReturnPalindromeIsFalse(final String word) throws Exception {

        mockMvc.perform(get(URL + URL_GET_WORD_STRUCTURE, word)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.palindrome").value(false));
    }

    @ParameterizedTest()
    @DisplayName("Get word structure when word is an anagram of palindrome should return anagram of palindrome is true")
    @ValueSource(strings = {"a", "aA", "Aa", "foo", "kkppd", "buzzbu", "pizizp", "gggoo"})
    public void getWordStructureWhenWordIsAnAnagramOfPalindromeShouldReturnAnagramOfPalindromeIsTrue(final String word) throws Exception {

        mockMvc.perform(get(URL + URL_GET_WORD_STRUCTURE, word)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.anagramOfPalindrome").value(true));
    }

    @ParameterizedTest()
    @DisplayName("Get word structure when word is not an anagram of palindrome should return anagram of palindrome is false")
    @ValueSource(strings = {"ab", "abc", "abcd", "eved", "five", "pizza", "eleven",})
    public void getWordStructureWhenWordIsNotAnAnagramOfPalindromeShouldReturnAnagramOfPalindromeIsFalse(final String word) throws Exception {

        mockMvc.perform(get(URL + URL_GET_WORD_STRUCTURE, word)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.anagramOfPalindrome").value(false));
    }
}


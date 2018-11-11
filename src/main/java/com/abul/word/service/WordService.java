package com.abul.word.service;

import com.abul.word.model.WordStructure;

/**
 * Describes a service for managing words.
 */
public interface WordService {

    /**
     * Gets the {@link WordStructure} for a word.
     *
     * @param word the word to get {@link WordStructure} for
     * @return the {@link WordStructure}
     */
    WordStructure getWordStructure(String word);
}

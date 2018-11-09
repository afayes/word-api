package com.abul.word.controller;

import com.abul.word.model.WordStructure;
import com.abul.word.service.WordService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = WordController.URL)
public class WordController {

    static final String URL = "/words";

    static final String URL_GET_WORD_STRUCTURE = "/{word}";

    private final WordService wordService;

    public WordController(final WordService wordService) {
        this.wordService = wordService;
    }

    @RequestMapping(path = URL_GET_WORD_STRUCTURE, method = RequestMethod.GET)
    public WordStructure getWordStructure(@PathVariable final String word) {
        return wordService.getWordStructure(word);
    }
}

package org.enigma.controller;

import org.enigma.htmlpageparser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.MalformedURLException;

@Controller
public class MainController {

    private final Parser parser;

    @Autowired
    public MainController(Parser parser) {
        this.parser = parser;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String rootGet() {
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String rootPost(ModelMap modelMap,
                           @RequestParam String url) {

        String errorMessage = null;

        try {
            parser.setUrl(url);
            parser.parse();
        } catch(MalformedURLException e) {
            errorMessage = e.getMessage();
        } catch(IOException e) {
            errorMessage = "Error occurred during parsing the page.";
        }

        modelMap.addAttribute("url", url);

        if (errorMessage == null) {
            modelMap.addAttribute("wordsTotal", parser.getWordsTotal());
            modelMap.addAttribute("wordOccurrence", parser.getWordOccurrence());
            return "result";
        } else {
            modelMap.addAttribute("errorMessage", errorMessage);
            return "error";
        }
    }
}

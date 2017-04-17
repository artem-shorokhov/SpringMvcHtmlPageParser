package org.enigma.htmlpageparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

/**
 *  Class {@code Parser} serves for parsing html page located by specified URL
 *  in search of alphabetical words and count their occurrences.
 *
 *  @author Artem Shorokhov
 */

@Service
public class Parser {

    /**
     * Sorted map of alphabetical words and their occurrences.
     */
    private Map<String, Integer> wordOccurrence;

    /**
     * Total number of alphabetical words on html page.
     */
    private int wordsTotal;

    /**
     * URL of the page.
     */
    private URL url;

    /**
     * JSOUP's {@code parse()} method timeout.
     */
    private static final int TIMEOUT = 5000;

    /**
     * @return sorted map of alphabetical words and their occurrences.
     */
    public Map<String, Integer> getWordOccurrence() {
        return wordOccurrence;
    }

    /**
     * @return total number of alphabetical words on html page.
     */
    public int getWordsTotal() {
        return wordsTotal;
    }

    /**
     * Sets {@code url} from given URL-string, if last satisfies next requirements:
     * - starts with "http://"
     * - resource is accessible
     * - page contains text/http
     *
     * @param urlAsString {@code url} to check.
     * @throws MalformedURLException if {@code url} doesn't satisfy any of given above requirements.
     */
    public void setUrl(String urlAsString) throws MalformedURLException {

        if (urlAsString == null || urlAsString.isEmpty()) {
            throw new MalformedURLException("URL must not be empty.");
        }

        if (!urlAsString.toLowerCase().startsWith("http://")) {
            throw new MalformedURLException("Only http:// URLs are accepted.");
        }

        URL url = new URL(urlAsString);

        String contentType = null;

        try {
            contentType = url.openConnection().getContentType();
        } catch(IOException e) {
            throw new MalformedURLException("Can't connect to specified resource.");
        }

        if (contentType != null && !contentType.contains("text/html")) {
            throw new MalformedURLException("Given URL – " + urlAsString + " - doesn't contain text/html.");
        }

        this.url = url;
    }

    /**
     * Parses html-page specified by {@code url} in search of alphabetical words
     * and count their occurrences using {@code Jsoup} library.
     * Stores found word/occurrence pairs in {@code wordOccurrence} {@code TreeMap}.
     * Count total number of alphabetical words on the page and stores it in {@code wordsTotal}.
     *
     * @throws IOException if any errors were encountered during page parsing.
     */
    public void parse() throws IOException {

        Document document = null;
        document = Jsoup.parse(url, TIMEOUT);

        String pageText = document.body().text();
        String[] pageWords = pageText.split("[^\\p{L}]+");

        wordsTotal = pageWords.length;

        wordOccurrence = new TreeMap<String, Integer>();

        for (String word : pageWords) {
            if (wordOccurrence.containsKey(word)) {
                wordOccurrence.put(word, wordOccurrence.get(word) + 1);
            } else {
                wordOccurrence.put(word, 1);
            }
        }
    }
}

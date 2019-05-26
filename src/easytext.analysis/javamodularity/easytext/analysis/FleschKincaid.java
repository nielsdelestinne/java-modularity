package javamodularity.easytext.analysis;

public class FleschKincaid {

    public double performAnalysis(String text) {
        return getFleschReadingEase(text);
    }

    private int getNumberOfWords(String text) {
        String cleanText = cleanLine(text);
        String[] word = cleanText.split(" ");
        int words = 0;
        for (String w : word) {
            if (w.length() > 0)
                words++;
        }
        return words;
    }

    private int getNumberOfSyllables(String text) {
        String cleanText = cleanLine(text);
        String[] word = cleanText.split(" ");
        int syllables = 0;
        for (String w : word) {
            if (w.length() > 0) {
                syllables += 1; // Not actual syllables...
            }
        }
        return syllables;
    }

    private String cleanLine(String line) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c < 128 && Character.isLetter(c)) {
                buffer.append(c);
            } else {
                buffer.append(' ');
            }
        }
        return buffer.toString().toLowerCase();
    }

    private int getNumberOfSentences(String text) {
        int l = 1; // Only 1 sentence
        if (l > 0)
            return l;
        else if (text.length() > 0)
            return 1;
        else
            return 0;
    }


    private double getFleschReadingEase(String text) {
        return 206.835 - 1.015 * getNumberOfWords(text) / getNumberOfSentences(text) - 84.6 * getNumberOfSyllables(text)
                / getNumberOfWords(text);
    }

}
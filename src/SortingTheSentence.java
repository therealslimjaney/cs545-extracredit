// Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.


public class SortingTheSentence {

    public static String sortSentence(String s) {

        // split the sentence at whitespace
        String[] words = s.split(" ");

        // create an array
        String[] sortedWords = new String[words.length];

        for (String word : words) {
            int position = Character.getNumericValue(word.charAt(word.length() - 1)) - 1;
            sortedWords[position] = word.substring(0, word.length() - 1);
        }

        return String.join(" ", sortedWords);
    }

    public static void main(String args[]) {
        String s = "Are1 we2 out3 of4 the5 woods6 yet7";
        String originalSentence = sortSentence(s);
        System.out.println(originalSentence);
    }
}

import java.util.ArrayList;

// Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.
public class SortingTheSentence {

    public static String sortSentence(String s) {

        ArrayList<String> words = new ArrayList<String>();

        Boolean scanningSentence = true;

        Boolean scanningWord = true;

        int i = 0;

        try {
            while (scanningSentence) {

                if (s.charAt(i) == ' ') {

                    int position = Character.getNumericValue(s.charAt(i - 1));
                    int j = i - 2;

                    while (scanningWord) {

                        if (s.charAt(j) == ' ') {
                            scanningWord = false;
                            words.add(position-1, s.substring(j + 1, i - 2));
                        }
                        j--;
                    }
                }
                i++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            scanningSentence = false;
        }

        String originalSentence = "";

        for (int k = 0; k < words.size() - 1; k++) {
            originalSentence = originalSentence + words.get(k) + " ";
        }
        int last = words.size()-1;
        originalSentence = originalSentence + words.get(last);

        return originalSentence;
    }


        public static void main (String args[]){
            String s = "out3 Are1 we2 yet7 of4 the5 woods6";
            String originalSentence = sortSentence(s);
            System.out.println(originalSentence);
        }
    }

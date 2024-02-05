// This is problem "Sort the people", difficulty 'easy' on leet code
// Return an array of names sorted in descending order of their respective heights

public class SortThePeople {

    public static void sortThePeople(String[] names, int[] heights) {

        // I am going to use insertion sort and make changes in both arrays

        for (int i = 1; i<names.length; i++) {
            int currentHeight = heights[i];
            String currentName = names[i];
            int j = i-1;

            while (j>=0 && heights[j]<currentHeight) {
                heights[j+1] = heights[j];
                names[j+1] = names[j];
                j--;
            }
            heights[j+1] = currentHeight;
            names[j+1] = currentName;
        }

    }
    public static void main(String[] args) {

        String[] someNames = {"Jane", "Yume", "Deven", "Tiansi"};

        int[] someHeights = {4, 9, 3, 7};

        sortThePeople(someNames, someHeights);

        for (int i=0; i<someNames.length; i++) {
            System.out.println(someNames[i]);
        }

    }
}
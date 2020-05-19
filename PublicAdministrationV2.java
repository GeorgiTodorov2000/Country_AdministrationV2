import java.util.Random;
import java.util.Scanner;

public class PublicAdministrationV2 {
    public static final Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        result();


    }



    public static int[] numbersArray(int arraySize) {


        int array[] = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            System.out.println("Input number between 0 and 10 000.");
            int number = scan.nextInt();
            if (number >= 0 && number <= 10000) {
                array[i] = number;
            } else {
                System.out.println("Number must be between 0 and 10 000!");
                i--;
            }
        }

        return array;
    }



    public static void primeNumb(int array[], int arraySize) {
        int[] primeNumbArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            for (int j = 2; j <= array[i]/2; j++) {
                if(array[i] % j == 1)
                {
                    primeNumbArray[i] = array[i];
                }
            }
        }

        for (int element : primeNumbArray) {
            if (element != 0) {
                System.out.println(element + " Is prime number");
            } else {
                System.out.println("This number wasn't prime");
            }
        }
    }

    public static void commonNumb(int array[], int arraySize) {
        int element = 0;

        for (int i = 0; i < arraySize; i++) {
            for (int j = arraySize-1; j >= i; j--) {
                if (array[i] > array[j]) {
                    element = array[i];
                    array[i] = array[j];
                    array[j] = element;
                }
            }
        }

        int max_count = 1;
        int res = array[0];
        int curr_count = 1;

        for (int i = 1; i < arraySize; i++)
        {
            if (array[i] == array[i - 1])
                curr_count++;
            else
            {
                if (curr_count > max_count)
                {
                    max_count = curr_count;
                    res = array[i - 1];
                }
                curr_count = 1;
            }
        }


        if (curr_count > max_count)
        {
            max_count = curr_count;
            res = array[arraySize - 1];
        }

        System.out.println("Most common number is " + res +" was found " + max_count + " times");
    }

    public static void longestRowOfTheSameElements (int[] array,int arraySize) {
        int max_count = 0;
        int curr_count = 0;
        int element = 0;
        for (int i = 0; i < arraySize-1; i++) {
            if (array[i] == (array[i+1])) {
                ++curr_count;
                if (max_count < curr_count) {
                    max_count = curr_count;
                    element = array[i];
                }
            } else {
                curr_count = 0;
            }
        }
        for (int i = 0; i <= max_count; i++) {
            System.out.println(element + " ");
        }
    }

    public static void ascendingRowOfElements(int[] array) {
        int currentStart = 0;
        int currentEnd = 0;
        int longestStart = 0;
        int longestEnd = 0;
        for(int i=1; i<array.length;i++){
            if(array[i-1] <= array[i]+1){
                currentEnd = i;
            } else {
                if(currentEnd - currentStart >= longestEnd - longestStart){
                    longestEnd = currentEnd;
                    longestStart = currentStart;
                }
                currentStart = i;
                currentEnd = i;
                if(array.length - currentStart - 1 < longestEnd - longestStart){
                    break;
                }
            }
        }
        if(currentEnd - currentStart >= longestEnd - longestStart){
            longestEnd = currentEnd;
            longestStart = currentStart;
        }
        if (longestEnd > 1) {
            for (int i = longestStart; i < longestEnd + 1; i++) {
                System.out.println(array[i] + " ");
            }
        } else {
            System.out.println("There isn't an ascending row");
        }
    }

    public static void descendingRowOfElements(int[] array) {
        int currentStart = 0;
        int currentEnd = 0;
        int longestStart = 0;
        int longestEnd = 0;
        for(int i=1; i<array.length;i++){
            if(array[i-1] > array[i]){
                currentEnd = i;
            } else {
                if(currentEnd - currentStart >= longestEnd - longestStart){
                    longestEnd = currentEnd;
                    longestStart = currentStart;
                }
                currentStart = i;
                currentEnd = i;
                if(array.length - currentStart - 1 < longestEnd - longestStart){
                    break;
                }
            }
        }
        if(currentEnd - currentStart >= longestEnd - longestStart){
            longestEnd = currentEnd;
            longestStart = currentStart;
        }
            for (int i = longestStart; i < longestEnd + 1; i++) {
                System.out.println(array[i]);
            }
    }

    public static void reverseString(String[] words) {
        String revStr = "";

        for (int i = 0; i < words.length;i++) {
            String word = words[i];
            String revWord = "";

            for(int j = word.length()-1; j >= 0; j--) {
                revWord = revWord + word.charAt(j);
            }

            revStr = revStr + revWord + " ";
        }
        System.out.println(revStr);


    }

    public static void sameWords(String[] words) {
        int count = 0;
        String str = "";
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].equalsIgnoreCase(words[i])) {
                str = words[i];
                count++;
                if (i == words.length - 1) {
                    System.out.println(str + " " + ++count);
                }
            } else if (!words[i - 1].equalsIgnoreCase(words[i]) && count != 0) {
                System.out.println(str + " " + ++count);
                str = "";
                count = 0;
            }
        }
    }

    public static void wordLetterCount(String[] words) {


        for(int i=0;i<words.length;i++)
        {
            int s = words[i].length();
            System.out.println(words[i] + " Have " + s + " Letters");
        }

    }



    public static void goBackOrExit() {
        System.out.println("1.Go back to menu");
        System.out.println("2.Leave");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                result();
                break;
            case 2:
                System.exit(1);
                break;

        }
    }
    public static void workWithNumbers(int[] array, int arraySize) {
        System.out.println("What do you want us to do for you?");
        System.out.println("1.Show me prime numbers");
        System.out.println("2.Show me the common numbers");
        System.out.println("3.Find longest ascending row");
        System.out.println("4.Find longest descending row");
        System.out.println("5.Find longest row of the same elements?");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                primeNumb(array, arraySize);
                break;
            case 2:
            commonNumb(array, arraySize);
            break;
            case 3:
            ascendingRowOfElements(array);
            break;
            case 4:
            descendingRowOfElements(array);
            break;
            case 5:
            longestRowOfTheSameElements(array, arraySize);
            break;
        }
    }

    public static void workWithWords(String[] words) {
        System.out.println("What do you want us to do for you?");
        System.out.println("1.Reverse the string");
        System.out.println("2.Sorry this option is under developing");
        System.out.println("3.How many letters does the words have");
        System.out.println("4.How many words are the same");
        int option = scan.nextInt();
        switch (option) {
            case 1:
        reverseString(words);
        break;
            case 3:
        wordLetterCount(words);
        break;
            case 4:
                sameWords(words);
                break;
    }
    }

    public static void result() {
        System.out.println("Choose option");
        System.out.println("1.Work with numbers");
        System.out.println("2.Work with words");
        System.out.println("3.Exit our program");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                System.out.println("How big is your array");
                int arraySize = scan.nextInt();
                workWithNumbers(numbersArray(arraySize), arraySize);
                break;
            case 2:
                System.out.println("Input your string");
                String worde = scan.nextLine();
                String word = scan.nextLine();

                String[] words = word.split(" ");
                workWithWords(words);
                break;
            case 3:
                System.out.println("Thanks for using our program");
                System.exit(1);
                break;
        }
        goBackOrExit();
    }
}

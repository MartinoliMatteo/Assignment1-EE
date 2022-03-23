import java.util.Random;
import java.util.Arrays;
import java.nio.charset.Charset;
import sorting.BubbleSortPassPerItem; 
import sorting.BubbleSortUntilNoChange;
import sorting.BubbleSortWhileNeeded;

public class SorterTesterString {

    public static void main(String[] args) {
        int arrLength = 10;
        String[] random_array = rndArray(arrLength); 
        String[] sorted_array = sortedArray(random_array);
        String[] reversed_array = reversedSortedArray(random_array);
        String[] almost_sorted_array = almostSortedArray(random_array);  

        BubbleSortPassPerItem<String> sort1 = new BubbleSortPassPerItem<>();
        BubbleSortUntilNoChange<String> sort2 = new BubbleSortUntilNoChange<>();
        BubbleSortWhileNeeded<String> sort3 = new BubbleSortWhileNeeded<>();

        System.out.println("Array input: String");
        System.out.println("Array length: " + arrLength);

        // ----------------------------------------------------

        System.out.println();
        System.out.println("BubbleSortPassPerItem execution times:");
        
        String[] arr = Arrays.copyOf(random_array,arrLength);
        long before = System.nanoTime();
        sort1.sort(arr); 
        long after = System.nanoTime();
        System.out.print("Random array: ");
        System.out.println(after-before);  

        arr = Arrays.copyOf(sorted_array,arrLength);
        before = System.nanoTime();
        sort1.sort(arr);
        after = System.nanoTime();
        System.out.print("Sorted array: ");
        System.out.println(after-before); 

        arr = Arrays.copyOf(reversed_array,arrLength);
        before = System.nanoTime();
        sort1.sort(arr);
        after = System.nanoTime();
        System.out.print("Reverse sorted array: ");
        System.out.println(after-before); 

        arr = Arrays.copyOf(almost_sorted_array,arrLength);
        before = System.nanoTime();
        sort1.sort(arr);
        after = System.nanoTime();
        System.out.print("Almost sorted array: ");
        System.out.println(after-before);  

        // ----------------------------------------------------

        System.out.println();
        System.out.println("BubbleSortUntilNoChange execution times:");

        arr = Arrays.copyOf(random_array,arrLength);
        before = System.nanoTime();
        sort2.sort(arr);
        after = System.nanoTime();
        System.out.print("Random array: ");
        System.out.println(after-before); 

        arr = Arrays.copyOf(sorted_array,arrLength);
        before = System.nanoTime();
        sort2.sort(arr);
        after = System.nanoTime();
        System.out.print("Sorted array: ");
        System.out.println(after-before); 

        arr = Arrays.copyOf(reversed_array,arrLength);
        before = System.nanoTime();
        sort2.sort(arr);
        after = System.nanoTime();
        System.out.print("Reverse sorted array: ");
        System.out.println(after-before); 

        arr = Arrays.copyOf(almost_sorted_array,arrLength);
        before = System.nanoTime();
        sort2.sort(arr);
        after = System.nanoTime();
        System.out.print("Almost sorted array: ");
        System.out.println(after-before); 
        
        // ----------------------------------------------------

        System.out.println();
        System.out.println("BubbleSortWhileNeeded execution times:");

        arr = Arrays.copyOf(random_array,arrLength);
        before = System.nanoTime();
        sort3.sort(arr);
        after = System.nanoTime();
        System.out.print("Random array: ");
        System.out.println(after-before);  

        arr = Arrays.copyOf(sorted_array,arrLength);
        before = System.nanoTime();
        sort3.sort(arr);
        after = System.nanoTime();
        System.out.print("Sorted array: ");
        System.out.println(after-before); 

        arr = Arrays.copyOf(reversed_array,arrLength);
        before = System.nanoTime();
        sort3.sort(arr);
        after = System.nanoTime();
        System.out.print("Reverse sorted array: ");
        System.out.println(after-before); 

        arr = Arrays.copyOf(almost_sorted_array,arrLength);
        before = System.nanoTime();
        sort3.sort(arr);
        after = System.nanoTime();
        System.out.print("Almost sorted array: ");
        System.out.println(after-before);  
    }

    public static String[] rndArray(int length) {
        String[] ar = new String[length];

        Random rd = new Random();
        for (int i = 0; i < ar.length; i++) {
            byte[] array = new byte[7]; // length is bounded by 7
            rd.nextBytes(array);
           ar[i] = new String(array, Charset.forName("UTF-8"));
        }

        return ar;
    }

    public static String[] sortedArray(String[] ar) {
        String[] ar_copy = Arrays.copyOf(ar,ar.length); 
        Arrays.sort(ar_copy);
        return ar_copy;
    }

    public static String[] reversedSortedArray(String[] ar) {
        String[] ar_copy = Arrays.copyOf(ar,ar.length); 
        ar_copy = sortedArray(ar_copy);

        for (int i = 0; i < ar.length / 2 ; i++){
            String tmp = ar_copy[i];
            ar_copy[i] = ar_copy[ar.length - 1 - i];
            ar_copy[ar.length - 1 - i] = tmp;
        }

        return ar_copy;
    }

    public static String[] almostSortedArray(String[] ar) {
        Random rd = new Random();
        String[] ar_copy = Arrays.copyOf(ar,ar.length); 

        ar_copy = sortedArray(ar_copy); 
       
        int a = rd.nextInt(ar.length);
        int b = a;
        while (b == a){
            b = rd.nextInt(ar.length);
        }

        String tmp = ar_copy[a];
        ar_copy[a] = ar_copy[b];
        ar_copy[b] = tmp;

        return ar_copy;
    }

    // public static void printArr(String[] ar) {
    //     for (int i = 0; i < ar.length; i++){
    //         System.out.println(ar[i]);
    //     }
    //     System.out.println("-------");
    // }
}

import java.util.Random;
import java.util.Arrays;
import sorting.BubbleSortPassPerItem; 
import sorting.BubbleSortUntilNoChange;
import sorting.BubbleSortWhileNeeded;

public class SorterTesterFloat {

    public static void main(String[] args) {
        int arrLength = 10;
        if (args.length != 0) {
            arrLength = Integer.parseInt(args[0]);
        }
        
        Float[] random_array = rndArray(arrLength); 
        Float[] sorted_array = sortedArray(random_array);
        Float[] reversed_array = reversedSortedArray(random_array);
        Float[] almost_sorted_array = almostSortedArray(random_array);    

        BubbleSortPassPerItem<Float> sort1 = new BubbleSortPassPerItem<>();
        BubbleSortUntilNoChange<Float> sort2 = new BubbleSortUntilNoChange<>();
        BubbleSortWhileNeeded<Float> sort3 = new BubbleSortWhileNeeded<>();

        System.out.println("Array input: Float");
        System.out.println("Array length: " + arrLength);

        // ----------------------------------------------------

        System.out.println();
        System.out.println("BubbleSortPassPerItem execution times:");
        
        Float[] arr = Arrays.copyOf(random_array,arrLength);
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


    public static Float[] rndArray(int length) {
        Float[] ar = new Float[length];

        Random rd = new Random();
        for (int i = 0; i < ar.length; i++) {
            ar[i] = rd.nextFloat();
         }

        return ar;
    }

    public static Float[] sortedArray(Float[] ar) { 
        Float[] ar_copy = Arrays.copyOf(ar,ar.length); 
        Arrays.sort(ar_copy);
        return ar_copy;
    }

    public static Float[] reversedSortedArray(Float[] ar) { 
        Float[] ar_copy = Arrays.copyOf(ar,ar.length); 
        ar_copy = sortedArray(ar_copy);

        for (int i = 0; i < ar.length / 2 ; i++){
            Float tmp = ar_copy[i];
            ar_copy[i] = ar_copy[ar.length - 1 - i];
            ar_copy[ar.length - 1 - i] = tmp;
        }

        return ar_copy;
    }

    public static Float[] almostSortedArray(Float[] ar) {
        Random rd = new Random();
        Float[] ar_copy = Arrays.copyOf(ar,ar.length); 

        ar_copy = sortedArray(ar_copy); 
       
        int a = rd.nextInt(ar.length);
        int b = a;
        while (b == a){
            b = rd.nextInt(ar.length);
        }

        Float tmp = ar_copy[a];
        ar_copy[a] = ar_copy[b];
        ar_copy[b] = tmp;

        return ar_copy;
    }

    // public static void printArr(Float[] ar) {
    //     for (int i = 0; i < ar.length; i++){
    //         System.out.println(ar[i]);
    //     }
    //     System.out.println("-------");
    // }
}

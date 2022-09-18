//Joshua Olszewski
//Merge Recursion Sort with USD and C2D objects
import java.util.Scanner;
import java.io.FileWriter;   
import java.io.IOException;
import java.io.PrintStream;
import java.io.File;
public class main
{
    /* creates a USD array based on user input and sorts it out displaying the array at each recursive call and ends up with a sorted array.
     * Displays output in console as well as in output.txt
     
    Precondition:  
    Postcondition: 
    return: none
    
    PseudoCode: 1) create arrays
                2) new recurmergesort object
                3) initialize sort max size 
                4) ask user for array max size
                5) as for usd or c2d objects
                6)if USD create an array of max sizeusd object
                7) if c2d create array of max size c2d object
                8) merge sort displaying into console
                9) merge sort displaying into output.txt
    */ 
    public static void main(String[] args) throws IOException
    {
        USD[] array; 
        USD[] array2; 
        
        RecurMergeSort sort = new RecurMergeSort(); 
        
        Scanner scanner = new Scanner(System.in); 
        
        int SORT_MAX_SIZE = 16;
        int arraySize = 17;
        
        while(arraySize > SORT_MAX_SIZE || arraySize < 1)
        {
            System.out.println("Enter number of elements in array.\nDo not Exceed 16 elements");
            String input = scanner.nextLine();
            arraySize = Integer.parseInt(input);
        } 
        
        String input = "";
        System.out.println("USD or C2D Objects?");
        input = scanner.nextLine();
        input.toLowerCase();
        
        if(input.equals("usd"))
        {
            array = new USD[arraySize];
            array2 = new USD[arraySize];
            for(int i = 0; i < arraySize; i++)
            {
                System.out.println("Type in note value for object: " + (i + 1));
                input = scanner.nextLine();
                int whole = Integer.parseInt(input);
                System.out.println("Type in coin value for object: " + (i + 1));
                input = scanner.nextLine();
                int fraction = Integer.parseInt(input);
                array[i] = new USD(whole, fraction, "USD");
                array2[i] = new USD(whole, fraction, "USD");
            }   
        }
        else
        {
            array = new C2D[arraySize];
            array2 = new C2D[arraySize];
            for(int i = 0; i < arraySize; i++)
            {
                System.out.println("Type in note value for object: " + (i + 1));
                input = scanner.nextLine();
                int whole = Integer.parseInt(input);
                System.out.println("Type in coin value for object: " + (i + 1));
                input = scanner.nextLine();
                int fraction = Integer.parseInt(input);
                array[i] = new C2D(whole, fraction, "C2D");
                array2[i] = new C2D(whole, fraction, "C2D");
            }   
        }
        sort.MergeSort(array, 0, arraySize - 1);
        
        File file = new File("output.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);
        
        sort.MergeSort(array2, 0, arraySize - 1);
        
    }
}
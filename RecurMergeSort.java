
//Joshua Olszewski
//Merge Recursion Sort with USD and C2D objects
public class RecurMergeSort
{
    /* takes and array of USD objects and merges left and right side together in ascending order
     
    Precondition: Needs parameters: USD array, starting index of array, middle index of array, and end index of array. 
    Postcondition: updates the array to be the merged version of the left and right side in ascending order. 
    return: none
    
    PseudoCode: 1) mergedSize = k - i + 1                                       set size of new temp array: mergedSize to be end index - starting index + 1; 
                2) mergePos = 0                                                 start index of new temp array 
                3) leftPos = i                                                  start index of left part of array
                4) rightPos = j + 1                                             start index for right part of array
                5) USD[] mergedarray = new USD[mergedSize]                      create the new temp array.
                6) while(leftPos <= j && rightPos <= k)
                   {
                      1)if(array[leftPos] <= array[rightpos]))            
                        {
                            1) mergedarray[mergePos] = array[leftPos];
                            2) leftPos++; 
                         }
                       2)else
                         {
                            1) mergedarray[mergePos] = array[rightPos];
                            2) rightPos++; 
                         }
                       3) mergePos++;
                    }
                7) while(leftPos <= j)
                    {
                        1) mergedarray[mergePos] = array[leftPos]; 
                        2) leftPos++;
                        3) mergePos++; 
                    }
       
                8)   while(rightPos <= k)
                     {
                         1) mergedarray[mergePos] = array[rightPos];
                         2) rightPos++;
                         3) mergePos++; 
                     }
       
                9)   for(mergePos = 0; mergePos < mergedSize; mergePos++)
                     {
                         1) array[i + mergePos] = mergedarray[mergePos];         
                     }
    */
   public void Merge(USD[] currency, int i, int j, int k)
   {
       int mergedSize = k - i + 1; 
       int mergePos = 0; 
       int leftPos = 0;
       int rightPos = 0; 
       USD[] mergedCurrency = new USD[mergedSize];
       
       leftPos = i;
       rightPos = j + 1; 
       
       while(leftPos <= j && rightPos <= k)
       {
           if((currency[leftPos].getWhole() + ((double)currency[leftPos].getFraction() / 100)) <= (currency[rightPos].getWhole() + ((double)currency[rightPos].getFraction() / 100)))
           {
               mergedCurrency[mergePos] = currency[leftPos];
               leftPos++; 
           }
           else
           {
               mergedCurrency[mergePos] = currency[rightPos];
               rightPos++; 
           }
           mergePos++;
       }
       
       while(leftPos <= j)
       {
           mergedCurrency[mergePos] = currency[leftPos]; 
           leftPos++;
           mergePos++; 
       }
       
       while(rightPos <= k)
       {
           mergedCurrency[mergePos] = currency[rightPos];
           rightPos++;
           mergePos++; 
       }
       
       for(mergePos = 0; mergePos < mergedSize; mergePos++)
       {
           currency[i + mergePos] = mergedCurrency[mergePos];         
       }
       
       for(int z = 0; z < currency.length; z++)
       {
           System.out.println(currency[z].getWhole() + ((double)currency[z].getFraction() / 100));             
       }
       System.out.println(" ");
   }
   /* takes and array of USD objects and recursivly splits the array up into halves until 1 object remains and then merges objects back together in ascending order.
     
    Precondition: Needs parameters: USD array, starting index of array and end index of array. 
    Postcondition: updates the array to be the sorted version of array. 
    return: none
    
    PseudoCode: 1) j=0
                2) if(i<k)
                   {
                       j=(i+k)/2                    find midpoint
                       mergesort(array, i, j)       split into left
                       mergesort(array, j+1, k)     split into right
                       merge(array,i,j,k)           merge left and right
                   }
    */ 
   public void MergeSort(USD[] currency, int i, int k)
   {
       int j = 0;
       
       if(i < k)
       {
           j = (i + k) / 2;
           
           MergeSort(currency, i, j);
           
           MergeSort(currency, j + 1, k); 
           
           Merge(currency, i, j, k);
           
       }
   }
}




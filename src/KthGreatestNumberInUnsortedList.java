
import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.List;  
import java.util.Random;  
import java.util.Scanner;  
  
public class KthGreatestNumberInUnsortedList {  
  
    public static void main(String[] args){  
        List<Integer> myList= new ArrayList<Integer>();  
        myList.add(6);  
        myList.add(42);  
        myList.add(8);  
        myList.add(100);  
        myList.add(27);  
        myList.add(39);  
        myList.add(12);  
        myList.add(270);  
        myList.add(390);  
        myList.add(12);  
  
  
        // Get the value of K from the user  
        System.out.println("Enter the rank k :");  
        Scanner scanner = new Scanner(System.in);  
        int k = scanner.nextInt();  
  
  
        KthGreatestNumberInUnsortedList greatestNumber = new KthGreatestNumberInUnsortedList();  
  
  
  
  
        List<Integer> list = greatestNumber.topKElementsInList(myList, k);  
        List<Integer> list2 = greatestNumber.smallestNumberFromList(list);  
        System.out.println(k + "largest element is:");  
        for(Integer i: list2){  
            System.out.println(i);  
        }  
          
          
          
  
    }  
  
  
  
    /** 
     *  
     * @param myList - Unordered list of integers  
     * @return - list of size 1 which will be the greatest number 
     */  
    public List<Integer> greatestNumberFromList(List<Integer> myList){  
  
        // We have to repeat this exercise until we get a list of size=1  
        while(myList.size()>1){  
  
            // generate a random number based on the size of the list which will represent the position  
            //of the arbitrary element in the list  
            int randomElementIndex = new Random().nextInt(myList.size());  
  
            // find the arbitrary element  
            int randomElement = myList.get(randomElementIndex);  
  
            // temporary list to store the subset containing the n greatest integers  
            List<Integer> greaterNumbersList= new ArrayList<Integer>();  
  
            // iterate through the list and partition   
            // the elements  
            for(int i=0;i<myList.size();i++){  
                if(myList.get(i)>randomElement){  
                    greaterNumbersList.add(myList.get(i));  
                }  
  
            }             
  
            if(greaterNumbersList.size()==0){  
                greaterNumbersList.add(randomElement);  
            }  
  
            //reset the reference myList to point to the temporary list  
            myList = greaterNumbersList;  
  
            // till the size of this temporary list is more than 1, we recursively call  
            // this method from within itself supplying it the temporary list of that pass  
            if(myList.size()>1){  
                greatestNumberFromList(myList);               
            }  
            // when size becomes 1, we have the greatest element with us  
            // so we break out of the loop and return the final list  
            else{  
                break;  
            }  
        }  
        return myList;  
  
  
  
    }  
  
  
  
    public List<Integer> topKElementsInList (List<Integer> myList, int k){  
  
  
  
        List<Integer> topKElements = new ArrayList<Integer>();  
        List<Integer> remainingElements = new ArrayList<Integer>();  
  
        // pick k elements at random  
        // and store it in temporary list  
        for(int i=0; i<k;i++){  
            topKElements.add(myList.get(i));  
        }  
  
  
        // store the rest of elements in  
        // another temporary list  
  
        for(int i=k; i<myList.size();i++){  
            remainingElements.add(myList.get(i));  
        }  
  
  
        Integer [] topKArray =  topKElements.toArray(new Integer[k]);  
  
        Integer [] remainingArray =  remainingElements.toArray(new Integer[myList.size()-k]);  
  
        for(int i=0;i<remainingArray.length;i++){  
  
            for(int j=0;j<topKArray.length;j++){  
                List<Integer> smallestInTopKArray = smallestNumberFromList(Arrays.asList(topKArray));  
                int smallestElement = smallestInTopKArray.get(0);  
                int indexOfSmallestElementInTopKArray = Arrays.asList(topKArray).indexOf(smallestElement);  
                if(remainingArray[i]>smallestElement){  
                    int temp = topKArray[indexOfSmallestElementInTopKArray];  
                    topKArray[indexOfSmallestElementInTopKArray]=remainingArray[i];  
                    remainingArray[i]=temp;  
                    break;  
                }  
            }  
  
        }  
        myList = Arrays.asList(topKArray);  
  
        return myList;  
  
    }  
  
    /** 
     *  
     * @param myList - Unordered list of integers  
     * @return - list of size 1 which will be the greatest number 
     */  
    public List<Integer> smallestNumberFromList(List<Integer> myList){  
  
        // We have to repeat this exercise until we get a list of size=1  
        while(myList.size()>1){  
  
            // generate a random number based on the size of the list which will represent the position  
            //of the arbitrary element in the list  
            int randomElementIndex = new Random().nextInt(myList.size());  
  
            // find the arbitrary element  
            int randomElement = myList.get(randomElementIndex);  
  
            // temporary list to store the subset containing the n greatest integers  
            List<Integer> smallerNumbersList= new ArrayList<Integer>();  
  
            // iterate through the list and partition   
            // the elements  
            for(int i=0;i<myList.size();i++){  
                if(myList.get(i)<randomElement){  
                    smallerNumbersList.add(myList.get(i));  
                }  
  
            }             
  
            if(smallerNumbersList.size()==0){  
                smallerNumbersList.add(randomElement);  
            }  
  
            //reset the reference myList to point to the temporary list  
            myList = smallerNumbersList;  
  
            // till the size of this temporary list is more than 1, we recursively call  
            // this method from within itself supplying it the temporary list of that pass  
            if(myList.size()>1){  
                smallestNumberFromList(myList);               
            }  
            // when size becomes 1, we have the greatest element with us  
            // so we break out of the loop and return the final list  
            else{  
                break;  
            }  
        }  
        return myList;  
  
  
  
    }  
}  
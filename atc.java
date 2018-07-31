import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class ATC {

    public static void main(String[] args) {
find2ndLongestSeq(10000000);

    }

    /*
     * 'find2ndLongestSeq' finds second-longest sequence and sumOfSecondLongestSeqElements of its elements
     * return: nothing, instead print out the result directly on screen
     */
   
    public static void find2ndLongestSeq(int last) {
       
        /*
         * 'elementsNumberResult' saves output of 'elementsNumber' for each initial value
         * 'firstLongestSeq' always saves first-longest sequence
         * 'secondLongestSeq' always saves second-longest sequence
         * 'numOfFirst' always saves first-longest sequence number
         * 'numOfSecond' always saves second-longest sequence number
         * 'sumOfSecondLongestSeqElements' saves sumOfSecondLongestSeqElements of the elements of second-longest sequence
         */
        ArrayList<Long> elementsNumberResult, firstLongestSeq, secondLongestSeq;
        firstLongestSeq = new ArrayList<>();
        secondLongestSeq = new ArrayList<>();
        int numOfFirst = 0, numOfSecond = 0, numOfElements;
        long sumOfSecondLongestSeqElements = 0;
       
        /*
         * from 1 to 'last' calculates sequence information and reveals
         * second-longest sequence
         */
        for (int i = 1; i <= last; i++) {
            elementsNumberResult = elementsNumber(i);
            numOfElements = (elementsNumberResult.get(elementsNumberResult.size() - 1)).intValue();
            if (numOfElements > numOfFirst) {
                numOfSecond = numOfFirst;
                secondLongestSeq = new ArrayList<>(firstLongestSeq);
                numOfFirst = numOfElements;
                firstLongestSeq = new ArrayList<>(elementsNumberResult);
            }
        }

        /* print out second-longest sequence element's number */
        System.out.println("Second-longest sequence has " + numOfSecond + " elements");
       
        /* calculates sumOfSecondLongestSeqElements of all elements of second-longestn sequence */
        for (Iterator<Long> it = secondLongestSeq.iterator(); it.hasNext();) {
            sumOfSecondLongestSeqElements += it.next();
        }
        /* because last element is number of elements */
        sumOfSecondLongestSeqElements -= numOfSecond;
       
        /* print out sumOfSecondLongestSeqElements of second-longest sequence elements*/
        System.out.println("Sum of all the elements: " + sumOfSecondLongestSeqElements);
    }

    /*
     * 'elementsNumber' calculates number of element for initial value of 
     * 'initValue' and save the sequence in ArrayList 'sequenceInfo'
     * return 'sequenceInfo' = [SEQUENCE,numOfElements]
     */
   
    public static ArrayList<Long> elementsNumber(long initValue) {
        /*sequenceInfo array is for saving sequence and number of elements*/
        ArrayList<Long> sequenceInfo = new ArrayList<>();
       
        /* save number of elements in 'numOfElements' */
        int numOfElements = 0;
       
        /* save next number (state) to 'nextState' */
        long nextState = initValue;

        /* calculate next number (state) */
        while (nextState != 1) {
           
            /* increase number of elements by one for each loop */
            numOfElements++;
           
            /* add next number to array */
            sequenceInfo.add(nextState);
           
            /* based on the problem calculate next number */
            if (nextState % 2 == 0) {
                /* for even numbers */
                nextState /= 2;
            } else {
                /* for odd numbers */
                nextState = nextState * 3 + 1;
            }
        }
        /* add last number which is one to the sequence information array list */
        sequenceInfo.add(nextState);
       
        /* add number of element of current sequence as last element of
         * sequence information array list
         */
        sequenceInfo.add((long) (++numOfElements));
        return sequenceInfo;
    }
​}

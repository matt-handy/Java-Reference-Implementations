package sort.selectionsort;

import java.util.List;

import sort.SortHelper;
import sort.Sorter;

public class SelectionSort implements Sorter {

	public void sort(List<Comparable> list) {
		int innerIdx, outerIdx;
		int iMin;
		 
		/* advance the position through the entire array */
		/*   (could do j < n-1 because single element is also min element) */
		for (outerIdx = 0; outerIdx < list.size() - 1; outerIdx++) {
		    /* find the min element in the unsorted a[j .. n-1] */
		 
		    /* assume the min is the first element */
		    iMin = outerIdx;
		    /* test against elements after j to find the smallest */
		    for ( innerIdx = outerIdx+1; innerIdx < list.size(); innerIdx++) {
		        /* if this element is less, then it is the new minimum */  
		        if (list.get(innerIdx).compareTo(list.get(iMin)) < 0) {
		            /* found new minimum; remember its index */
		            iMin = innerIdx;
		        }
		    }
		 
		    /* iMin is the index of the minimum element */ 
		    /* Swap it with the current position if the index of 
		     * the smallest element is not already equal to the current index (j) 
		     */
		    if ( iMin != outerIdx ) {
		    	SortHelper.swap(list, outerIdx, iMin);
		    }
		}
	}

}

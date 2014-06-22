package sort.quicksort;

import java.util.List;

import sort.SortHelper;
import sort.Sorter;

public class QuickSorter implements Sorter {

	public void sort(List<Comparable> list) {
		sortInternal(list, 0, list.size() - 1);
	}
	
	public void sortInternal(List<Comparable> list, int leftBound, int rightBound){
		int leftIdx = leftBound; 
				int rightIdx = rightBound;
	    // Naive pivot section - choose element in middle of list
	    Comparable pivotValue = list.get(leftBound + (rightBound-leftBound)/2);

	    // Perform partition
	    while (leftIdx <= rightIdx) {
	      while (list.get(leftIdx).compareTo(pivotValue) < 0) {
	        leftIdx++;
	      }
	      while (list.get(rightIdx).compareTo(pivotValue) > 0) {
	        rightIdx--;
	      }

	      // Swap left list elements larger than pivot and right list elements
	      // smaller than pivot
	      if (leftIdx <= rightIdx) {
	        SortHelper.swap(list, leftIdx, rightIdx);
	        leftIdx++;
	        rightIdx--;
	      }
	    }
	    // Recursion
	    if (leftBound < rightIdx)
	      sortInternal(list, leftBound, rightIdx);
	    if (leftIdx < rightBound)
	      sortInternal(list, leftIdx, rightBound);
	}
}

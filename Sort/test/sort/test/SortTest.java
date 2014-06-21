package sort.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import sort.bubblesort.BubbleSorter;
import sort.insertionsort.InsertionSorter;
import sort.mergesort.MergeSorter;

public class SortTest extends TestCase{

	public void test() {
		List<Integer> reference = new ArrayList<Integer>();
		reference.add(4);
		reference.add(1);
		reference.add(90);
		reference.add(75);
		reference.add(3);
		
		List<Comparable> bubbleList = new ArrayList<Comparable>(reference);
		new BubbleSorter().sort(bubbleList);
		assertTrue(isSorted(bubbleList));
		
		List<Comparable> mergeSortList = new ArrayList<Comparable>(reference);
		new MergeSorter().sort(mergeSortList);
		assertTrue(isSorted(mergeSortList));
		
		List<Comparable> insertionSortList = new ArrayList<Comparable>(reference);
		new InsertionSorter().sort(insertionSortList);
		assertTrue(isSorted(insertionSortList));
	}
	
	private boolean isSorted(List<Comparable> list){
		for (int idx = 0; idx < list.size() - 1; idx++){
			if(list.get(idx).compareTo(list.get(idx + 1)) > 0){
				return false;
			}
		}
		
		return true;
	}

}

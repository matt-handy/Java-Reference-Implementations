package sort.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import sort.bubblesort.BubbleSorter;
import sort.insertionsort.InsertionSorter;
import sort.mergesort.MergeSorter;
import sort.quicksort.QuickSorter;
import sort.selectionsort.SelectionSorter;

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
		
		List<Comparable> selectionSortList = new ArrayList<Comparable>(reference);
		new SelectionSorter().sort(selectionSortList);
		assertTrue(isSorted(selectionSortList));
		
		List<Comparable> quickSortList = new ArrayList<Comparable>(reference);
		new QuickSorter().sort(quickSortList);
		printList(quickSortList);
		assertTrue(isSorted(quickSortList));
	}
	
	private boolean isSorted(List<Comparable> list){
		for (int idx = 0; idx < list.size() - 1; idx++){
			if(list.get(idx).compareTo(list.get(idx + 1)) > 0){
				return false;
			}
		}
		
		return true;
	}
	
	private void printList(List<Comparable> list){
		System.out.println("List: ");
		for (Comparable comp : list){
			System.out.print(comp + " ");
		}
		System.out.println("");
	}

}

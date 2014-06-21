package sort.bubblesort;

import java.util.List;

import sort.SortHelper;
import sort.Sorter;

public class BubbleSorter implements Sorter {

	public void sort(List<Comparable> list) {
		for(int lastIdxToBeChecked = list.size() - 1; lastIdxToBeChecked > 0; lastIdxToBeChecked--){
			for(int idx = 0; idx < lastIdxToBeChecked; idx++){
				if(list.get(idx).compareTo(list.get(idx + 1)) > 0){
					SortHelper.swap(list, idx, idx + 1);
				}
			}
		}
	}

}

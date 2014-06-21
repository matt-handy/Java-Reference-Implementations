package sort.insertionsort;

import java.util.List;

import sort.Sorter;

public class InsertionSorter implements Sorter {

	public void sort(List<Comparable> list) {
		for (int idx = 1; idx < list.size(); idx++){
			Comparable current = list.get(idx);
			int innerIdx = idx;
			while(innerIdx > 0 && list.get(innerIdx - 1).compareTo(current) > 0){
				list.set(innerIdx, list.get(innerIdx - 1));
				innerIdx--;
			}
			list.set(innerIdx, current);
		}
	}
}

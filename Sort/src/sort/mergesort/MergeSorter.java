package sort.mergesort;

import java.util.ArrayList;
import java.util.List;

import sort.Sorter;

public class MergeSorter implements Sorter {

	private void merge(List<Comparable> listA, List<Comparable> listB, List<Comparable> product){
		product.clear();
		while (listA.size() > 0 || listB.size() > 0) {
			if (listA.size() > 0 && listB.size() > 0){
				if(listA.get(0).compareTo(listB.get(0)) > 0){
					product.add(listB.get(0));
					listB.remove(0);
				}else{
					product.add(listA.get(0));
					listA.remove(0);
				}
			}else if(listA.size() > 0){
				product.add(listA.get(0));
				listA.remove(0);
			}else if(listB.size() > 0){
				product.add(listB.get(0));
				listB.remove(0);
			}
		}
	}
	
	public void sort(List<Comparable> list) {
		if(list.size() == 1){
			return;
		}
		int splitIdx = list.size() / 2;
		List<Comparable> firstHalf = new ArrayList<Comparable>();
		List<Comparable> secondHalf = new ArrayList<Comparable>();
		
		for(int idx = 0; idx < splitIdx; idx++){
			firstHalf.add(list.get(idx));
		}
		for(int idx = splitIdx; idx < list.size(); idx++){
			secondHalf.add(list.get(idx));
		}
		
		sort(firstHalf);
		sort(secondHalf);
		
		merge(firstHalf, secondHalf, list);
	}

}

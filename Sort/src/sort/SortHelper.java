package sort;

import java.util.List;

public class SortHelper {
	public static void swap(List list, int idxOne, int idxTwo){
		Object tmp = list.get(idxOne);
		list.set(idxOne, list.get(idxTwo));
		list.set(idxTwo, tmp);
	}
}

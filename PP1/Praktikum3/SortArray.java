import java.util.Arrays; 

public class SortArray {
	public static void main(String[] args) {
		int len;
		int[] arr;
		
		len = IO1.einint();
		arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = IO1.einint();
		}
		
		System.out.println("Array: " + Arrays.toString(arr));
		System.out.println("Sortiert: " + Arrays.toString(sort(arr)));
	}
	
	static int[] sort(int[] arr) {
		int swap; // Tauschvariable
		for (int runden = 0; runden < arr.length - 1; runden ++) {
			int pos = runden;
			int min = arr[runden];
			for (int i = runden + 1; i < arr.length; i++) {
				if (min > arr[i]) {
					min = arr[i];
					pos = i;
				}
			}
			swap = arr[runden];
			arr[runden] = min;
			arr[pos] = swap;
		}
		
		return arr;
	}
}
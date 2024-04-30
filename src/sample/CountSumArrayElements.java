package sample;

public class CountSumArrayElements {
	public static long countElementsSum(int[] array) {
		long sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			sum+=array[i];
		}
		
		return sum;
	}
}

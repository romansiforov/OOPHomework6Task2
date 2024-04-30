package sample;

public class CountSumArrayElementsTask implements Runnable{
	
	private long sum = 0;
	private int indexStart;
	private int indexEnd;
	private int[] array;
	
	public CountSumArrayElementsTask() {
		
	}

	public CountSumArrayElementsTask(int indexStart, int indexEnd, int[] array) {
		super();
		this.indexStart = indexStart;
		this.indexEnd = indexEnd;
		this.array = array;
	}

	
	
	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	public int getIndexStart() {
		return indexStart;
	}

	public void setIndexStart(int indexStart) {
		this.indexStart = indexStart;
	}

	public int getIndexEnd() {
		return indexEnd;
	}

	public void setIndexEnd(int indexEnd) {
		this.indexEnd = indexEnd;
	}

	public long countElementsSum() {
		long result = 0;
		
		for(int i = indexStart; i < indexEnd; i++) {
			result+=array[i];
		}
		return result;
	}
	
	@Override
	public void run() {
		sum = countElementsSum();
		
	}

}

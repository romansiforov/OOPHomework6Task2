package sample;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
//		Написать код для многопоточного подсчета суммы элементов
//		массива целых чисел. Сравнить скорость подсчета с простым алгоритмом.
		long timeStartSimpleAlgorythm;
		long timeEndSimpleAlgorythm;
		long timeStartThreadAlgorythm;
		long timeEndThreadAlgorythm;
		long elapsedTime; 
		
		int[] array = new int[100000000];
		initArray(array);
		
		timeStartSimpleAlgorythm = System.nanoTime();
		System.out.println("The sum counted by simple algorythm: sum = "+CountSumArrayElements.countElementsSum(array));
		timeEndSimpleAlgorythm = System.nanoTime();
		elapsedTime = timeEndSimpleAlgorythm-timeStartSimpleAlgorythm;
		System.out.println("The execution time for the simple algorythm "+(double)elapsedTime/1000000000+"seconds");
		
		
		
		CountSumArrayElementsTask sumArrayElementTask1 = new CountSumArrayElementsTask(0, 25000000, array);
		CountSumArrayElementsTask sumArrayElementTask2 = new CountSumArrayElementsTask(25000000, 50000000, array);
		CountSumArrayElementsTask sumArrayElementTask3 = new CountSumArrayElementsTask(50000000, 75000000, array);
		CountSumArrayElementsTask sumArrayElementTask4 = new CountSumArrayElementsTask(75000000, 100000000, array);
		
		Thread threadRange1 = new Thread(sumArrayElementTask1);
		Thread threadRange2 = new Thread(sumArrayElementTask2);
		Thread threadRange3 = new Thread(sumArrayElementTask3);
		Thread threadRange4 = new Thread(sumArrayElementTask4);
		
		threadRange1.start();
		threadRange2.start();
		threadRange3.start();
		threadRange4.start();
		
		try {
			timeStartThreadAlgorythm = System.nanoTime();
			threadRange1.join();
			threadRange2.join();
			threadRange3.join();
			threadRange4.join();
			timeEndThreadAlgorythm = System.nanoTime();
			elapsedTime = timeEndThreadAlgorythm - timeStartThreadAlgorythm;
			System.out.println("The sum counted by multithread algorythm: sum = "+(sumArrayElementTask1.getSum()+sumArrayElementTask2.getSum()+sumArrayElementTask3.getSum()+sumArrayElementTask4.getSum()));
			System.out.println("The execution time for the simple algorythm "+(double)elapsedTime/1000000000+"seconds");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initArray(int[] array) {
		Random rn = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}
	}

}

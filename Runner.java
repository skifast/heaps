import java.util.Random;

public class Runner{
	
	public static void main(String[] args){
		
		int[] hello = new int[10];
		
		//generates random numbers for the new array
		Random randGenerate = new Random();
		
		for(int i = 0; i < 10; i ++){
			int k = randGenerate.nextInt(100);
			System.out.println(k);
			hello[i] = k; 
		}
		
		System.out.println(" ");
		
		Heaps heap = new Heaps(hello);
		
		//resets the array cutoff to zero so to look at the whole array
		//heap.resetArrayCutoff();
		
		int root = (hello.length) / 2 -1 ;
		//heap.maxHeapify(hello, root);
		
//	
//		for(int i = 0; i< hello.length; i++){
//			System.out.println(hello[i]);
//		}

		System.out.println(" ");
		System.out.println(" ");
		
		//demonstrates heapsort
		hello = heap.heapsort(hello);
		
		for(int i = 0; i< hello.length; i++){
			System.out.println(hello[i]);
		}
		
		
	}
	
}

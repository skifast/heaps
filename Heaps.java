import java.util.Arrays;

public class Heaps{
	//the array cutoff is the index of the last int being processed
	int arrayCutoff;
	

	public Heaps(int[] givenArray){
		
		//the last index is one less than the length of the array
		arrayCutoff = givenArray.length - 1;
		
		//this is the starting root
		int root = (givenArray.length) / 2 -1 ;
		
		//finds the max
		//maxHeapify(givenArray, root);
		
		
	}
	
	
	public int[] heapsort(int[] givenArray){
		if(arrayCutoff == 0){
			return givenArray;
		}
		
		//int x = extractMax(givenArray);
		
		//this is the starting root
		int root = (givenArray.length) / 2 -1 ;
		maxHeapify(givenArray, root);
		
		swap(0, arrayCutoff, givenArray);
		
		arrayCutoff -= 1;
		//arrayCutoff -= 1;
		return heapsort(givenArray);
	}
	
	//gets the max value to index 0 of the array
	public void maxHeapify(int[] givenArray, int root){ 
		//left node
		int left = root * 2 + 1;
		//right node
		int right = root * 2 + 2;
		
		int greatest = root;
		
		//first we need to make sure that the index we are attempting to acess
		//is actually included in the array
		//arrayCutoff + 1 will give how many nodes there are in the array
		if(left < (arrayCutoff + 1) && givenArray[left] > givenArray[greatest]){
			//the greatest number will eventually become the root
			greatest =  left;
		}
		if(right < (arrayCutoff + 1) && givenArray[right] > givenArray[greatest]){
			greatest = right;
		}
		
		if(greatest != root){
			swap(root, greatest, givenArray);
			maxHeapify(givenArray, greatest);
		}
		
		//the array is maxheapified if the root is 0
		//at this point it has gone through the whole tree
		if(root == 0){
			return;
		}
		
		//otherwise look at the next root
		root -= 1;
		
		maxHeapify(givenArray, root);
	}
	
	//This is an extension
	// :-)
	//returns the sorted list
	public int[] altSort(int[] givenArray, int root){

		if(arrayCutoff == 0){
			return givenArray;
		}
		
		// the left node is bigger than the root
		if( 2 * root + 1 < arrayCutoff && givenArray[2 * root + 1] > givenArray[root] ){
			swap((2* root + 1),root,givenArray);
		}
		if(2 * root + 2 < arrayCutoff && givenArray[2 * root + 2] > givenArray[root]){
			swap((2* root + 2),root,givenArray);
		}
		
		//this will happen when the whole tree is sorted
		if(root == 0){
			
			//move the int at the top of the tree to the back
			swap(root, arrayCutoff, givenArray);
			
		
			//reduce the arrayCutoff
			arrayCutoff -= 1;
			
			//reset the root
			root = (arrayCutoff - 1) / 2;
			
			
			//call recursively 
			altSort(givenArray, root);
			
		}
		else{
			//move up the tree
			root -= 1; 
			
			//call recursively 
			altSort(givenArray, root);
		}
		
		return givenArray;
	}
		
	
	//switches the values at two parameterized indexes
	public void swap(int firstIndex, int secondIndex, int[] givenArray){
		//switch two numbers at specified index
		//the holding int is necessary to that one of the values does not get lost
		int holding = givenArray[firstIndex];
		givenArray[firstIndex] = givenArray[secondIndex];
		givenArray[secondIndex] = holding;
	}
	
	
	//need to assign this to an array
	//size of array is the index of the last int that we want to look at
	public int[] insert(int[] givenArray, int intsert){
		
		//all of the originally allocated indexes are occupied
		if(arrayCutoff == givenArray.length - 1){
			//make a new array that is double the size of the original
			int[] returnArray = new int[givenArray.length * 2];
			//copy the information from the original to the new one
			for(int i = 0; i < givenArray.length; i++){
				returnArray[i] =  givenArray[i];
			}
			//givenArray.length will be one more than the last index of the given array
			returnArray[givenArray.length] = intsert;
			
			givenArray = returnArray;
			
			//size of th array has increased now that the value has been added
			arrayCutoff += 1;
			
			//this is the starting root
			int root = (arrayCutoff) / 2 -1 ;
					
			//max heapify the new array 
			maxHeapify(returnArray, root);
			
			return returnArray;
		}
		else{
			//value at the last possible index - sizeOfArray
			givenArray[arrayCutoff + 1] = intsert;
			
			//size of the array has increased now that the value has been added;
			arrayCutoff += 1;
			
			return givenArray;
		}
	}
	
	
	//returns the maxiumum value to the user after removing it from the array
	public int extractMax(int[] givenArray){
		//this is the starting root
		int root = (arrayCutoff ) / 2 -1 ;
		
		//get the maximum value to the top of the array
		maxHeapify(givenArray, root);
		
		//switch the value at the top of the array with the very last value
		int holding = givenArray[0];
		givenArray[0] = givenArray[arrayCutoff];
		givenArray[arrayCutoff ] = holding;
		
		givenArray[arrayCutoff] = -1;
		
		arrayCutoff -= 1;
		
		return holding;
		//reduce size of the array by one. how tf do i do this
		
	}
	
	
	
}

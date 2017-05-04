import java.util.Arrays;

public class Sorting_alg {
	public static void main(String[] args){
		insertionTest();
		countingTest_worstcase();
    countingTest_bestcase();
	}

	public static int[] getRandom(int n) {	//pass the lenght of array to be created
	//create a new list of array with bunch of random 'n' integers
	int[] list = new int[n];
	for (int i = 0; i<list.length; i++){
			//fill the new array with random integers
	    list[i] = (int)(Math.random()*n);
	}
	    return list;
	}


  public static int[] sort(int[] a){
	//List of unsorted random integers
  Arrays.sort(a); //Sort array 'a'
	//Return a list of sroted arrays in ascending order
	return a;
  }

  public static int[] reversesort(int[] b){
			//Create a new array of reversed integers with a length of input arrays
      for(int z = 0; z < (b.length/2); z++){
          int temp = b[z];
					//reverse array
          b[z] = b[b.length -1 -z];
          b[b.length -1 - z] = temp;
      }
      return b;
  }
	////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////INSERTION SORT///////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////

	//ALGORITHM FOR INSERTION SORT//
	public static void insertionSort (int a[], int n) {
		// System.out.println("Input: " +Arrays.toString(a));
		long insertionStart = System.nanoTime();
		for(int i = 1; i<n; i++) {
			int item = a[i];
			int j = i-1;
			while (j>=0 && a[j]>item) {
				a[j+1] = a[j];
				j = j-1;
			}
			// System.out.println(Arrays.toString(a));
			a[j+1] = item;
		}
		// System.out.println("Result: " +Arrays.toString(a));
		long insertionEnd =  System.nanoTime();
	}

	public static void insertionTest() {
			//create a loop of array length starting from 1000 to 20000, incrementing by 1000
      for (int value_avg = 1000; value_avg<=20000; value_avg+=1000) {
			//for (int value_avg = 5; value_avg<=15; value_avg+=5) {
          System.out.println("Array Length: " +value_avg);
					//create a loop of data points from 1-5
          for (int h = 1; h<=5; h++) {
              System.out.println("Test: " +h);
              int[] rand_arr = getRandom(value_avg); //declaring array in average case
              int n = rand_arr.length;
							//using nanoTime to get the current time
              long insertionStart = System.nanoTime();
							//Run the insertion method
              insertionSort(rand_arr, n);
              long insertionEnd =  System.nanoTime();
							//Find the time taken and records the time for the algorithm
              System.out.println("Average_Insertion_Run-time "+ (insertionEnd - insertionStart));
          }
      }

		//create a loop of array length starting from 1000 to 20000, incrementing by 1000
		for (int value_best = 1000; value_best<=20000; value_best+=1000) {
		//for (int value_best = 5; value_best<=15; value_best+=5) {
            System.out.println("Array Length: " +value_best);
						//create a loop of data points from 1-5
            for (int h = 1; h<=5; h++) {
              	System.out.println("Test: " +h);
                int[] rand_arr = getRandom(value_best); //declaring array in best case
                int n = rand_arr.length;
								//using nanoTime to get the current time
                Arrays.sort(rand_arr);
                long insertionStart = System.nanoTime();
								//Run the insertion method
                insertionSort(rand_arr, n);
                long insertionEnd =  System.nanoTime();
								//Find the time taken and records the time for the algorithm
                System.out.println("Best_Insertion_Run-time "+(insertionEnd - insertionStart));
            }
      }

      int[] randomReverseSorted_array;//initialising the array
			//create a loop of array length starting from 1000 to 20000, incrementing by 1000
      for (int value_worst = 1000; value_worst<=20000; value_worst+=1000) {
			//for (int value_worst = 5; value_worst<=15; value_worst+=5) {
          System.out.println("Array Length: " +value_worst);
					//create a loop of data points from 1-5
          for (int h = 1; h<=5; h++) {
            	System.out.println("Test: " +h);
              int[] rand_arr = getRandom(value_worst); //declaring array in worst case
							//Reverse the unsorted array to make it sorted in reverse descending order
              randomReverseSorted_array = reversesort(rand_arr);
              int n = rand_arr.length;
							//using nanoTime to get the current time
              long insertionStart = System.nanoTime();
              insertionSort(randomReverseSorted_array, n);
              long insertionEnd =  System.nanoTime();
							//Find the time taken and records the time for the algorithm
              System.out.println("Worst_Insertion_Run-time "+(insertionEnd - insertionStart));
          }
      }
    }

////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////COUNTING SORT///////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

	//ALGORITHM FOR COUNTING SORT//
	public static void countingSort (int a[], int b[], int n, int k) {
		int[] c = new int[k+1];
		// System.out.println("Input: " +Arrays.toString(a));
		// System.out.println("Counting Array: " +Arrays.toString(c));
		// System.out.println('\n'+"Loop" +Arrays.toString(a));
		for(int j = 0; j<(n); j++) {
			c[a[j]] = c[a[j]]+1;
		}
		for(int i=1; i<(k); i++) {
			c[i] = c[i]+c[i-1];
		}
		// System.out.println("Loop" +Arrays.toString(c));
		for(int j = (n-1);j<=0; j--) {
			b[c[a[j]]-1] = a[j];
			c[a[j]] = c[a[j]]-1;
		}
		// System.out.println("Loop" +Arrays.toString(c));
		// System.out.println("Loop" +Arrays.toString(c));
		// System.out.println("Loop" +Arrays.toString(b));
		// System.out.println("Output" +Arrays.toString(b));
	}

    public static int getMax(int[] arr_input){
				//set first value in array as the max
        int max = arr_input[0];
        for(int i = 1;i<arr_input.length;i++){
						//if the value in the array is bigger, set new value as max
						if(arr_input[i]>max){
                max = arr_input[i];
            }
        }
				//return the max integer
        return max;
    }

		//Generate data for Counting Worse Case//
    public static void countingTest_worstcase() {
       int[] rand_arr ;
			 //create a loop of array length starting from 1000 to 20000, incrementing by 1000
      for (int value_worst_C = 1000; value_worst_C<=20000; value_worst_C+=1000) {
			// for (int value_worst_C = 3; value_worst_C<=9; value_worst_C+=3) {
            System.out.println("Array Length: " +value_worst_C);
						//create a loop of data points from 1-5
            for (int h = 1; h<=5; h++) {
             	System.out.println('\n'+"Test: " +h);
                rand_arr = getRandom(value_worst_C); //declaring array in worst counting case
								//Empty array for storing random integers
								int[] empty_array = new int[value_worst_C];
								//Length of array is calculated
                int n = rand_arr.length;
                int k_value = (n*n/*+getMax(rand_arr)*//*Get max value*/);
								//using nanoTime to get the current time
                long countingStart = System.nanoTime();
                countingSort(rand_arr, empty_array, n, k_value); //Run mehtod for bad performance
                long countingEnd =  System.nanoTime();
								//Find the time taken and records the time for the algorithm
                System.out.println("Worst_Counting_Run-time "+(countingEnd - countingStart));
            }
      }
    }

		//Generate data for Counting Best Case//
    public static void countingTest_bestcase() {
        int[] rand_arr ;
				//create a loop of array length starting from 1000 to 20000, incrementing by 1000
        for (int value_best_C = 1000; value_best_C<=20000; value_best_C+=1000) {
				//for (int value_best_C = 5; value_best_C<=15; value_best_C+=5) {
            System.out.println("Array Length: " +value_best_C);
						//create a loop of data points from 1-5
            for (int h = 1; h<=5; h++) {
              	System.out.println('\n'+"Test: " +h);
                rand_arr = getRandom(value_best_C); //declaring array in best counting case
								//Empty array for storing random integers
								int[] empty_array = new int[value_best_C];
								//Length of array is calculated
                int n = rand_arr.length;
                int k_value = getMax(rand_arr); //getting the highest number in the array 'rand_arr'
								//using nanoTime to get the current time
                long countingStart = System.nanoTime();
                countingSort(rand_arr, empty_array, n, k_value); //run method for Good performance
                long countingEnd = System.nanoTime();
								//Find the time taken and records the time for the algorithm
                System.out.println("Best_Counting_Run-time "+(countingEnd - countingStart));
            }
        }
    }
}

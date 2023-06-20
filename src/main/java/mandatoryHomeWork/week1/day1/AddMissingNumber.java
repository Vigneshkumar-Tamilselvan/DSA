package mandatoryHomeWork.week1.day1;

import org.junit.Test;

public class AddMissingNumber {

//Given sorted array and insert the missing number in array.
	@Test
	public void testdata_1() {
		int[] arr = { 1, 2, 3, 5, 6 };// Sorted array
		int missing_number = 4; // Missing number
		addMissingNumber(arr, missing_number);
	}

	private void addMissingNumber(int[] arr, int missing_number) {

		int newarr[] = new int[arr.length + 1];

		int i;
		for (i = 0; i < arr.length; i++) { // Step 1 - add before numbers

			if (arr[i] < missing_number) {

				newarr[i] = arr[i];
			} else {
				break;
			}
		}

		newarr[i] = missing_number; // Step 2 - add missing number

		for (; i < arr.length; i++) { // Step 3 - add after numbers

			newarr[i + 1] = arr[i];
		}
		for (int a : newarr) // step 4 - output
			System.out.println(a);
	}
}

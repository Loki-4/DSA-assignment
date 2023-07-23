package a;
import java.util.Arrays;
public class Cumilative {
	    public static void main(String[] args) {
	        int[] arrNum = {5, 3, 4, 2, 0, 8};
	        try {
	            calculateCumulativeMultiple(arrNum);
	            System.out.println("arrNum = " + Arrays.toString(arrNum));
	        } catch (ArithmeticException e) {
	            System.out.println("Error: Division by zero occurred.");
	        }
	    }

	    public static void calculateCumulativeMultiple(int[] arr) {
	        if (arr == null || arr.length == 0) {
	            return;
	        }

	        int cumulativeMultiple = arr[0];
	        arr[0] = cumulativeMultiple;

	        for (int i = 1; i < arr.length; i++) {
	            cumulativeMultiple *= arr[i];
	            arr[i] = cumulativeMultiple;
	        }
	    
	}

}

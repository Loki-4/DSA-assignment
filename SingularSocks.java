package a;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SingularSocks {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int n=sc.nextInt();
    	int[] arrNum=new int[30];
        for(int i=0;i<n;i++) {
        	arrNum[i]=sc.nextInt();
        }
        int count = countSingularSocks(arrNum);
        System.out.println("Count of singular socks = " + count);
    }

    public static int countSingularSocks(int[] arr) {
        Map<Integer, Integer> sockCount = new HashMap<>();
        for (int sock : arr) {
            sockCount.put(sock, sockCount.getOrDefault(sock, 0) + 1);
        }

        int singularSocksCount = 0;
        for (int count : sockCount.values()) {
            if (count % 2 != 0) {
                singularSocksCount++;
            }
        }

        return singularSocksCount;
    }
}

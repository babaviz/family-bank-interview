package simple.rest.server;

import org.junit.jupiter.api.Test;

public class SafaricomTests {
    int solution1(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
            }
            if (A[l] == X) {
                return l;
            }
        }

        return -1;
    }

    public int solution(int[] A) {
        sort(A);
        int initial=sum(A);
        int filters=0;
        int index=0;
        do{
            int item=A[index];
            if(item<1){index++;continue;}
            A[index]=item/2;
            filters++;
            if((index+1)<A.length) {
                if (A[index] < A[index + 1])
                    index++;
            }else
                index=0;

        }while (sum(A)>initial/2);

        return filters;
    }

    private int sum(int [] A){
        int sum=0;
        for (int a :A) {
            sum+=a;
        }
        return sum;
    }

    private void sort(int[] arr){
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    @Test
    public void test(){
        int solution = solution(new int[]{3,19,5,30,8,10,4});
        System.out.println("sol:"+solution);
    }

    public void postgresSql(){

    }
}


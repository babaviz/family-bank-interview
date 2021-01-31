package simple.rest.server;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AndelaTests {

    public int numPlayers(int k, List<Integer> scores){
        if(k>scores.size() || scores.size()>100)
            return 0;

        sort(scores);
        int pos=0;
        int i=0;
        for (;i<scores.size() && pos<=k;i++){
            if(scores.get(0)==0)continue;

            if(i==0){
                pos++;
            }else if(pos==k){
                //count
            }else {
                if(!scores.get(i).equals(scores.get(i - 1))){
                    pos++;
                }
            }
        }

        return i;
    }

    private static void sort(List<Integer> arr){
        int temp;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if(arr.get(i) < arr.get(j)) {
                    temp = arr.get(i);
                    arr.set(i,arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }

    private static void sortAsc(List<Long> arr){
        long temp;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if(arr.get(i) > arr.get(j)) {
                    temp = arr.get(i);
                    arr.set(i,arr.get(j));
                    arr.set(j,temp);
                }
            }
        }
    }
    @Test
    public void test(){
        int i = numPlayers(4, new ArrayList<Integer>() {{
            add(2);
            add(2);
            add(3);
            add(4);
            add(5);
        }});
        System.out.println(i);
    }

    public long carParkingRoof(List<Long> cars,int k){
        sortAsc(cars);
        List<Long> sizes=new ArrayList<>();
        for(int i=0;i<cars.size();i++){
            if(cars.size()>=i+k){
                sizes.add(cars.get(i+k-1)-cars.get(i)+1);
            }
        }
        sortAsc(sizes);
        return sizes.get(0);
    }
    @Test
    public void test2(){
        long i = carParkingRoof( new ArrayList<Long>() {{
            add(6L);
            add(2L);
            add(12L);
            add(7L);
        }},3);
        System.out.println(i);
    }

    public Integer segment(int x, List<Integer> space){
        List<Integer> minima=new ArrayList<>();
        for(int i=0;i<space.size();i+=x){
            List<Integer> segment=new ArrayList<>();
            for (int k=0;k<x && i+k<space.size();k++){
                if(i==0)
                    segment.add(space.get(i+k));
                else
                    segment.add(space.get(i-1+k));
            }
            sort(segment);
            minima.add(segment.get(segment.size()-1));
        }
        sort(minima);
        return minima.get(0);
    }
    @Test
    public void test3(){
        int i = segment(0, new ArrayList<Integer>() {{
            add(2);
            add(5);
            add(4);
            add(6);
            add(8);
        }});
        System.out.println(i);
    }
}

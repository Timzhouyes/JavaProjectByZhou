import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[][] nodes={{1,100,0},{2,50,0},{3,50,0}};
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int sum_weight=0;
        int sum_proceed=0;
        for(int[] i:nodes)
        {
            sum_weight=i[1]+sum_weight;
        }

        for(int[] i:nodes)
        {
            i[1]=i[1]*4/sum_weight;
        }

        for(int[] i:nodes)
        {   int top=i[1];
            for(int j=0;j<top;j++){
            hashMap.put(sum_proceed,i[0]);
            sum_proceed+=1;}
        }

        for(int i=0;i<10000;i++)
        {
            Random rand=new Random();
            int r=rand.nextInt(sum_proceed);
            int index=hashMap.get(r);
            nodes[index-1][2]=nodes[index-1][2]+1;
        }
        System.out.println(nodes.toString());


    }


}

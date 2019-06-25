import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {
        Integer[] intArray={1,2,3,4,5};
        int[] intArr={-2,0,3,-5,2,-1};
        int[] intTest={};
        SegmentTree<Integer> segTest= new SegmentTree<>(intArray, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a+b;
            }
        });
        System.out.println(segTest);
        System.out.println(segTest.query(0,2));

        NumArray2 obj = new NumArray2(intArr);
        int param_1 = obj.sumRange(0,2);
        System.out.println(param_1);
        obj=new NumArray2(intTest);
        System.out.println(obj.sumRange(0,2));



    }


}

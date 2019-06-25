public class Main {

    public static void main(String[] args) {
        Integer[] intArray={1,2,3,4,5};
        SegmentTree<Integer> segTest= new SegmentTree<>(intArray, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a+b;
            }
        });
        System.out.println(segTest);
        System.out.println(segTest.query(0,2));
    }


}

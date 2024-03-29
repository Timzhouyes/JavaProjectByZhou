
public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger){

        this.merger=merger;

        data = (E[])new Object[arr.length];
        for(int i = 0 ; i < arr.length ; i ++)
            data[i] = arr[i];

        tree = (E[])new Object[4 * arr.length];

        buildSegmentTree(0,0,arr.length-1);
    }

    private void buildSegmentTree(int treeIndex,int l,int r)
    {
        if(l==r)
        {
            tree[treeIndex]=data[l];
            return;
        }

        int leftSegIndex=leftChild(treeIndex);
        int rightSegIndex=rightChild(treeIndex);

        int mid=(l+(r-l)/2);

        buildSegmentTree(leftSegIndex,l,mid);
        buildSegmentTree(rightSegIndex,mid+1,r);
        tree[treeIndex]=merger.merge(tree[leftSegIndex],tree[rightSegIndex]);


    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    public E query(int queryL,int queryR)
    {
        if(queryL<0||queryL>=data.length||queryR<0||queryR>=data.length||queryL>queryR)
            throw new IllegalArgumentException("Check your number again!");

        return query(0,0,data.length-1,queryL,queryR);
    }

    private E query(int treeIndex,int l,int r,int queryL,int queryR)
    {
        if(l==queryL&&r==queryR)
            return tree[treeIndex];

        int mid=l+(r-l)/2;

        int leftIndex=leftChild(treeIndex);
        int rightIndex=rightChild(treeIndex);

        if(queryL>mid)
            return query(rightIndex,mid+1,r,queryL,queryR);
        else if(queryR<=mid)
            return query(leftIndex,l,mid,queryL,queryR);

        E leftResult = query(leftIndex,l,mid,queryL,mid);
        E rightResult=query(rightIndex,mid+1,r,mid+1,queryR);

        return merger.merge(leftResult,rightResult);


    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2*index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return 2*index + 2;
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();

        res.append("SegmentTree [");
        for(int i=0;i<tree.length;i++)
        {
            if (tree[i]!=null)
                res.append(tree[i]+" ");
            else
                res.append("null ");

        }
        res.append("]");

        return res.toString();
    }
}

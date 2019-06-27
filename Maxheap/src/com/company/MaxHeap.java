package com.company;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    // 返回堆中的元素个数
    public int size(){
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k){

        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0 ){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中的最大元素
    public E findMax(){
        if(data.getSize()==0)
            throw new IllegalArgumentException("This heap is null. Can not operate.");

        return data.get(0);

    }

    // 取出堆中最大元素
    public E extractMax(){
        E res = findMax();

        data.swap(0,data.getSize()-1);
        data.remove(data.getSize()-1);
        siftDown(0);

        return res;

    }

    //Get the max element in the Heap and change to new Element e
    public E replace(E e)
    {
        E res = findMax();

        data.set(0,e);
        siftDown(0);
        return res;
    }

    private void siftDown(int k){

        while(leftChild(k)<data.getSize())
        {
            int j=leftChild(k);
            if(rightChild(k)<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0)
                j=rightChild(k);

            if(data.get(k).compareTo(data.get(j))>=0)
                break;

            data.swap(k,j);
            k=j;
        }

    }
}
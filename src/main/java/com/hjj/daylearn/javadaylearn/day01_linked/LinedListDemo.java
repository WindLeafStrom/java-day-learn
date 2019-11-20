package com.hjj.daylearn.javadaylearn.day01_linked;

public class LinedListDemo<E> {

    public static void main(String[] args) {
        LinedListDemo<String> demo = new LinedListDemo<>();
        demo.add(0, "aaa");
        System.out.println(demo.toString());
        demo.addFirst("zsf");
        demo.addLast("lzs");
        System.out.println(demo.toString());
        demo.set(1,"abc");
        System.out.println(demo.toString());
        System.out.println(demo.contains("abc"));
        demo.remove(1);
        demo.remove("abc");
        System.out.println(demo.toString());
        System.out.println(demo.get(0));
        System.out.println(demo.getFirst());
        System.out.println(demo.getLast());
    }

    //虚拟头节点
    private Node dumpHead;
    //大小
    private int size;
    //构造方法
    public LinedListDemo(){
        dumpHead = new Node();
        size = 0;
    }
    //主要方法
    //新增
    public void add(int index,E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("illegalargument ");
        Node prev = dumpHead;
        for (int i=0;i<index;i++){
            prev = prev.next;
        }
        prev.next = new Node(e,prev.next);
        size++;
    }
    //头部添加
    public void addFirst(E e){
        add(0,e);
    }
    //尾部添加
    public void addLast(E e){
        add(size,e);
    }
    //set 修改
    public void set(int index,E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException(" set error");
        Node cur = dumpHead;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.e = e;
    }
    //判断是否包含 contains
    public boolean contains(E e){
        Node cur = dumpHead.next;
        while(cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }
    //删除 1
    public void remove(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException(" remove error");
        Node prev = dumpHead;
        for (int i=0;i<index;i++){
            prev = prev.next;
        }
        Node dNode = prev.next;
        prev.next = dNode.next;
        dNode.next = null;
        size --;
    }
    //删除2
    public void remove(E e){
        Node prev = dumpHead;
        while(prev.next != null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }
        Node dNode = prev.next;
        prev.next = dNode.next;
        dNode.next = null;
        size --;
    }
    //删除头部
    public void removeFirst(){
        remove(0);
    }
    //删除尾部
    public void removeLast(){
        remove(size-1);
    }
    //获取
    public E get(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("get error");
        Node cur = dumpHead.next;
        for(int i =0;i<index;i++){
            cur = cur.next;
        }
        return cur.e;
    }
    //获取头部
    public E getFirst(){
        return get(0);
    }
    //获取尾部
    public E getLast(){
        return get(size-1);
    }

    //g公共方法
    //tostring
    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append(String.format("LinkedDemo size:%d\n", size));
        buffer.append("head:");
        Node cur = dumpHead.next;
        while(cur != null){
            buffer.append(cur+" -> ");
            cur = cur.next;
        }
        buffer.append("NULL");
        return buffer.toString();
    }

    //内部类，节点数据
    private class Node{
        private E e = null;
        private Node next = null;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this.e = e;
        }
        public Node(){}

        @Override
        public String toString(){
            return e.toString();
        }
    }
}
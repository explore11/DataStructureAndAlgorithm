package com.example.datastructureandalgorithm.datastructure;

/* *
 * @program: DataStructureAndAlgorithm
 * @description
 * @author: swq
 * @create: 2021-04-12 21:02
 **/
public class CircleQueue {
    private int head;
    private int rear;
    private int maxSize;
    private int[] array;

    public CircleQueue(Integer maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(4);
        System.out.println("add 操作。。。。。。。");
        circleQueue.add(1);
        circleQueue.add(2);
        circleQueue.add(3);
        System.out.println("show 操作。。。。。。。");
        circleQueue.show();
        System.out.println("peek 操作。。。。。。。");
        System.out.println(circleQueue.peek());
        System.out.println("show 操作。。。。。。。");
        circleQueue.show();
        System.out.println("get 操作。。。。。。。");
        System.out.println(circleQueue.get());
        System.out.println("show 操作。。。。。。。");
        circleQueue.show();
        System.out.println("add 操作。。。。。。。");
        circleQueue.add(10);
        System.out.println("show 操作。。。。。。。");
        circleQueue.show();
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == head;
    }

    public boolean isEmpty() {
        return head == rear;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有元素");
        }
        int value = array[head];
        head = (head + 1) % maxSize;
        return value;
    }

    public boolean add(Integer num) {
        if (isFull()) {
            throw new RuntimeException("队列满了，不能添加元素");
        }
        array[rear] = num;
        rear = (rear + 1) % maxSize;
        return true;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有元素");
        }
        return array[head];
    }

    public void show() {
        for (int i = head; i < head + size(); i++) {
            System.out.println(array[i % maxSize]);
        }
    }

    public int size() {
        return (rear - head + maxSize) % maxSize;
    }
}

package com.example.datastructureandalgorithm.datastructure;

import javax.swing.text.html.HTML;

/* *
 * @program: DataStructureAndAlgorithm
 * @description
 * @author: swq
 * @create: 2021-04-12 19:56
 **/
public class Queue {
    private int head;
    private int rear;
    private int maxSize;
    private int[] array;

    public Queue(Integer maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        head = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == (maxSize - 1);
    }

    public boolean isEmpty() {
        return head == rear;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有元素");
        }
        head++;
        return array[head];
    }

    public boolean add(Integer num) {
        if (isFull()) {
            throw new RuntimeException("队列满了，不能添加元素");
        }
        rear++;
        array[rear] = num;
        return true;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有元素");
        }
        return array[head + 1];
    }

    public void show() {
        for (int i = head + 1; i <= rear; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        System.out.println("add 操作。。。。。。。");
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("show 操作。。。。。。。");
        queue.show();
        System.out.println("peek 操作。。。。。。。");
        System.out.println(queue.peek());
        System.out.println("show 操作。。。。。。。");
        queue.show();
        System.out.println("get 操作。。。。。。。");
        System.out.println(queue.get());
        System.out.println("show 操作。。。。。。。");
        queue.show();

    }

}

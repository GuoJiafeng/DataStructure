package io.gjf.T02_Queen;

import java.util.Scanner;

/**
 * Create by GuoJF on 2019/12/17
 */
public class App_ArrayQueen {
    public static void main(String[] args) {


        ArrayQueen arrayQueen = new ArrayQueen(4);

        // 接收用户输入
        char c = ' ';

        Scanner scanner = new Scanner(System.in);

        boolean loap = true;


        while (loap) {
            System.out.println("s(show) : 显示队列");
            System.out.println("g(get) : 获取队列数据");
            System.out.println("e(exit) : 退出程序");
            System.out.println("h(head) : 显示头部数据");
            System.out.println("a(add) : 添加数据");
            c = scanner.next().charAt(0);

            switch (c) {

                case 's':

                    try {
                        arrayQueen.showData();
                    } catch (Exception e) {

                        System.out.println(e.getMessage());

                    }

                    break;
                case 'g':


                    try {
                        int data = arrayQueen.getData();
                        System.out.println("获取到当前的数据为" + data);
                    } catch (Exception e) {

                        System.out.println(e.getMessage());

                    }
                    break;
                case 'a':

                    int n = scanner.nextInt();
                    try {
                        arrayQueen.addData(n);
                    } catch (Exception e) {

                        System.out.println(e.getMessage());

                    }
                    break;
                case 'h':
                    try {
                        int data = arrayQueen.showFront();
                        System.out.println("获取到当前的数据为" + data);
                    } catch (Exception e) {

                        System.out.println(e.getMessage());

                    }
                    break;
                case 'e':

                    loap = false;
                    break;

                default:
                    System.out.println("请输入正确的代码");
                    break;
            }


            System.out.println("程序正在退出....");
        }


    }
}


class ArrayQueen {
    private int maxSize;
    private int rear;  //代表数组尾部下标
    private int front; //代表数组头部下标
    private int[] array; // 模拟队列的数组


    /*
     * 使用构造方法创建数组
     * */
    public ArrayQueen(int size) {

        maxSize = size;

        array = new int[maxSize];

        front = 0;
        rear = 0;

    }

    public void addData(int n) {

        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加！");
        }


        array[rear] = n;

        // rear++; 不能++ 因为要模拟环形队列

        rear = (rear + 1) % maxSize;

    }

    public int getData() {

        if (idEmpty()) {
            throw new RuntimeException("队列为空，无法获取！");
        }

        // 得到当前队列中最靠前的一个元素

        int value = array[front];

        // 将front 后移

        front = (front + 1) % maxSize;
        return value;


    }


    public void showData() {

        if (idEmpty()) {
            throw new RuntimeException("队列为空，无法获取！");
        }


        for (int i = front; i < front + getSum(); i++) {
            System.out.printf("array[%d]=%d\n", i % maxSize, array[i % maxSize]);

        }


    }


    public int getSum() {


        return (rear + maxSize - front) % maxSize;

    }

    public int showFront() {
        if (idEmpty()) {
            throw new RuntimeException("队列为空，无法获取！");
        }

        return array[front];


    }

    public boolean idEmpty() {
        return rear == front;

    }

    public boolean isFull() {


        return (rear + 1) % maxSize == front;


    }


}
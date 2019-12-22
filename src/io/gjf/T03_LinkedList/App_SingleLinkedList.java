package io.gjf.T03_LinkedList;

import java.util.Stack;
import java.util.WeakHashMap;

/**
 * Create by GuoJF on 2019/12/18
 */
public class App_SingleLinkedList {

    public static void main(String[] args) {


        HeroNode heroNode01 = new HeroNode(1, "Oliver Queen", "The Green Arrow");
        HeroNode heroNode02 = new HeroNode(2, "Barry Allen", "The Flash");
        HeroNode heroNode03 = new HeroNode(3, "Bruce Wayne", "Bat Men");
        HeroNode heroNode04 = new HeroNode(4, "Bruce Wayne", "Bat Men");
        HeroNode heroNode05 = new HeroNode(5, "Bruce Wayne", "Bat Men");
        HeroNode heroNode06 = new HeroNode(6, "Bruce Wayne", "Bat Men");


        SingleLinkedList linkedList = new SingleLinkedList();
        SingleLinkedList linkedList2 = new SingleLinkedList();
//        linkedList.add(heroNode01);
//        linkedList.add(heroNode02);
//        linkedList.add(heroNode03);


        linkedList.addByOrder(heroNode01);
        linkedList.addByOrder(heroNode03);
        linkedList.addByOrder(heroNode05);


        linkedList2.addByOrder(heroNode02);
        linkedList2.addByOrder(heroNode04);
        linkedList2.addByOrder(heroNode06);


        SingleLinkedList linkedList3 = new SingleLinkedList();


        linkedList3.add(combineSortedList(linkedList.getHeroNodeHead().nextNode, linkedList2.getHeroNodeHead().nextNode));

        linkedList3.list();


        System.out.println("-----------------------------------------------------------------------------");

       /* linkedList.list();

        System.out.println("-----------------------------------------------------------------------------");

        reversePrint(linkedList.getHeroNodeHead());

        System.out.println("-----------------------------------------------------------------------------");

        reverseList(linkedList.getHeroNodeHead());

        linkedList.list();


        System.out.println("-----------------------------------------------------------------------------");
        *//*
         * 对数据进行修改
         * *//*


        HeroNode heroNode = new HeroNode(1, "奥利弗 奎因", "绿箭侠");

        linkedList.update(heroNode);


        linkedList.list();

        *//*
         * 删除一个节点
         * *//*

        System.out.println("-----------------------------------------------------------------------------");

        linkedList.del(1);
        linkedList.del(2);


        linkedList.list();

        System.out.println("-----------------------------------------------------------------------------");

        System.out.println("当前链表的长度为：" + getListLength(linkedList.getHeroNodeHead()));


        System.out.println("-----------------------------------------------------------------------------");

        System.out.println("倒数第一个节点为:" + findLastIndexNode(linkedList.getHeroNodeHead(), 1));*/
    }

    public static int getListLength(HeroNode heroNodeHead) {


        if (heroNodeHead.nextNode == null) {
            return 0;
        }

        int lenth = 0;

        HeroNode currentNode = heroNodeHead.nextNode;

        while (currentNode != null) {
            lenth++;
            currentNode = currentNode.nextNode;

        }
        return lenth;
    }


    public static HeroNode mergeTwoLists(HeroNode l1, HeroNode l2) {
        // 类似归并排序中的合并过程
        HeroNode dummyHead = new HeroNode(0, "", "");
        HeroNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.no < l2.no) {
                cur.nextNode = l1;
                cur = cur.nextNode;
                l1 = l1.nextNode;
            } else {
                cur.nextNode = l2;
                cur = cur.nextNode;
                l2 = l2.nextNode;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.nextNode = l2;
        } else {
            cur.nextNode = l1;
        }
        return dummyHead.nextNode;
    }


    public static HeroNode combineSortedList(HeroNode heroNodeHead01, HeroNode heroNodeHead02) {

        /*
         * 前提条件 两个列表有序  带头结点
         * */

      /*  if (heroNodeHead01 == null) return heroNodeHead01;
        if (heroNodeHead02 == null) return heroNodeHead02;*/


        HeroNode heroNodeHead = new HeroNode(0, "", "");




        HeroNode tmp = heroNodeHead;


        while (true) {
            if (heroNodeHead01 == null || heroNodeHead02 == null) break;


            if (heroNodeHead01.no < heroNodeHead02.no) {
                tmp.nextNode = heroNodeHead01;


                heroNodeHead01 = heroNodeHead01.nextNode;

            } else {

                tmp.nextNode = heroNodeHead02;


                heroNodeHead02 = heroNodeHead02.nextNode;

            }

            tmp = tmp.nextNode;


        }
        // 任一为空，直接连接另一条链表
        if (heroNodeHead01 == null) {
            tmp.nextNode = heroNodeHead02;
        } else {
            tmp.nextNode = heroNodeHead01;
        }
        //heroNodeHead.nextNode = tmp;

        return heroNodeHead;


    }



    /*
     *查找单链表中的倒数第K个节点
     * */

    /*
     *
     * 思路：
     * 1 编写一个方法 接受head节点 同时接受一个index
     * 2 index 表示倒数第index个节点
     * 3 先把链表从头到尾遍历 得到的链表的总的长度为 getLength
     * 4 得到size 后 从链表的第一个开始遍历 （seiz-index）个  就可以得到
     * 如果找到了 则返回该节点 否则返回Null
     *
     * */


    public static HeroNode findLastIndexNode(HeroNode heroNodeHead, int index) {
        if (heroNodeHead.nextNode == null) {

            /*因为节点为空，返回null
             * */
            return null;
        }

        int size = getListLength(heroNodeHead);

        if (index <= 0 || index > size) {
            /*
             * 超出范围，无法获取数据*/
            return null;
        }


        HeroNode currentNode = heroNodeHead.nextNode;

        for (int i = 0; i < size - index; i++) {

            currentNode = currentNode.nextNode;


        }

        return currentNode;


    }


    public static void reverseList(HeroNode heroNodeHead) {

        /*
         * 如果当前列表为空 无序反转 | 或者只有一个节点
         * */

        if (heroNodeHead.nextNode == null || heroNodeHead.nextNode.nextNode == null) {
            return;
        }

        //定义一个辅助的指针


        HeroNode currentNode = heroNodeHead.nextNode;

        HeroNode heroNodeNext = null;

        HeroNode reverseHead = new HeroNode(0, "", "");

        //遍历原来的链表


        while (currentNode != null) {
            heroNodeNext = currentNode.nextNode;  // 先暂时保存一下当前节点的下一个节点

            currentNode.nextNode = reverseHead.nextNode; // 将当前节点指向新的链表的最前端

            reverseHead.nextNode = currentNode; // 将当前节点指向新的链表的最前端

            currentNode = heroNodeNext; // 让current 后移


        }


        // 将head.next 指向reverseHead.nextNode 实现单链表的反转
        heroNodeHead.nextNode = reverseHead.nextNode;


    }

    public static void reversePrint(HeroNode heroNodeHead) {
        if (heroNodeHead.nextNode == null) {
            return;
        }

        Stack<HeroNode> stack = new Stack<>();

        HeroNode currentNode = heroNodeHead.nextNode;

        while (currentNode != null) {
            stack.add(currentNode);

            currentNode = currentNode.nextNode;
        }


        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}


class SingleLinkedList {
    /*
     * 设置头结点 不存放任何数据
     * */

    private HeroNode heroNodeHead = new HeroNode(0, "", "");

    public HeroNode getHeroNodeHead() {
        return heroNodeHead;
    }

    /*
     *
     * 添加节点到单向列表
     * 此种情况是不考虑编号顺序的
     * 1 找到当前链表的最后节点
     * 2 将最后这个节点的netx 指向新的节点
     * */
    public void add(HeroNode heroNode) {
        // 因为head 节点不能动 因此需要一个复制变量去存储当前的节点

        HeroNode tmp = heroNodeHead;

        // 遍历列表

        while (true) {

            if (tmp.nextNode == null) {
                /*
                 * 如果投
                 * */
                break;
            }
            tmp = tmp.nextNode;
        }

        // 当推出while 循环时  temp 就指向的链表的最后

        tmp.nextNode = heroNode;
    }


    /*
     *
     * 修改节点的信息
     * */

    public void update(HeroNode heroNode) {

        if (heroNodeHead.nextNode == null) {
            System.out.println("没有数据 链表为空");
            return;
        }

        // 找到需要修改的节点


        HeroNode tmp = heroNodeHead.nextNode;
        boolean flag = false;

        while (true) {

            if (tmp == null) {
                /*链表被遍历完毕
                 * */
                break;
            }

            if (tmp.no == heroNode.no) {
                flag = true;
                break;
            }
            tmp = tmp.nextNode;

        }


        if (flag) {

            tmp.realName = heroNode.realName;
            tmp.nickName = heroNode.nickName;

        } else {

            System.out.println("没有找到数据：" + heroNode);

        }

    }

    public void del(int no) {
        if (heroNodeHead.nextNode == null) {
            System.out.println("没有数据 链表为空");
            return;
        }
        /*
         *
         *需要找到需要删除的节点的前一个节点 tmp
         *
         *tmp .next = tmp.next.next();
         * 被删除的节点将不会有引用指向 会被GC回收
         * */


        HeroNode tmp = heroNodeHead;


        boolean flag = false;
        while (true) {

            if (tmp.nextNode == null) {
                break;
            }

            if (tmp.nextNode.no == no) {
                /*
                 * 如果当前的下一个节点的no等于no
                 * 那么久知道了需要删除的节点
                 * */
                flag = true;
                break;
            }

            tmp = tmp.nextNode;// 后移


        }

        if (flag) {

            tmp.nextNode = tmp.nextNode.nextNode;

        } else {

            System.out.println("无法删除" + no);
        }


    }

    public void addByOrder(HeroNode heroNode) {
        // 因为头结点不能动 因为

        HeroNode tmp = heroNodeHead;

        boolean flag = false;

        while (true) {

            if (tmp.nextNode == null) {

                break;
            }

            if (tmp.nextNode.no > heroNode.no) { // 位置找到了  就在tmp的后面插入

                break;
            } else if (tmp.nextNode.no == heroNode.no) {
                /*
                 * 希望添加的node编号已经存在
                 * */
                flag = true;
                break;
            }

            tmp = tmp.nextNode; // 后移


        }

        /*
         * 判断flag的值
         * */


        if (flag) {

            System.out.println("数据已经存在！" + heroNode);

        } else {


            heroNode.nextNode = tmp.nextNode;

            tmp.nextNode = heroNode;

        }
    }

    public void list() {


        /*
         * 通过辅助变量进行遍历
         * */

        // 判断 链表是否为空


        if (heroNodeHead.nextNode == null) {
            System.out.println("链表为空");
            return;
        }

        // 因为头结点 不能动 因此需要一个辅助变量来遍历


        HeroNode tmp = heroNodeHead.nextNode;

        while (true) {


            // 判断是否为连接表为空

            if (tmp == null) {
                break;
            }
            // 输出节点的信息

            System.out.println(tmp);

            tmp = tmp.nextNode;

        }


    }


}


class HeroNode {

    /*
     *
     * heroHead 链表头
     * 不存放具体的数据
     * 作用表示就是单链表的头
     *
     * */

    /*
     *
     * 添加节点到链表中
     * 先创就一个head头结点，作用就是表示单链表的头
     * 后面没添加一个节点，就直接加入到链表的最后
     * */


    /*
     *
     *
     * */

    int no;
    String realName;
    String nickName;
    HeroNode nextNode;

    public HeroNode(int no, String realName, String nickName) {
        this.no = no;
        this.realName = realName;
        this.nickName = nickName;
    }


    @Override
    public String toString() {
        return "HeroNdeo{" +
                "no=" + no +
                ", realName='" + realName + '\'' +
                ", nickName='" + nickName + '\'' +

                '}';
    }
}
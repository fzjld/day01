// 问题：为什么头结点不能动

import java.util.LinkedList;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(11, "萨拉赫", "法老");
        HeroNode hero2 = new HeroNode(9, "菲尔米诺", "菲米");
        HeroNode hero3 = new HeroNode(14, "亨德森", "亨豆");
        HeroNode hero4 = new HeroNode(5, "维纳尔杜姆", "吉尼");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 普通插入的链表
//        System.out.println("不按顺序插入链表");
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero2);
//        singleLinkedList.list();
        // 按顺序插入
        System.out.println("顺序插入的链表为");
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.list();

        //测试修改节点的代码
        HeroNode newHero = new HeroNode(11, "阿萨迪", "水货");
        singleLinkedList.update(newHero);
        System.out.println("更新后的链表：");
        singleLinkedList.list();

        //测试删除节点后的代码
        System.out.println("删除后的链表");
//        singleLinkedList.delete(9);
//        singleLinkedList.list();
        //测试节点的个数
        System.out.println(getLength(singleLinkedList.getHead()));
        // 测试倒数第K个节点是否找到
        System.out.println(findIndex(singleLinkedList.getHead(), 3));

        System.out.println("反转前的链表");
        singleLinkedList.list();
        reverseList(singleLinkedList.getHead());
        System.out.println("反转后的链表");
        singleLinkedList.list();
        // 测试逆序打印的功能
        System.out.println("逆序打印：");
        reversePrint(singleLinkedList.getHead());

    }

    // 返回链表的节点数
    public static int getLength(HeroNode head) {
        HeroNode temp = head.next;
        int count = 0;
        if (head.next == null) { // 链表为空
            return 0;
        }
        while (temp != null) {
            temp = temp.next; // 指针后移
            count++;
        }
        return count;
    }

    // 找到倒数第k个元素，即找到第(length-k)的元素
    public static HeroNode findIndex(HeroNode head, int index) {
        if (head.next == null) {
            return null; // 没有找到就返回空对象
        }
        int length = getLength(head);
        if (index > length || index <= 0) {
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }

    // 使用栈的思想实现对链表元素的逆序打印，不破坏原有的链表结构
    public static void reversePrint(HeroNode head) {
        Stack<HeroNode> heroNodes = new Stack<>();
        if (head.next == null) {
            return;
        }
        HeroNode cur = head.next;
        while (cur != null) {
            heroNodes.push(cur);
            cur = cur.next;
        }
        while (heroNodes.size() > 0) {
            System.out.println(heroNodes.pop());
        }
    }

}

class SingleLinkedList { // add和list方法

    private HeroNode head = new HeroNode(0, "", ""); // head表示头节点，其中的数据是不能动的,所以需要一个辅助变量

    public HeroNode getHead() {
        return head;
    }

    public SingleLinkedList() {

    }

    // 添加按顺序插入元素
    // 更新元素信息(改)

    public void update(HeroNode newHeroNode) {
        HeroNode temp = head.next;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp.next == null) { // 遍历到链表尾部
                break; // 退出循环
            }
            if (temp.no == newHeroNode.no) {
                temp.name = newHeroNode.name;
                temp.nickname = newHeroNode.nickname;
            }
            temp = temp.next;
        }


    }
    // 删除(删)

    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) { //说明遍历到了尾部
                break; // 到尾部自动结束循环
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;  //指针后移
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到删除的对象");
        }
    }
    // 添加（增）
    // 在最后一个对象后添加新的元素

    public void add(HeroNode hero) {
        HeroNode temp = head;
        while (true) { // temp指向链表最后一个元素，然后添加新的元素
            if (temp.next == null) { //当链表遍历到最后一个元素退出循环
                break;
            }
            temp = temp.next;  // 如果不等于null，则temp一直往后指向最后一个元素
        }
        temp.next = hero;  //此时，temp已经指向最后一个对象，在最后一个对象后添加新的对象
    }

    // 按no顺序排序插入
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) { // 已经遍历到最后了
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("编号已存在，无法插入");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
        return;
    }


    //查，遍历链表
    public void list() {  //遍历元素
        // 首先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 使用循环输出链表元素
        HeroNode temp = head.next; // 头节点的后一个元素，即链表第一个元素
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
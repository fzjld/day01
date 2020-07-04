import java.util.HashMap;

public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showList();
        // 当k=1,m=2时，出圈顺序为2,4,1,5,3
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

class CircleSingleLinkedList {
    // 包含addBoy方法
    private Boy first = new Boy(1);

    // 添加元素
    public void addBoy(int num) {
        if (num <= 1) {
            System.out.println("num的值不正确");
            return;
        }
        // 添加元素
        Boy cur = first;
        for (int i = 2; i <= num; i++) {
            Boy boy = new Boy(i);
            boy.setNext(first);  // 新入元素指向头结点
            cur.setNext(boy);   // 上一个元素指向新入元素
            cur = boy;  // 指针后移指向新入元素
        }
    }


    public void showList() { // 打印输出
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.printf("第%d个小孩\n", cur.getNo());
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }


    // 围成一圈，从第k个人开始报数，每一次报m下，然后每一次最后那个人出列被杀，求出列的顺序

    /**
     * @param startNo:表示开始计数的位置，即k
     * @param countNum：表示数了几下，即m
     * @param nums：
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // helper的作用，帮助删除出列的元素
        Boy helper = first; // 先让辅助指针指向第一个元素
        while (true) {
            if (helper.getNext() == first) { // 此时helper已经指向first的前一个元素
                break;
            }
            helper = helper.getNext(); // 指针后移
        }

        // 将指针移动到开始的位置，假如是从k=2开始，则要将两个指针同时移动1步，即k-1步
        for (int i = 1; i < startNo; i++) {
            helper = helper.getNext();
            first = first.getNext();
        }
        // 到了起始位置开始报数，如果m=2(即报两下数)，则helper和first则要移动m-1步，first才能指向出圈的元素
        while (true) {
            if (helper == first) { // 这个表示圈中只有一个元素了
                break;
            }
            for (int i = 0; i < countNum - 1; i++) { // first移动到出圈元素位置
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.printf("出圈元素为%d\n", first.getNo());
            // 删除元素，即出圈元素
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后一个出圈元素为：%d", helper.getNo());


    }
}

//

class Boy {
    private int no;
    private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no) {
        this.no = no;
    }
}

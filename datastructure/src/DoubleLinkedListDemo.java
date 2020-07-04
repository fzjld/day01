public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        LivPlayer player1 = new LivPlayer(10, "马内", "烟熏的太岁");
        LivPlayer player2 = new LivPlayer(11, "萨拉赫", "埃及法老王");
        LivPlayer player3 = new LivPlayer(9, "菲尔米诺", "菲米");
        LivPlayer player4 = new LivPlayer(5, "维纳尔杜姆", "吉尼");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(player1);
        doubleLinkedList.add(player2);
        doubleLinkedList.add(player3);
        doubleLinkedList.add(player4);
        doubleLinkedList.showList();

        // 双向链表删除与单向链表不同，可以实现自我删除
        System.out.println("删除后的链表");
        doubleLinkedList.delete(5);
        doubleLinkedList.showList();

        // 修改
        doubleLinkedList.update(new LivPlayer(7, "奥里吉", "锦鲤"));
        doubleLinkedList.showList();
    }
}

class DoubleLinkedList {
    private LivPlayer head = new LivPlayer(0, "", "");

    //增
    public void add(LivPlayer player) {
        LivPlayer temp = head;
        while (true) {
            if (temp.next == null) { // 到链表尾部
                break;
            }
            temp = temp.next; // 指针后移
        }
        // 此时temp指向最后一个对象
        temp.next = player;
        player.pre = temp;
    }

    // 删
    public void delete(int no) {
        LivPlayer temp = head.next;
        boolean flag = false;
        if (head.next == null) { // 链表为空
            System.out.println("链表为空");
        }
        while (true) {
            if (temp == null) { // 到链表的最后一个对象
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }
    }

    // 改
    public void update(LivPlayer player) {
        LivPlayer temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp.next == null) { // 遍历到链表尾部退出，否则会出现空指针异常
                break;
            }
            if (temp.no == player.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.nickname = player.nickname;
            temp.name = player.name;
        } else {
            System.out.println("没有此号码的球员");
        }

    }


    // 显示链表
    public void showList() {
        LivPlayer temp = head;
        if (head.next == null) {
            System.out.println("链表为空");
        }
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }
}


class LivPlayer {
    public int no;
    public String name;
    public String nickname;
    LivPlayer next;
    LivPlayer pre;

    @Override
    public String toString() {
        return "LivPlayer{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public LivPlayer(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
}

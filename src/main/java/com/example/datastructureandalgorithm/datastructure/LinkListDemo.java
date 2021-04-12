package com.example.datastructureandalgorithm.datastructure;

import java.util.List;

/* *
 * @program: DataStructureAndAlgorithm
 * @description
 * @author: swq
 * @create: 2021-04-12 23:04
 **/
public class LinkListDemo {


    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero = new HeroNode(4, "林冲xx", "豹子头xx");

        LinkList linkList = new LinkList();
        linkList.addSort(hero1);
        linkList.addSort(hero2);
        linkList.addSort(hero3);
        linkList.addSort(hero4);
        linkList.list();

        System.out.println();
        linkList.update(hero);
        linkList.list();

        System.out.println();

        linkList.delete(hero1);
        linkList.delete(hero2);
        linkList.delete(hero3);
        linkList.list();

    }

}

class LinkList {
    // 默认都系节点 不存出数据
    private HeroNode head = new HeroNode(0, "", "");

    // 添加不带排序
    public void add(HeroNode newHeroNode) {
        // 借助临时节点进行操作   head不允许做修改
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = newHeroNode;
                break;
            }
            temp = temp.next;
        }
    }

    // 添加带排序
    public void addSort(HeroNode newHeroNode) {
        // 借助临时节点进行操作   head不允许做修改
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = newHeroNode;
                break;
            }
            if (temp.next.no > newHeroNode.no) {
                newHeroNode.next = temp.next;
                temp.next = newHeroNode;
                break;
            }
            temp = temp.next;
        }
    }

    // 修改
    public void update(HeroNode newHeroNode) {
        // 借助临时节点进行操作   head不允许做修改
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("链表中不存在数据");
                break;
            }
            if (temp.no == newHeroNode.no) {
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    // 删除
    public void delete(HeroNode newHeroNode) {
        // 借助临时节点进行操作   head不允许做修改
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("链表中不存在数据");
                break;
            }
            if (temp.next.no == newHeroNode.no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    // 列表
    public void list() {
        // 借助临时节点进行操作   head不允许做修改
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }

}


class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

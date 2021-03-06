package com.algorithm.list.oneWayLinkedList;

import com.leetcode.source.ListNode;

/**
 * 单向链表
 */
public class LinkedList {

    public ListNode head;

    public ListNode cur;

    /**
     * 统计链表节点的个数
     * @param head 链表头结点
     * @return
     */
    public int linkedListLength(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.getNext();
        }
        return len;
    }

    /**
     * 单向链表List节点进行插入操作
     * @param head 链表头结点
     * @param insertNode 插入结点
     * @param position 插入位置
     * @return
     */
    public ListNode insertInLinkedList(ListNode head, ListNode insertNode, int position) {
        // 如果链表为空，则插入的节点即为头结点
        if (head == null) return insertNode;
        // 获取该链表的结点数
        int size = linkedListLength(head);
        if (position < 1 || position > size + 1) {
            System.out.println("Position of node to insert is invalid.The valid input are 1 to "
                    + (size + 1));
            return head;
        }
        // 否则，插入元素要么是在头插入，要么是在尾节点，或是中间
        if (position == 1) {
            insertNode.setNext(head);
            return insertNode;
        } else {
            // 在链表的中间或尾部插入
            ListNode prev = head;
            int count = 1;
            while (count < position - 1) {
                prev = prev.getNext();
                count++;
            }
            ListNode cur = prev.getNext();
            insertNode.setNext(cur);
            prev.setNext(insertNode);
        }
        return head;
    }

    /**
     * 单向链表List的删除操作
     * @param head 链表头结点
     * @param position 删除位置
     * @return
     */
    public ListNode deleteNodeFromLinkedList(ListNode head, int position) {
        int size = linkedListLength(head);
        if (position < 1 || position > size) {
            System.out.println("Postition of node to delete is invalid.The valid inputs are 1 to "
                    + size);
            return head;
        }
        if (position == 1) {
            ListNode cur = head.getNext();
            head = null;
            return cur;
        } else {
            ListNode prev = head;
            int count = 1;
            while (count < position - 1) {
                prev = prev.getNext();
                count++;
            }
            ListNode cur = prev.getNext();
            prev.setNext(cur.getNext());
            cur = null;
        }
        return head;
    }

    /**
     * 删除单向链表
     * @param head 链表头结点
     */
    public void deleteLinkedList(ListNode head) {
        ListNode tempNode, iterator = head;
        while (iterator != null) {
            tempNode = iterator.getNext();
            iterator = null;
            iterator = tempNode;
        }
    }

    /**
     * 打印链表
     * @param node
     */
    public void print(ListNode node) {
        if (node == null) return;
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.getNext();
        }
        System.out.print("NULL");
    }

    /**
     * 链表添加数据
     * @param data
     * @return
     */
    public ListNode add(int data) {
        // 如果头结点为空,为头结点
        if (head == null) {
            head = new ListNode(data);
            cur = head;
        } else {
            cur.next = new ListNode(data);
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(3);
        linkedList.add(28);
        linkedList.add(2);
        linkedList.add(21);
        linkedList.print(linkedList.head);
        linkedList.deleteNodeFromLinkedList(linkedList.head, 2);
        System.out.println();
        linkedList.print(linkedList.head);
    }
}

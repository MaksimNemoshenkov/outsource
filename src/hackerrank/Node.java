package hackerrank;

import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
 /*    public static  Node insert(Node head,int data) { //working method
       if(head == null) return new Node(data);
        head.next = insert(head.next, data);
        return head;
    }*/

    public static  Node insert(Node head,int data) {
        if(head == null) return new Node(data);
        Node last = head;
        while(last.next!=null){
            last = last.next;
        }
        last.next = new Node(data);
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}
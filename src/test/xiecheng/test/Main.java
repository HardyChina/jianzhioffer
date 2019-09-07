package test.xiecheng.test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        if (head == null) {
            return head;
        }
        ListNode top = head;
        ListNode pre = head;
        ListNode beh = head.next;


        while(beh != null && pre != null){
            if(beh.val <= m){
                pre = beh.next;
                beh.next = top;
                top = beh;
                beh = pre.next;
            }
            else{
                pre = pre.next;
                beh = beh.next;
            }
        }
        return ReverseList(top,head);

    }
    public static ListNode ReverseList(ListNode top, ListNode mark) {
        if (top == mark || top.next == mark){
            return top;
        }
        // 得到尾节点
        ListNode reverseList = ReverseList(top.next,mark);

        top.next.next = top;
        top.next = null;
        return reverseList;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}


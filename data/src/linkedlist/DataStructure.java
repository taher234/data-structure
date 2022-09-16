package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

public class DataStructure {

    public static void main(String[] args) {
//        newDoubleLinkedList<Integer> l = new newDoubleLinkedList();
//        l.addFirst(13);
//        l.addFirst(11);
//        l.addFirst(6);
//        l.addFirst(4);
//        l.addLast(16);
//        l.addLast(26);
//        l.addLast(36);
//        l.addLast(46);
//        l.addLast(2226);
//        l.display();
//        System.out.println(l.get(9));
//        l.reverse();
//        l.display();
//        System.out.println("found ? "+l.search(16));
//        System.out.println("length of the double linked list : " + l.length());
        newLinkedQueue n = new newLinkedQueue();
        n.enqueue(12);
        n.enqueue(22);
        n.enqueue(44);
        n.display();
        n.clear();
        n.display();
        //System.out.println(n.getTop());
    }
}

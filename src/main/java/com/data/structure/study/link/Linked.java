package com.data.structure.study.link;

/**
 * @program: data_structure
 * @description:
 * @author: zhanglailiang
 * @create: 2019-04-21 14:50
 **/
public class Linked {

    public static Node firstNode;

    static {
        firstNode = new Node ("1");
        Node node2 = new Node ("2");
        Node node3 = new Node ("3");
        Node node4 = new Node ("3");
        Node node5 = new Node ("3");
        Node node6 = new Node ("6");

        firstNode.setNextNode (node2);
        node2.setNextNode (node3);
        node3.setNextNode (node4);
        node4.setNextNode (node5);
        node5.setNextNode (node6);
    }
}

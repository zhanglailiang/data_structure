package com.data.structure.study.link;

/**
 * @program: data_structure
 * @description: 链表逆序
 * @author: zhanglailiang
 * @create: 2019-04-16 16:59
 **/
public class LinkListReverse {


    private static Node firstNode;

    static {
        firstNode = new Node ("1");
        Node node2 = new Node ("2");
        Node node3 = new Node ("3");
        Node node4 = new Node ("4");
        Node node5 = new Node ("5");
        Node node6 = new Node ("6");

        firstNode.setNextNode (node2);
        node2.setNextNode (node3);
        node3.setNextNode (node4);
        node4.setNextNode (node5);
        node5.setNextNode (node6);
    }

    /**
     * 通过队列进行递归
     */
    public static Node recursiveLink(Node node) {

        if (node == null || node.getNextNode () == null) {

            if (node != null) {
                System.out.println (node.getValue ());
            }
            return node;
        } else {
            Node newPreNode = recursiveLink (node.getNextNode ());
            node.getNextNode ().setNextNode (node);
            node.setNextNode (null);

            System.out.println (node.getValue ());

            return newPreNode;
        }
    }


    public static void main(String[] args) {
        Node node = recursiveLink (firstNode);

        firstNode = node;

        System.out.println ("end");
    }


}

package com.data.structure.study.link;

/**
 * @program: data_structure
 * @description:  取出链表重复的元素
 * @author: zhanglailiang
 * @create: 2019-04-16 18:15
 **/
public class LinkedRmove {
    private static Node  firstNode;

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


    /**
     * 去除无序链表的重复node
     * @param node
     */
    public static void removeDuplicate(Node node) {

        Node outNode = node;
        Node innerCurNode;
        Node innerPreNode;
        for ( ; outNode  != null ; outNode = outNode.getNextNode () ) {
            for (innerCurNode = outNode.getNextNode (), innerPreNode= outNode; innerCurNode != null;) {
                if (innerCurNode != null && outNode.getValue ().equals (innerCurNode.getValue ())) {
                    innerPreNode.setNextNode (innerCurNode.getNextNode ());
                    innerCurNode = innerCurNode.getNextNode ();
                } else {
                    innerPreNode = innerPreNode.getNextNode ();
                    innerCurNode = innerCurNode.getNextNode ();
                }
            }
        }

        for (; node  != null ; node = node.getNextNode () ) {
            System.out.println (node.getValue ());
        }

    }



    public static void removeDuplicateByHaseSet(Node node) {
//        "类似于hashSet" 利用hashSet的结构
    }

    /**
     * 去除有序节点重复的数据
     * @param node
     */
    public static void removeSortDuplicate(Node node) {
        Node outNode = node;
        Node curNode;
        for (curNode = outNode.getNextNode (); curNode  != null ; ) {
            if (curNode != null && outNode.getValue ().equals (curNode.getValue ())) {
                Node nextNode = curNode.getNextNode ();
                outNode.setNextNode (nextNode);
                curNode.setNextNode (null);
                curNode  = nextNode;
            } else {
                outNode = outNode.getNextNode ();
                curNode = curNode.getNextNode ();
            }
        }

        for (; node  != null ; node = node.getNextNode () ) {
            System.out.println (node.getValue ());
        }
    }

    public static void main(String[] args) {
        removeSortDuplicate (firstNode);
    }


}

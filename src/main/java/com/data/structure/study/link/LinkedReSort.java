package com.data.structure.study.link;

import com.alibaba.fastjson.JSON;

/**
 * @program: data_structure
 * @description: 对链表重新排序（L1-L2。。。。LN--> L1-LN-L2-L(N-1)）
 * @author: zhanglailiang
 * @create: 2019-04-21 14:48
 **/
public class LinkedReSort {

    public static Node firstNode;

    static {
        firstNode = new Node ("1");
        Node node2 = new Node ("2");
        Node node3 = new Node ("4");
        Node node4 = new Node ("5");
        Node node5 = new Node ("6");
        Node node6 = new Node ("7");
        Node node7 = new Node ("8");
        Node node8 = new Node ("9");

        firstNode.setNextNode (node2);
        node2.setNextNode (node3);
        node3.setNextNode (node4);
        node4.setNextNode (node5);
        node5.setNextNode (node6);
        node6.setNextNode (node7);
        node7.setNextNode (node8);
    }

    private static Node reSort(Node node) {

        // 如果节点只有2个一下或者为空，则直接返回
        if (node == null || node.getNextNode () == null || node.getNextNode ().getNextNode () == null) {
            return node;
        }

        Node preHalfNode = node;
        Node nextHalfNode;

        //  1 找到中间节点将节点拆为前半部分与后半部分节点
        Node twoStepNode;
        Node halfNode;
        for (halfNode = node, twoStepNode = node.getNextNode (); ; ) {

            if (twoStepNode.getNextNode () == null) {
                // 断开节点
                nextHalfNode = halfNode.getNextNode ();
                halfNode.setNextNode (null);
                break;
            }
            twoStepNode = twoStepNode.getNextNode ().getNextNode ();
            halfNode = halfNode.getNextNode ();

            if (twoStepNode == null) {
                // 断开节点
                nextHalfNode = halfNode.getNextNode ();
                halfNode.setNextNode (null);
                break;
            }
        }


        System.out.println (JSON.toJSONString (preHalfNode));
        System.out.println (JSON.toJSONString (nextHalfNode));

        // TODO 2 后面的节点进逆序
        nextHalfNode = LinkListReverse.recursiveLink (nextHalfNode);
        System.out.println (JSON.toJSONString (nextHalfNode));

        // TODO 将前面的与后面的节点进行合并
        Node temp = preHalfNode;
        Node nextTempNode = nextHalfNode;
        for (; temp != null; ) {
            temp = temp.getNextNode ();
            preHalfNode.setNextNode (nextHalfNode);
            preHalfNode = temp;

            nextTempNode = nextTempNode.getNextNode ();
            nextHalfNode.setNextNode (preHalfNode);
            nextHalfNode = nextTempNode;
        }

        System.out.println (JSON.toJSONString (node));
        return node;
    }

    public static void main(String[] args) {
        reSort (firstNode);
    }
}

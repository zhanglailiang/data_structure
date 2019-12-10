package com.data.structure.study.link;

/**
 * @program: data_structure
 * @description: 查找倒数第K的节点, (提前几步走的方案)
 * @author: zhanglailiang
 * @create: 2019-04-21 16:27
 **/
public class LineFindK {

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

    /**
     * 节点 k
     *
     * @param k
     * @return
     */
    private static String findKNNode(Node node, int k) {
        Node preKNode = node;
        for (int i = 0; i < k; i++) {
            preKNode = preKNode.getNextNode ();
        }

        for (; preKNode != null; preKNode = preKNode.getNextNode ()) {
            node = node.getNextNode ();
        }

        return node.getValue ();
    }

    public static void main(String[] args) {
        System.out.println (findKNNode (firstNode, 3));
    }
}

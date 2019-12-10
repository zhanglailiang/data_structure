package com.data.structure.study.link;

/**
 * @program: data_structure
 * @description:
 * @author: zhanglailiang
 * @create: 2019-04-16 17:07
 **/
public class Node {

    private String value;

    private Node nextNode;

    public Node(String value) {
        this.value = value;
    }

    public Node(String value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

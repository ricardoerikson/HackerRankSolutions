import java.util.LinkedList;
import java.util.List;

/**
 * @author ricardoerikson
 *
 */
public class Solution {

    public static void main(String[] args) {

    }

}

class Tree {

    private Node root;
    private int numberOfNodes;
    private int qualifier;

    public Tree(int numberOfNodes, int qualifier) {
	this.numberOfNodes = numberOfNodes;
	this.qualifier = qualifier;
    }

    public Tree(String line) {
	String[] parameters = line.split(" ");
	int numberOfNodes = Integer.parseInt(parameters[0]);
	int qualifier = Integer.parseInt(parameters[1]);
	new Tree(numberOfNodes, qualifier);
    }

    public boolean addNode(int parent, int child) {
	return addNode(this.root, parent, child);
    }

    private boolean addNode(Node node, int parent, int child) {
	if (node == null) {
	    node = new Node(parent);
	    node.addChild(child);
	    return true;
	} else if (node.label == parent) {
	    node.addChild(child);
	    return true;
	}

	for (Node nodeChild : node.children) {
	    if (addNode(nodeChild, parent, child))
		return true;
	}
	return false;
    }

}

class Node {

    public int label;
    public Node parent = null;
    public List<Node> children;

    public Node(int label) {
	this.label = label;
	this.children = new LinkedList<Node>();
    }

    public Node addChild(int label) {
	Node childNode = new Node(label);
	childNode.parent = this;
	this.children.add(childNode);
	return childNode;
    }

    public int childrenCount() {
	return this.children.size();
    }

}

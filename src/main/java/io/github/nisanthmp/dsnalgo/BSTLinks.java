package io.github.nisanthmp.dsnalgo;

public class BSTLinks implements BinarySearchTree {
    TreeNode root;
    boolean allowsDuplicate;
    TreeNode parent;
    boolean isRightChild;

    public BSTLinks (boolean allowsDuplicate) {
        this.allowsDuplicate = allowsDuplicate;
    }

    public BSTLinks () {
        this (true);
    }

    @Override
    public boolean addElement(Object elementObj) {
        int element = ((Integer) elementObj).intValue();
        //TreeNode freeNode = (TreeNode) findElement (element);
        //freeNode.element = element;
        if (root == null) {
            root = new TreeNode(element);
            return true;
        }
        return insert (root, element);
    }

    private boolean insert(TreeNode node, int element) {
        if (allowsDuplicate == false && node.element == element) {
            System.out.println("Tree already contains " + element);
            return false;
        }
        if (element > node.element) {
            if (node.rightChild == null) {
                node.rightChild = new TreeNode(element);
                return true;
            } else {
                return insert(node.rightChild, element);
            }
        } else {
            if (node.leftChild == null) {
                node.leftChild = new TreeNode(element);
                return true;
            } else {
                return insert(node.leftChild, element);
            }
        }
    }

    @Override
    public Object findElement(Object elementObj) {
        int element = ((Integer)elementObj).intValue();

        Object found = find(root, element);
        if(found != null) {
            return ((TreeNode)found).element;
        }
        return null;
    }

    private Object find(TreeNode node, int element) {
        if(node == null) return null;
        if(element == node.element) return node;

        parent = node;
        if(element > node.element) {
            isRightChild = true;
            return find(node.rightChild, element);
        } else {
            isRightChild = false;
            return find(node.leftChild, element);
        }

        //return null;
    }

    @Override
    public boolean removeElement(Object elementObj) {
        int element = ((Integer)elementObj).intValue();

        if(root == null) {
            System.out.println(element + " is not in the tree.");
            return false;
        }

        if(root.element == element) {
            root = findSuccessor(root);
            return true;
        }

        TreeNode found = (TreeNode) find(root, element);
        if(found == null) {
            System.out.println(element + " is not in the tree.");
            return false;
        }
        TreeNode successor = findSuccessor(found);
        if(isRightChild) {
            parent.rightChild = successor;
        } else {
            parent.leftChild = successor;
        }
        return true;
    }

    private TreeNode findSuccessor(TreeNode node) {
        if(node.leftChild == null) return node.rightChild;
        if(node.rightChild == null) return node.leftChild;

        TreeNode successor = node.rightChild;
        TreeNode successorsParent = node;
        while (successor.leftChild != null) {
            successorsParent = successor;
            successor = successor.leftChild;
        }
        if(successorsParent == node) {
            successor.leftChild = node.leftChild;
            return successor;
        }
        successorsParent.leftChild = successor.rightChild;

        successor.leftChild = node.leftChild;
        successor.rightChild = node.rightChild;
        return successor;
    }

    @Override
    public void inOrderTraversal() {
        if(root == null) {
            System.out.println("The tree is empty");
            return;
        }
        inOrderTraverse(root);

    }

    private void inOrderTraverse(TreeNode node) {
        if(node == null) return;
        inOrderTraverse(node.leftChild);
        System.out.println(node.element);
        inOrderTraverse(node.rightChild);

    }

    @Override
    public void preOrderTraversal() {

    }

    @Override
    public void postOrderTraversal() {

    }
}

class TreeNode {
    public int element;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode(int element) {
        this.element = element;
    }
}
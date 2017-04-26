package bst;

public class BST<T extends Comparable<T>> {
    private NodeBST<T> head;

    public BST() {
        //this.head = new NodeBST<>();
    }

    public void insert(T data) {
        head = insertBST(data, head);
    }

    private NodeBST<T> insertBST(T data, NodeBST<T> curNode) {
        if (curNode == null)
            curNode = new NodeBST<>(data);
        else if (data.compareTo(curNode.data) <= 0)
            curNode.left = insertBST(data, curNode.left);
        else
            curNode.right = insertBST(data, curNode.right);
        return curNode;
    }

    public void inorder() {
        inorderBST(head);
    }

    private void inorderBST(NodeBST<T> node) {
        if (node != null) {
            inorderBST(node.left);
            System.out.println(node.data);
            inorderBST(node.right);

        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, BST!");
        BST<Integer> bst = new BST<>();
        bst.insert(10);
        bst.insert(15);
        bst.insert(5);
        bst.insert(25);
        bst.insert(6);
        bst.inorder();
        //System.out.println(head.data);
    }

    public static class NodeBST<T> {
        private T data;
        private NodeBST<T> left;
        private NodeBST<T> right;

        public NodeBST(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public NodeBST() {
            this(null);
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setLeft(NodeBST<T> left) {
            this.left = left;
        }

        public void setRight(NodeBST<T> right) {
            this.right = right;
        }

        public T getData() {
            return this.data;
        }

        public NodeBST<T> getLeft() {
            return this.left;
        }

        public NodeBST<T> getRight() {
            return this.right;
        }
    }
}
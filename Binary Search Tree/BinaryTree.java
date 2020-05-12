package ExLab;




public class BinaryTree {
    Node root;

    public BinaryTree() {
    }

    public BinaryTree(Object[] a){

        root = insertLevelOrder(a, root, 1);
    }


    private Node insertLevelOrder(Object[] a, Node node, int i) {
        if (i < a.length) {

            node = new Node(a[i],null,null); //temp;


            node.left = insertLevelOrder(a, node.left, 2 * i);

            node.right = insertLevelOrder(a, node.right, 2 * i + 1);
        }
        return node;
    }

    public void printInOrder(Node node) {
        if (node == null)
            return;

        printInOrder (node.left);

        System.out.print(node.element + " ");

        printInOrder(node.right);

    }


    public void printPreOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.element + " ");

        printPreOrder(node.left);

        printPreOrder(node.right);
    }

    public void printPostOrder(Node node) {
        if (node == null)
            return;

        printPostOrder(node.left);

        printPostOrder(node.right);

        System.out.print(node.element + " ");
    }
    public int height(Node node)
    {
        if (node.right == null)
            return 0;
        else
        {
            int ld = height(node.left);
            int rd = height(node.right);

            if (ld > rd)
                return (ld + 1);
            else
                return (rd + 1);
        }
    }
    public Node copyTree(Node node) {
        if (node == null)
            return node;

        else {

            return new Node(node.element, copyTree(node.left), copyTree(node.right));
        }
    }

}
package ExLab;

public class Driver {
    public static void main(String[] args) {

        Object[] m = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        BinaryTree b = new BinaryTree(m);

        System.out.println("Task 1: ");
        System.out.println("Tree height is "+b.height(b.root));


        System.out.println("Task 3: \nPre Order: ");
        b.printPreOrder(b.root);
        System.out.println();

        System.out.println("Task 4: \nIn-order");
        b.printInOrder(b.root);
        System.out.println();



        System.out.print("Task 5:\nPost Order: ");
        b.printPostOrder(b.root);
        System.out.println();


        Object[] r = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        BinaryTree bt2 = new BinaryTree(r);

        System.out.println("Task 6:\nAre these trees identical");
        System.out.println(identicalTrees(b.root,bt2.root));


        Object[] y = {0, 1, 2, 3, 4, 6, 5, 7, 8, 9, 10, 90};
        BinaryTree t = new BinaryTree(y);
        System.out.println("Are these trees identical?");

        System.out.println(identicalTrees(b.root,t.root));
        ;

        System.out.println("Task 7:\nCopy Tree");
        BinaryTree c = new BinaryTree();
        c.root=b.copyTree(b.root);
        System.out.print("In Order tree 1: ");
        b.printInOrder(b.root);
        System.out.println();
        System.out.print("In Order tree 2: ");
        b.printInOrder(c.root);
        System.out.println();

    }
    public static boolean identicalTrees(Node a, Node b) {
        if (a == null && b == null)
            return true;

        if (a != null && b != null)
            return (a.element == b.element && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));

        return false;
    }
}

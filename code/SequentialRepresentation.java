import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Sequential Tree Representation implementation for the {@link BSPTree}
 * interface.
 * <p>
 * Your task is to complete the implementation of this class. You may add
 * methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 * @author Yongli Ren, 2019.
 */
public class SequentialRepresentation<T> implements BSPTree<T> {

    // Initial capacity of 100
    private int treeSize = 5;
    private T[] myTree = (T[]) new Object[treeSize];

    private int index = 0;

    /**
     * Constructs empty graph.
     */
    public SequentialRepresentation() {
        // test
        // Implement me!
    } // end of SequentialRepresentation()

    @Override
    public void setRootNode(T nodeLabel) {

        if (myTree[0] == null)
            myTree[0] = nodeLabel;
        else
            System.err.println("Tree already has root.");
        // Implement me!
    } // end of setRootNode()

    @Override
    public void splitNode(T srcLabel, T leftChild, T rightChild) {
        if (findNode(srcLabel)) {
            // Parent node exists in the tree.

            // Check array size for available space.
            if (myTree.length <= ((2 * index) + 2)) {
                myTree = Arrays.copyOf(myTree, myTree.length * 2);
            }
            // Check size of array
            /**
             * Left child = 2P + 1 Right Child = 2P + 2
             */
            myTree[(2 * index) + 1] = leftChild;
            myTree[(2 * index) + 2] = rightChild;

        } else {

            // srcLabel node not found.
            return;
        }
        // Implement me!
    } // end of splitNode

    @Override
    public boolean findNode(T nodeLabel) {
        for (int i = 0; i < myTree.length; i++) {

            if (myTree[i] != null) {
                if (myTree[i].equals(nodeLabel)) {
                    // Store the index of the element searched
                    index = i;
                    return true;
                }
            }

        }

        // Implement me!
        return false;
    } // end of findNode

    @Override
    public String findParent(T nodeLabel) {
        String toReturn = "";
        // Implement me!
        if (findNode(nodeLabel)) {

            toReturn += nodeLabel + " ";
            // Node found in tree
            if (index == 0) {
                // This is the root node
                return toReturn;

            } else if (index % 2 == 0) {
                // This is the right child
                int t = (index - 2) / 2;
                // t is the index of parent

                toReturn += myTree[t];
            } else if (index % 2 == 1) {
                // This is the left child
                int t = (index - 1) / 2;
                // t is index of parent

                toReturn += myTree[t];
            }

            return toReturn;
        }
        // Node not found
        return null;

    } // end of findParent

    @Override
    public String findChildren(T nodeLabel) {
        String toReturn = "";
        // Implement me!
        if (findNode(nodeLabel)) {
            // Node found in the tree.
            toReturn += nodeLabel + " ";

            int lChild = (index * 2) + 1;
            int rChild = (index * 2) + 2;

            if (myTree[lChild] != null) {
                toReturn += myTree[lChild] + " ";
            }
            if (myTree[rChild] != null) {
                toReturn += myTree[rChild];
            }

            return toReturn;
        }
        return null;
    } // end of findParent

    @Override
    public void printInPreorder(PrintWriter writer) {
        // Call preorder traversal at root node
        preorderTraverse(0, writer);
        writer.println();
        // Implement me!
    } // end of printInPreorder

    private void preorderTraverse(int index, PrintWriter writer) {

        if (index >= myTree.length) {
            return;
        }

        if (myTree[index] == null) {
            return;
        } else {
            writer.print(myTree[index] + " ");
            preorderTraverse((index * 2) + 1, writer);
            preorderTraverse((index * 2) + 2, writer);
        }
    }

    @Override
    public void printInInorder(PrintWriter writer) {
        // Implement me! Ascending sorted
        inorderTraverse(0, writer);
        writer.println();
    } // end of printInInorder

    private void inorderTraverse(int index, PrintWriter writer) {
        if (index >= myTree.length) {
            return;
        }

        if (myTree[index] == null) {
            return;
        } else {
            inorderTraverse((index * 2) + 1, writer);
            writer.print(myTree[index] + " ");
            inorderTraverse((index * 2) + 2, writer);
        }
    }

    @Override
    public void printInPostorder(PrintWriter writer) {
        // Implement me!
        postorderTraverse(0, writer);
        writer.println();
    } // end of printInPostorder

    private void postorderTraverse(int index, PrintWriter writer) {
        if (index >= myTree.length) {
            return;
        }

        if (myTree[index] == null) {
            return;
        } else {
            postorderTraverse((index * 2) + 1, writer);
            postorderTraverse((index * 2) + 2, writer);
            writer.print(myTree[index] + " ");
        }
    }

} // end of class SequentialRepresentation
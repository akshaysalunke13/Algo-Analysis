import java.io.PrintWriter;


/**
 * Sequential Tree Representation implementation for the {@link BSPTree} interface.
 * <p>
 * Your task is to complete the implementation of this class.
 * You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 * @author Yongli Ren, 2019.
 */
public class SequentialRepresentation<T> implements BSPTree<T> {

    private T myTree[] = null;
    private int index = 0;
    /**
     * Constructs empty graph.
     */
    public SequentialRepresentation() {
    	//test
        // Implement me!
    } // end of SequentialRepresentation()

    @Override
    public void setRootNode(T nodeLabel) {

        myTree[0] = nodeLabel;
        // Implement me!
    } // end of setRootNode()

    @Override
    public void splitNode(T srcLabel, T leftChild, T rightChild) {
        if (findNode(srcLabel)) {
            // Parent node exists in the tree. 
            /**
             * Left child = 2P + 1
             * Right Child = 2P + 2
             */
            myTree[(2 * index) + 1] = leftChild;
            myTree[(2 * index) + 2] = rightChild;
            
        } else {

            //srcLabel node not found.
            return;
        }
        // Implement me!
    } // end of splitNode

    @Override
    public boolean findNode(T nodeLabel) {
        for (int i = 0; i < myTree.length; i++) {
            if(myTree[i] == nodeLabel) {
                index = i;
                return true;
            }
        }

        // Implement me!
        return false;
    } // end of findNode

    @Override
    public String findParent(T nodeLabel) {
        String toReturn="";
        // Implement me!
        if (findNode(nodeLabel)) {

            toReturn += nodeLabel + " ";
            // Node found in tree
            if (index == 0) {
                // This is the root node
                 return toReturn;

            } else if (index % 2 == 0) {
                //This is the right child
                int t = (index - 2)/2;
                // t is the index of parent

                toReturn += myTree[t];
            } else if (index % 2 == 1) {
                //This is the left child
                int t = (index - 1)/2;
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
            //Node found in the tree.
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
        // Implement me!
    } // end of printInPreorder

    @Override
    public void printInInorder(PrintWriter writer) {
        // Implement me! Ascending sorted
    } // end of printInInorder

    @Override
    public void printInPostorder(PrintWriter writer) {
        // Implement me!
    } // end of printInPostorder

} // end of class SequentialRepresentation
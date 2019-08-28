import java.io.PrintWriter;

/**
 * Linked Tree Representation implementation for the {@link BSPTree} interface.
 * <p>
 * Your task is to complete the implementation of this class. You may add
 * methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 * @author Yongli Ren, 2019.
 */
public class LinkedRepresentation<T> implements BSPTree<T> {

    private Node rootNode;
    private Node tempNode;

    /**
     * Constructs empty tree.
     */
    public LinkedRepresentation() {
        // Implement me!
    } // end of LinkedRepresentation()

    @Override
    public void setRootNode(T nodeLabel) {
        if (this.rootNode == null)
            this.rootNode = new Node(nodeLabel);
        else
            System.err.println("Tree already has a root.");
        // Implement me!
    } // end of setRootNode()

    @Override
    public void splitNode(T srcLabel, T leftChild, T rightChild) {
        if (findNode(srcLabel)) {
            if ((tempNode.leftNode == null) && (tempNode.rightNode == null)) {
                tempNode.leftNode = new Node(leftChild);
                tempNode.rightNode = new Node(rightChild);
            } else {
                System.err.println("Node " + tempNode.data.toString() + " already has children.");
            }
        } else {
            System.err.println("Node " + srcLabel + " not found in the tree.");
        }
        // Implement me!
    } // end of splitNode

    @Override
    public boolean findNode(T nodeLabel) {
        if (search(rootNode, nodeLabel)) {
            return true;
        }
        // Implement me!
        return false;
    } // end of findNode

    private boolean search(Node n, T nodeLabel) {

        if (n == null)
            return false;

        if(n.data.equals(nodeLabel)) {
            tempNode = n;
            return true;
        }

        return search(n.leftNode, nodeLabel) || search(n.rightNode, nodeLabel);
        
    }

    
    private String searchParent(Node n, T nodeLabel) {
        String lSearch, rSearch = null;
        if (n == null){
            return null;
        }

        if (n.data.equals(nodeLabel)){
            return n.data.toString() + " ";
        }

        lSearch = searchParent(n.leftNode, nodeLabel);

        if (lSearch == null){
            rSearch = searchParent(n.rightNode, nodeLabel);
            //return lSearch + n.data.toString();
        }

        if (lSearch != null)
            return lSearch + n.data.toString() + " ";

        if (rSearch != null)
            return rSearch + n.data.toString() + " ";

        return null;

    }
    @Override
    public String findParent(T nodeLabel) {
       String s = searchParent(rootNode, nodeLabel);

       if (s == null) {
        return s;
       }

        String tok[] = s.split(" ");
       if (tok.length > 1)
            return tok[0] + " " + tok[1];
        else
            return s;

    } // end of findParent

    @Override
    public String findChildren(T nodeLabel) {
        // Implement me!
        return findChild(rootNode, nodeLabel);
        
    } // end of findParent

    private String findChild(Node n, T nodeLabel) {
        if(search(n, nodeLabel)) {
            if (tempNode.leftNode != null)
                return tempNode.data.toString() + " " + tempNode.leftNode.data.toString() + " " + tempNode.rightNode.data.toString();
            else
                return tempNode.data.toString(); 
        } else {
            System.err.println("Node not found in tree.");
            return null;
        }
    }

    private void preorderTraverse(Node n, PrintWriter w) {
        if (n == null)
            return;
        
        w.write(n.data.toString() + " ");
        System.out.print(n.data.toString() + " ");
        preorderTraverse(n.leftNode, w);
        preorderTraverse(n.rightNode, w);
    }

    @Override
    public void printInPreorder(PrintWriter writer) {
        preorderTraverse(rootNode, writer);
        // Implement me!
    } // end of printInPreorder

    private void inorderTraverse(Node n, PrintWriter w) {
        if (n == null)
            return;
        
        inorderTraverse(n.leftNode, w);
        w.write(n.data.toString() + " ");
        System.out.print(n.data.toString() + " ");
        
        inorderTraverse(n.rightNode, w);
    }

    @Override
    public void printInInorder(PrintWriter writer) {
        inorderTraverse(rootNode, writer);
        // Implement me!
    } // end of printInInorder

    private void postorderTraverse(Node n, PrintWriter w) {
        if (n == null)
            return;
        
        postorderTraverse(n.leftNode, w);
        postorderTraverse(n.rightNode, w);
        w.write(n.data.toString() + " ");
        System.out.print(n.data.toString() + " ");
    }
    
    @Override
    public void printInPostorder(PrintWriter writer) {
        postorderTraverse(rootNode, writer);
        // Implement me!
    } // end of printInPostorder

} // end of class LinkedRepresentation

class Node<T> {
    protected T data;
    protected Node leftNode;
    protected Node rightNode;

    Node(T data) {
        this.data = data;
        leftNode = null;
        rightNode = null;
    }

    /**
     * @return the leftNode
     */
    public Node getLeftNode() {
        return leftNode;
    }

    /**
     * @return the rightNode
     */
    public Node getRightNode() {
        return rightNode;
    }

    public void setData(T data) {
        this.data = data;
    }
}
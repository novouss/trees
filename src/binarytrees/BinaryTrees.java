package binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTrees {
    /*
    
        BINARY TREES ( Started: September 26, 2020 ) Raymond Brian D. Gorospe
    
    Contents:
        Binary Search Trees
        AVL Tress
        Expression Trees
    
        Treeversal ( Tree Traversal )
            Inorder, Preorder, Postorder expression
            Infix, Postfix, Prefix expression
    
    */
    
    
    
    private static final BinarySearchTree BST = new BinarySearchTree();
    private static final AVLTrees AVL = new AVLTrees();
    private static final ExpressionTree EXP = new ExpressionTree();
    private static final Treeversal tree = new Treeversal();
    
    

    public static void main(String[] args) {
        
    }
    
}
//==============================================================================



















//==============================================================================
class Node {
    /*
        
    
    
    */
    
    

    Comparable key;
    Node left;
    Node right;
    
    public Node (Comparable k) {
        key = k;
        left = null;
        right = null;
    }
//==============================================================================
    
    
    // Access Node properties
//==============================================================================
    public Comparable getKey() { return key; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }
//==============================================================================
    
    
//==============================================================================
    
    
    // Set Node properties
//==============================================================================
    public void setKey(int k) { key = k; }
    public void setLeft(Node l) { left = l; }
    public void setRight(Node r) { right = r; }
 
    public String toString() { return key + ""; }
}
//==============================================================================



















//==============================================================================
class BinarySearchTree {
    /*
        
        get - returns the root of the Binary Search Tree
        insert - inserts key to the tree if it hasn't already.
        delete - deletes key from the tree; if key is not found it does nothing.
        search - returns bool of if the key is in the tree or not
    
    */
    
    
    
    Node root;
    
    BinarySearchTree() { root = null; }
    public Node get() { return root; }
//==============================================================================
    
//==============================================================================
    public void insert(int key) {
        // Adds key to BST; else say if it's already there
        if ( !search(key) ) 
            root = insert(root, key);
        else
            System.out.printf("Key: %d was already inserted\n\n", key);
    }
    private static Node insert(Node root, int key) {
        // If root is empty set key as the root
        if (root == null) {
            root = new Node(key);
            return root;
        }
        // else if root is greater than key move to left
        // else if root is smaller than key move to right;
        if ((int) root.key > key) { root.left = insert(root.left, key); }
        if ((int) root.key < key) { root.right = insert(root.right, key); }
        
        // else return unchanged
        return root;
    }
//==============================================================================
    
//==============================================================================
    public void delete(int key) {
        // Removes key from BST; else does nothing
        if ( search(key) )
            root = delete(root, key);
        
    }
    private Node delete(Node root, int key) {
        // If the root is empty or if the key does not exist
        if (root == null) { return root; }
        
        // If root is greater than key move to left;
        // else if root is smaller than key move to right;
        if ((int) root.key > key) { root.left = delete(root.left, key); }
        else if ((int) root.key < key) { root.right = delete(root.right, key); }
        // At the point of this line the root should be now equal to tree
        else {
            // Reach null to find the largest node to replace the deleted node
            if (root.left == null) { return root.right; }
            else if (root.right == null) { return root.left; }
            
            // Delete node
            root.key = minValue(root.right);
            root.right = delete(root.right, (int) root.getKey());
            
        }
        
        return root;
    }
//==============================================================================
    
//==============================================================================
    public boolean search(int key) {
        // if key is in BST returns true; else false
        return search(root, key);
    }
    private boolean search(Node root, int key) {
        // If the root is empty simply return false
        if (root == null) return false;
        // else if root is greater than key move to left
        // else if root is smaller than key move to right
        if ((int) root.key > key) { return search(root.left, key); }
        if ((int) root.key < key) { return search(root.right, key); }
        
        // checks if key is found inside the BST
        return (int) root.key == key;
    }
//==============================================================================
    
//==============================================================================
    public static int minValue(Node root) {
        int min = (int) root.key;
        
        if (root.left != null) {
            min = (int) root.left.key;
            root = root.left;
        }
        return min;
    }
    
}    
//==============================================================================



















//==============================================================================
class AVLTrees {
    
    Node root;
    
    AVLTrees() { root = null; }
    public Node get() { return root; }
//==============================================================================
    
//==============================================================================
    public void insert(int key) { 
        // Inserting nodes is similar to a Binary Search Tree
        if ( !search(key) ) 
            root = insert(root, key);
        else 
            System.out.printf("Key: %d was already inserted%n%n", key);
    
    } 
    private Node insert(Node root, int key) {
        // If root is empty set key as the root
        if (root == null) {
            root = new Node(key);
            return root;
        }
        // else if root is greater than key move to left
        // else if root is smaller than key move to right
        if ((int) root.key > key) { root.left = insert(root.left, key); }
        if ((int) root.key < key) { root.right = insert(root.right, key); }
        
        // else return unchanged
        return root;

    }
//==============================================================================
    
//==============================================================================
    public void delete(int key) {
        // Removes key from BST; else does nothing
        if ( search(key) )
            root = delete(root, key);
        
    }
    private Node delete(Node root, int key) {
        // If the root is empty or if the key does not exist
        if (root == null) { return root; }
        
        // If root is greater than key move to left;
        // else if root is smaller than key move to right;
        if ((int) root.key > key) { root.left = delete(root.left, key); }
        else if ((int) root.key < key) { root.right = delete(root.right, key); }
        // At the point of this line the root should be now equal to tree
        else {
            // Reach null to find the largest node to replace the deleted node
            if (root.left == null) { return root.right; }
            else if (root.right == null) { return root.left; }
            
            // Delete node
            root.key = minValue(root.right);
            root.right = delete(root.right, (int) root.getKey());
            
        }
        
        return root;
    }
//==============================================================================
    
//==============================================================================
    public boolean search(int key) {
        return search(root, key);
    }
    public boolean search(Node root, int key) {
        // If the root is empty simply return false
        if (root == null) { return false; }
        // else if root is greater than key move to left
        // else if root is smaller than key move to right
        if ((int) root.key > key) { return search(root.left, key); }
        if ((int) root.key < key) { return search(root.right, key); }
        
        // checks if key is found inside the BST
        return (int) root.key == key;
    }
//==============================================================================
    
//==============================================================================
    public static int minValue(Node root) {
        int min = (int) root.key;
        
        if (root.left != null) {
            min = (int) root.left.key;
            root = root.left;
        }
        return min;
    }
//==============================================================================
    
//==============================================================================
    public int getDepth(Node root) {
        return getDepth(root, 0);
    }
    private int getDepth(Node root, int depth) {
        // Reach the bottom part of the tree.
        if (root == null) { return 0; }
        else if (root.left == null && root.right == null) { return depth; }
        else {
            // Move down and increase value by one for every recursion
            return getDepth(root.left, depth - 1) - getDepth(root.right, depth + 1);
        }
        
    }
//==============================================================================
    
    
}
//==============================================================================



















//==============================================================================
class ExpressionTree {
    /*
    
        get - returns the root of the tree
        build - builds the expression tree
        
        preceedenceOf - returns an int value of the operator else return 0
        isOperator - returns a bool if the operator is an operation

    */
    
    
    
    Node root;
    
    ExpressionTree() { root = null; }
    public Node get() { return root; }
//============================================================================== 
   
//==============================================================================
    public Node build(String expression) {
        // Separates expression to easily differentiate operators and operands
        ArrayList<String> array = new ArrayList<>();
        String text = "";
        // Reads individual characters in String
        for (int i = 0; i < expression.length(); i++) {
            
            char c = expression.charAt(i);
            // if its an operator, add the stacked characters to array (text)
            // add the operator to array; refresh text; else stack character to text
            if ( isOperator(c) ) {
                // if ever the user decides to add spaces (idiot)
                if (!text.equals("")) { array.add(text); }
                array.add(c + "");
                text = "";
                
            } else { text += c; }
            
        }
        // adds final text / number to array
        if (!text.equals("")) { array.add(text); }
        // start to building node tree
        return build(array.toArray(new String[0]));
    }    
    private Node build(String[] expression) {

        Stack<Node> stackN = new Stack<>(); // Number stack
        Stack<Node> stackC = new Stack<>(); // Character stack [ +, -, ,* /, ^, (, ) ] 
        Node node = null, node1; // node1 is the temporary node
        
        for (String number: expression) {
            
            // Retrieve nodes and index of expression
            char c = number.charAt(0);
            node = new Node(number);
            
            if ( c == '(') {
                // Add openning parenthesis to tell the system where to stop
                stackC.push(node);
                
            } else if ( c == ')' ) {
                
                // Pop out all of nodes in stackC until it reaches the openning
                // parenthesis inserted earlier
                while(!stackC.isEmpty() && !stackC.peek().toString().equals("(")) {
                    
                    node1 = stackC.pop();
                    
                    node1.right = stackN.pop();
                    node1.left = stackN.pop();
                    
                    stackN.push(node1);
                    
                }
                
                // No need to push the closing parenthesis to stack just remove
                // openning parenthesis
                
                stackC.pop();

            } else if ( !isOperator(c) ) {
                
                // Push number to Number Stack
                stackN.push(node);
                                
            } else {
                // As long as the stack is empty and their level is lower or equal continue.     
                while(!stackC.isEmpty() && preceedenceOf(c) <= preceedenceOf(stackC.peek())) {
                                       
                    // Make character as the parent
                    node1 = stackC.pop();
                    
                    // Set numbers as its children
                    if (!stackN.isEmpty()) node1.right = stackN.pop();
                    if (!stackN.isEmpty()) node1.left = stackN.pop();
                    
                    stackN.push(node1);
                }
                
                // Push new node to the stack
                stackC.push(node);
            }
        }
        
        // Leftovers
        while(!stackC.isEmpty()) {
            // Make character as the parent
            node1 = stackC.pop();

            // Set numbers as its children
            if (!stackN.isEmpty()) node1.right = stackN.pop();
            if (!stackN.isEmpty()) node1.left = stackN.pop();

            stackN.push(node1);
        }
        // Set root as the final build
        root = stackN.peek();
        return stackN.pop();
    }
//==============================================================================
    
//==============================================================================
    private int preceedenceOf(char c) {
        
        switch (c) {
            // P - is seprate.
            case '^': // E - EXPONENT
                return 3;
            case '*': // M - MULTIPLY
            case '/': // D - DIVIDE
                return 2;
            case '+': // A - ADD
            case '-': // S - SUBTRACT
                return 1;
            
        }
                
        return 0;
    }
    private int preceedenceOf(Node c) {
        // Converts Comparable to ( char ) for preceedence checking 
        String character = "" + c.key;
        return preceedenceOf(character.charAt(0));
    }
//==============================================================================
    
//==============================================================================
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
    }
    
}
//==============================================================================



















//==============================================================================
class Treeversal { 
    /*
    
        getHeight - returns an int of the longes path of the tree.
        getSize - returns an int of the total size of the tree.
    
        inorder - prints the tree in a Left, Root, Right order
        preorder - prints the tree in a Root, Left, Right order
        postorder - prints the tree in a Left, Right, Root order
        breadthfirst - prints the tree in preorder but respective to their levels
        levelorder - prints the tree in breadthfirst but visualized like a tree
    
    */
    
    
    
    public int getHeight(Node root) {
        // If the root is empty simply return a 0
        if (root == null) { return 0; }
        
        // Keep moving down a certain path get length for each side
        int left = getHeight(root.left);
        int right = getHeight(root.right);      
        return (left > right) ? left + 1 : right + 1;
        
    }
    
    public int getSize(Node root) {
        if ( root == null ) { return 0; }
        return getSize(root.left) + 1 + getSize(root.right);
        
    }
//==============================================================================

//==============================================================================
    public void inorder(Node root) {
        // Goes from Left, Root, Right
        System.out.print("[INORDER] ");
        _inorder(root);
        System.out.println();
    }
    private void _inorder(Node root) {       
        if (root == null) { return; }
        
        _inorder(root.left);
        System.out.print(root.key + " ");
        _inorder(root.right);
    }
//==============================================================================
    
//==============================================================================
    public void preorder(Node root) {
        // Goes from Root, Left, Right
        System.out.print("[PREORDER] ");
        _preorder(root);
        System.out.println();
    }
    private void _preorder(Node root) {
        if (root == null) { return; }
        
        System.out.print(root.key + " ");
        _preorder(root.left);
        _preorder(root.right);
    }
//==============================================================================
    
//==============================================================================
    public void postorder(Node root) {
        // Goes from Left, Right, Root
        System.out.print("[POSTORDER] ");
        _postorder(root);
        System.out.println();
    }
    private void _postorder(Node root) {
        if (root == null) { return; }
        
        _postorder(root.left);
        _postorder(root.right);
        System.out.print(root.key + " ");
    }
//==============================================================================
    
//==============================================================================
    public void breadthfirst(Node root) {
        System.out.print("[BREADTH-FIRST] ");
        _breadthfirst(root);
        System.out.println();
    }
    private void _breadthfirst(Node root) {
        
        // If the root is empty simply return
        if (root == null) { return; }
        
        // Queue that holds node pointers
        Queue<Node> queue = new LinkedList<>();
        // Initally add to queue to enter the loop
        queue.add(root);
        
        while ( !queue.isEmpty() ) {
            
            // Visit the pointed node
            Node node = queue.poll();
            // Print the pointed node and remove as its already been processed
            System.out.print(node.key + " ");

            // If a left or right child exists add it for later processing
            if ( node.left != null ) { queue.add(node.left); }
            if ( node.right != null) { queue.add(node.right); }
            
        }

        queue.clear();
    }
//==============================================================================

//==============================================================================
    public void levelorder(Node root) {
        System.out.println("[LEVEL ORDER]");
        List<List<String>> tree = _levelorder(root);
        for (List<String> leaf : tree) {
            
            for (String node : leaf) {
                
                System.out.print( node.equals("") ? " " : node );
                
            }
            System.out.println();
        }
        
    }
    private List<List<String>> _levelorder(Node root) {
        // Create a result tree.
        List<List<String>> tree = new ArrayList<>();
        // If root is empty simply return empty tree
        if ( root == null ) { return tree; }
        // Similar to Breadthfirst but indexes are needed
        // Previous variable ' Queue ' has been changed to ' Parent ' but retains purpose
        Queue<Node> parent = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        
        // Retrieve the height and size for tree creation (length)
        int height = getHeight(root);
        int size = (int) Math.pow(2, height) - 1;
        // Similar to Breadthfirst
        parent.add(root);
        index.add(size/2);
        
        while ( !parent.isEmpty() ) {
            
            Queue<Node> tempParent = new LinkedList<>();
            Queue<Integer> tempIndex = new LinkedList<>();
            
            List<String> list = createList(size);
            
            while( !parent.isEmpty() ) { 
                // Similar to Breadthfirst
                Node node = parent.poll();
                int currentIndex = index.poll();

                list.set(currentIndex, node.getKey() + "");

                int nextIndex = (int) Math.pow(2, height - 2);

                if (node.left != null) {
                    tempParent.add(node.left);
                    tempIndex.add(currentIndex - nextIndex);
                }

                if (node.right != null) {
                    tempParent.add(node.right);
                    tempIndex.add(currentIndex + nextIndex);
                }
            }
            
            parent = tempParent;
            index = tempIndex;
            height--;
            
            tree.add(list);
            
        }
        
        return tree;
        
    }
    private List<String> createList(int size) {
        // Create a temporary List to store spaces and return
        List<String> string = new LinkedList<>();
        
        for(int i = 0; i < size; i++) { string.add(""); }
        
        return string;
        
    }
}
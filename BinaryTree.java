import java.util.*;
public class BinaryTree{
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    static class Binarytree{
        static int idx=-1;
        public static Node buildtree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildtree(nodes);
            newNode.right=buildtree(nodes);
            return newNode;
        }
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelorder(Node root){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curNode=q.remove();
            if(curNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(curNode.data+" ");
                if(curNode.left!=null) q.add(curNode.left);
                if(curNode.right!=null) q.add(curNode.right);
            }
        } 
    }
    public static int height(Node root){
        if(root==null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
    public static int diameter(Node root){
        if(root==null) return 0;
        int d1=height(root.left);
        int d2=height(root.right);
        int d3=height(root.left)+height(root.right)+1;
        return Math.max(d3,Math.max(d1,d2));
    }
    public static int noOfNodes(Node root){
        if(root==null) return 0;
        int lc=noOfNodes(root.left);
        int rc=noOfNodes(root.right);
        return lc+rc+1;
    }
    public static int sumOfNodes(Node root){
        if(root==null) return 0;
        int ls=sumOfNodes(root.left);
        int rs=sumOfNodes(root.right);
        return ls+rs+root.data;
    }
    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binarytree tree=new Binarytree();
        Node root=tree.buildtree(nodes);
        System.out.println(root.data);
        System.out.println("preorder traversal of the tree is --> ");
        preorder(root);
        System.out.println();
        System.out.println("inorder traversal of the tree is --> ");
        inorder(root);
        System.out.println();
        System.out.println("postorder traversal of the tree is --> ");
        postorder(root);
        System.out.println();
        System.out.println("levelorder traversal of the tree is --> ");
        levelorder(root);
        System.out.println("the height of the tree is --> "+height(root));
        System.out.println("the diamter of the tree is --> "+diameter(root));
        System.out.println("the number Of Nodes in  the tree are --> "+noOfNodes(root));
        System.out.println("the sum Of Nodes data of the tree is --> "+sumOfNodes(root));
    }
}

package com.sgmarghade.dsalgo.tree;

/**
 * Created by swapnil on 03/12/16.
 * http://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
 * Input :
 * in[]   = {2, 1, 3}
 * post[] = {2, 3, 1}
 * <p>
 * Output : Root of below tree
 * 1
 * / \
 * 2   3
 * <p>
 * <p>
 * Input :
 * in[]   = {4, 8, 2, 5, 1, 6, 3, 7}
 * post[] = {8, 4, 5, 2, 6, 7, 3, 1}
 * <p>
 * Output : Root of below tree
 * 1
 * /   \
 * 2     3
 * /  \   /   \
 * 4  5   6    7
 * \
 * 8
 */
public class TreeFromInorderPostorderArray {

    class Node {
        public Node right;
        public Node left;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};

//        int in[] = new int[]{2,1,3};
//        int post[] = new int[]{2,3,1};

        Node node = new TreeFromInorderPostorderArray().buildTree(in, post, 0, in.length - 1, 0, post.length - 1);
        System.out.println(node);
    }

    public Node buildTree(int[] inorder, int[] postorder, int inOrderStartindex, int inorderEndIndex, int postOrderStartIndex, int postOrderEndIndex) {

        if(inOrderStartindex < 0 || inorderEndIndex < 0 || postOrderStartIndex < 0 || postOrderEndIndex < 0 || inorderEndIndex < inOrderStartindex){
            return null;
        }

        int currentValue = postorder[postOrderEndIndex];
        int inValueIndex = -1;

        for (int i = inOrderStartindex; i <= inorderEndIndex; i++) {
            if (inorder[i] == currentValue) {
                inValueIndex = i;
                break;
            }
        }

        Node node = new Node(currentValue);

        node.left = buildTree(inorder, postorder, inOrderStartindex, inValueIndex - 1, postOrderStartIndex,(int)Math.ceil((postOrderEndIndex + postOrderStartIndex - 1) / 2 ));
        node.right = buildTree(inorder, postorder, inValueIndex + 1, inorderEndIndex, (int)Math.ceil((postOrderEndIndex + postOrderStartIndex -1 )/ 2 ) + 1 ,postOrderEndIndex - 1);

        return node;
    }

}



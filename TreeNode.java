import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//Definition for a binary tree node.
class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int x) {
    val = x;
  }

  // DFS LNR
  public static void inorderTraversalIt(TreeNode node) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = node;
    while (!stack.empty() || curr != null) {
      if (curr != null) {
        stack.push(curr);
        curr = curr.left;
      } else {
        curr = stack.pop();
        System.out.println(curr.val);
        curr = curr.right;
      }
    }
  }

  // DFS NLR
  public static void preorderTraversalIt(TreeNode node) {
    Stack<TreeNode> stack = new Stack<>();
    stack.push(node);
    TreeNode curr;
    while (!stack.empty()) {
      curr = stack.pop();
      System.out.println(curr.val);
      if (curr.right != null) {
        stack.push(curr.right);
      }
      if (curr.left != null) {
        stack.push(curr.left);
      }
    }
  }

  // DFS LRN
  public static void postorderTraversalIt(TreeNode node) {
    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> result = new Stack<>();
    stack.push(node);
    TreeNode curr;
    while (!stack.empty()) {
      curr = stack.pop();
      result.push(curr.val);
      if (curr.left != null) {
        stack.add(curr.left);
      }
      if (curr.right != null) {
        stack.add(curr.right);
      }
    }
    while (!result.isEmpty()) {
      System.out.println(result.pop());
    }
  }

  // BFS
  public static void bfsTraversal(TreeNode node) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);
    TreeNode curr;
    while (!queue.isEmpty()) {
      curr = queue.poll();
      System.out.print(curr.val + " ");
      if (curr.left != null) {
        queue.add(curr.left);
      }
      if (curr.right != null) {
        queue.add(curr.right);
      }
    }
  }

  //Level Order traversal
  public static void levelOrderTraversal(TreeNode node) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    queue.add(node);
    TreeNode curr;
    int noKids = 0;

    while (!queue.isEmpty()) {
      curr = queue.poll();
      if (curr.left != null) {
        queue.add(curr.left);
      }
      if (curr.right != null) {
        queue.add(curr.right);
      }
    }
  }

  // 2i left node 2i+1 right node
  public static TreeNode getTestData(int[] nums, int index) {
    if (index < nums.length) {
      TreeNode node = new TreeNode(nums[index]);
      node.left = getTestData(nums, 2 * index + 1);
      node.right = getTestData(nums, 2 * index + 2);
      return node;
    }
    return null;
  }

  public static void naviInOrder(TreeNode node) {
    if (node != null) {
      naviInOrder(node.left);
      System.out.println(node.val);
      naviInOrder(node.right);
    }
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode();
    //inorderTraversalIt(getTestData(new int[]{1, 2, 3, 4, 5}, 0));
    //preorderTraversalIt(getTestData(new int[]{1, 2, 3, 4, 5}, 0));
    //postorderTraversalIt(getTestData(new int[]{1, 2, 3, 4, 5}, 0));
    bfsTraversal(getTestData(new int[]{1, 2, 4, 3, 5}, 0));
  }
}

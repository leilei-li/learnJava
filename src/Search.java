import java.util.*;

/**
 * Created by lileilei on 2017/3/23.
 */
public class Search {

    private class Node {
        public Node root;
        public Node leftChild;
        public Node rightChild;
        int data;

        Node(int newData) {
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    private Node CreatBinaryTree(int[] array) {
        LinkedList<Node> nodeList = new LinkedList<Node>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).leftChild = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).rightChild = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
        return nodeList.get(0);
    }

    private void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    private static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    private static void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    public void BinaryTreeSearch(int[] num) {
        Node root = CreatBinaryTree(num);

        System.out.println("先序遍历：");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraverse(root);
    }


    public void OrderSearch(int[] num, int target) {
        int pos = -1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == target) {
                pos = i;
                break;
            }
        }
        System.out.println(pos);
    }

    private int[] initBinarySearch(int[] num) {//采用冒泡排序把无序表变成有序的
        for (int i = 0; i < num.length; i++)
            for (int j = 0; j < num.length; j++) {
                if (num[i] < num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        return num;
    }

    public void BinarySearch(int[] n, int target) {
        int[] num = initBinarySearch(n);
        int low = 0;
        int high = num.length - 1;
        int mid = (low + high) / 2;
        int pos = -1;
        while ((low <= high) && (low <= num.length - 1) && (high <= num.length - 1)) {
            if (num[mid] < target) {
                low = mid + 1;
                mid = (low + high) / 2;
            }
            if (num[mid] > target) {
                high = mid - 1;
                mid = (low + high) / 2;
            }
            if (num[mid] == target) {
                pos = mid;
                break;
            }
        }
        System.out.println(pos);
    }
}

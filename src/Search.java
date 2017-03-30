import java.util.*;

/**
 * Created by lileilei on 2017/3/23.
 */
public class Search {
    private Node root = null;

    private class Node {
        public Node parent = null;
        public Node leftChild = null;
        public Node rightChild = null;
        int key;

        public Node(int data) {
            this.key = data;
        }
    }

    private void buildTree(int[] datas) {
        for (int i = 0; i < datas.length; i++) {
            Node node = new Node(datas[i]);
            insertNode(node);
        }
    }

    private void insertNode(Node node) {    //插入结点
        Node next = this.root;
        Node cur = null;    //用来保存当前结点
        while (next != null) {    //当到达叶子结点时，确认位置！
            cur = next;
            if (node.key >= cur.key) {
                next = next.rightChild;
            } else {
                next = next.leftChild;
            }
        }
        node.parent = cur;    //插入该结点！
        if (cur == null) {
            this.root = node;  //该树为空树，所以这个是根节点
        } else if (node.key >= cur.key) {
            cur.rightChild = node;
        } else {
            cur.leftChild = node;
        }
    }

    private Node searchNode(Node node) {    //private供内部调用，��索结点
        if (node == null) {
            System.out.println("empty input！");
        } else {
            if (root == null) {
                System.out.println("empty tree！");
            } else {                        //开始查找
                boolean isFound = false;
                Node x = root;
                Node y = null;
                while (!isFound && x != null) {    //当查到或者到了叶子节点还没查到时，终结！
                    y = x;
                    if (node.key == x.key) {
                        isFound = true;
                    } else {                    //通过比较大小往下面查找
                        if (node.key > x.key) {
                            x = x.rightChild;
                        } else {
                            x = x.leftChild;
                        }
                    }
                }
                if (isFound) {    //没找到的话，在最后返回null
                    return y;
                }
            }
        }
        return null;
    }

    public void binaryTreeSearch(int[] data, int target) {
        buildTree(data);//建立二叉搜索树
        System.out.println("The number you want to find is " + target);
        Node node;
        if ((node = searchNode(new Node(target))) == null) {
            System.out.println("The num does not exist！");
        } else {
            System.out.println("We find " + node.key + " in this tree successfully！");
        }
    }

    public void orderSearch(int[] num, int target) {
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

    public void binarySearch(int[] n, int target) {
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

package challenge.monthly.october;

import com.sun.source.tree.Tree;

import java.util.Stack;

/*

Design a data structure that accepts integers of a stream,
and checks if it has a pair of integers that sum up to a particular value.

Implement a TwoSum class:

TwoSum() Initializes the TwoSum object, with an empty array initially.
void add(int number) Adds number to the data structure.
boolean find(int value) Returns true if there exists any pair of numbers
whose sum is equal to value, otherwise, it returns false.


Example 1:

Input
["TwoSum", "add", "add", "add", "find", "find"]
[[], [1], [3], [5], [4], [7]]
Output
[null, null, null, null, true, false]

Explanation
TwoSum twoSum = new TwoSum();
twoSum.add(1);   // [] --> [1]
twoSum.add(3);   // [1] --> [1,3]
twoSum.add(5);   // [1,3] --> [1,3,5]
twoSum.find(4);  // 1 + 3 = 4, return True
twoSum.find(7);  // No two integers sum up to 7, return False


Constraints:

-10^5 <= number <= 10^5
-2^31 <= value <= 2^31 - 1
At most 5 * 104 calls will be made to add and find.

* */
public class TwoSumIII_8 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val)
        {
            this.val = val;
            this.left = this.right = null;
        }

    }

    /** Initialize your data structure here. */
    TreeNode root = null;
    public TwoSumIII_8() {

    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(root==null){
            root = new TreeNode(number);
            return;
        }
        root = addUtil(root,number);
    }

    private TreeNode addUtil(TreeNode root, int number) {

        if(root==null)
            return new TreeNode(number);
        else if(root.val==number) {
            TreeNode l = root.left;
            root.left = new TreeNode(number);
            root.left.left = l;
        }
        else if(root.val<number)
            root.right = addUtil(root.right,number);
        else
            root.left = addUtil(root.left,number);
        return root;
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if(root==null)
            return  false;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

       // s1.push(root);
       // s2.push(root);

        TreeNode node1 = root;
        TreeNode node2 = root;

        do{
            while (node1!=null){
                s1.push(node1);
                node1 = node1.left;
            }
            while (node2!=null){
                s2.push(node2);
                node2 = node2.right;
            }
            if(!s1.isEmpty())
                node1 = s1.pop();
            if(!s2.isEmpty())
                node2 = s2.pop();

            if(node1!=node2 && node1!=null && node2!=null){
                if(node1.val+node2.val==value)
                    return true;
                else if(node1.val+node2.val<value){

                    node1 = node1.right;

                    s2.push(node2);
                    node2 = null;
                }else{
                    node2 = node2.left;
                    s1.push(node1);
                    node1 = null;
                }

            }else{
                node1 = null;
                node2 = null;
            }
        }while (!s1.isEmpty() || !s2.isEmpty());

        return false;

    }

    public static void main(String[] args) {
        TwoSumIII_8 ts = new TwoSumIII_8();
        ts.add(40);
        ts.add(20);
        ts.add(60);
        ts.add(10);
        ts.add(25);
        ts.add(50);
        ts.add(70);
        ts.add(55);
        ts.add(56);

        System.out.println(ts.find(68));
        System.out.println(ts.find(96));
    }


}

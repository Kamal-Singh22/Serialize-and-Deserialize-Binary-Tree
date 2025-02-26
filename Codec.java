import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    // Encodes a tree to a single string using BFS.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("null,");
            } else {
                sb.append(curr.val).append(",");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode parent = queue.poll();
            
            // Process left child
            if (!nodes[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = left;
                queue.add(left);
            }
            i++;
            
            // Process right child
            if (i < nodes.length && !nodes[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = right;
                queue.add(right);
            }
            i++;
        }
        
        return root;
    }

    // For testing the Codec
    public static void main(String[] args) {
        Codec codec = new Codec();
        
        // Construct a sample binary tree:
        //     1
        //    / \
        //   2   3
        //      / \
        //     4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        
        // Serialize the tree
        String serialized = codec.serialize(root);
        System.out.println("Serialized Tree: " + serialized);
        
        // Deserialize the string back to tree
        TreeNode deserializedRoot = codec.deserialize(serialized);
        
        // (Optional) Serialize again to verify correctness
        String verifySerialization = codec.serialize(deserializedRoot);
        System.out.println("Verification Serialization: " + verifySerialization);
    }
}

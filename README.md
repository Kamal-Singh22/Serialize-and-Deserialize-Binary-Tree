# Serialize-and-Deserialize-Binary-Tree
Design an algorithm to serialize and deserialize a binary tree. Serialization is the process of converting a tree into a single string, and deserialization is the process of converting that string back into the original tree structure.
Explanation:
TreeNode Class:

Represents nodes of the binary tree with integer values and left/right children.
Serialization (BFS Approach):

We use a queue to perform a level-order traversal (BFS) of the tree.
Each node's value is appended to the string, and "null" is appended for null children.
This results in a comma-separated string that represents the tree.
Deserialization:

Split the string by commas to obtain node values.
Use a queue to reconstruct the tree level-by-level.
For each node, create left and right children if the corresponding values are not "null".
Testing:

The main method constructs a sample tree, serializes it, and then deserializes it back to verify the correctness

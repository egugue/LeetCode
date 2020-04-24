package com.htoyama.leetcode._297;

import com.htoyama.leetcode.utils.Level;
import com.htoyama.leetcode.utils.Tree;
import com.htoyama.leetcode.utils.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
@Level.Hard
@Tree
class Main {
  public static void main(String[] args) {
    Codec codec = new Codec();
    TreeNode n;
    String s;

    s = "[]";
    n = codec.deserialize(s);
    assertThat(codec.serialize(n)).isEqualTo(s);

    s = "[1,2,3,null,null,4,5]";
    n = codec.deserialize(s);
    assertThat(codec.serialize(n)).isEqualTo(s);

    s = "[5,4,7,3,null,2,null,-1,null,9]";
    n = codec.deserialize(s);
    assertThat(codec.serialize(n)).isEqualTo(s);
  }
}

/**
 * 10 ms	40.7 MB
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) return "[]";
    ArrayDeque<Item> queue = new ArrayDeque<>();
    queue.add(new Item(root));

    ArrayList<Item> items = new ArrayList<>();
    while (!queue.isEmpty()) {
      ArrayList<TreeNode> levelList = new ArrayList<>(queue.size());

      while (!queue.isEmpty()) {
        Item item = queue.poll();
        items.add(item);

        TreeNode node = item.node;
        if (node == null) continue;
        levelList.add(node);
      }

      for (TreeNode node : levelList) {
        queue.add(new Item(node.left));
        queue.add(new Item(node.right));
      }
    }

    int lastNonNullIndex = 0;
    for (int i = 0; i < items.size(); i++) {
      if (items.get(i).node != null) lastNonNullIndex = i;
    }

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i <= lastNonNullIndex; i++) {
      TreeNode node = items.get(i).node;
      sb.append(node == null ? "null" : String.valueOf(node.val))
        .append(",");
    }
    sb.setLength(sb.length() - 1);
    sb.append("]");

    return sb.toString();
  }

  static class Item {
    final TreeNode node;

    Item(TreeNode node) {
      this.node = node;
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.equals("[]")) return null;
    String[] split = data.substring(1, data.length() - 1).split(",");
    if (split.length == 0) return null;

    TreeNode head = new TreeNode(Integer.parseInt(split[0]));
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.add(head);

    int i = 0;
    while (++i < split.length && !queue.isEmpty()) {
      TreeNode left = null;
      TreeNode right = null;
      if (!split[i].equals("null")) {
        left = new TreeNode(Integer.parseInt(split[i]));
        queue.add(left);
      }
      if (++i < split.length && !split[i].equals("null")) {
        right = new TreeNode(Integer.parseInt(split[i]));
        queue.add(right);
      }

      TreeNode node = queue.poll();
      node.left = left;
      node.right = right;
    }

    return head;
  }
}
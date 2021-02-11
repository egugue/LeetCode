struct Solution;

use crate::shared::tree_node::TreeNode;
use std::cell::RefCell;
use std::rc::Rc;

/// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
impl Solution {
    pub fn level_order_bottom(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Vec<i32>> {
        // Solution::bfs_iterative(root)
        Solution::dfs_recursive(root)
    }

    /// 0 ms	2.2 MB
    fn bfs_iterative(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Vec<i32>> {
        if root.is_none() {
            return vec![];
        }

        let root = root.unwrap();
        let mut result = vec![];

        let mut current_nodes = vec![];
        current_nodes.push(root);
        while !current_nodes.is_empty() {
            let values = current_nodes
                .iter()
                .map(|x| x.borrow().val)
                .collect::<Vec<_>>();
            result.push(values);

            let mut next_nodes = vec![];
            for node in current_nodes {
                let node = (*node).replace(TreeNode::new(0));
                if let Some(left) = node.left {
                    next_nodes.push(left);
                }
                if let Some(right) = node.right {
                    next_nodes.push(right);
                }
            }

            current_nodes = next_nodes;
        }

        result.reverse();
        result
    }

    /// 0 ms	2.3 MB
    fn dfs_recursive(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Vec<i32>> {
        fn helper(node: Option<Rc<RefCell<TreeNode>>>, level: usize, result: &mut Vec<Vec<i32>>) {
            if node.is_none() {
                return;
            }

            let node = (*node.unwrap()).replace(TreeNode::new(0));
            if let Some(vec) = result.get_mut(level - 1) {
                vec.push(node.val)
            } else {
                let vec = vec![node.val];
                result.push(vec);
            }

            let next = level + 1;
            helper(node.left, next, result);
            helper(node.right, next, result);
        }

        let mut result = vec![];
        helper(root, 1, &mut result);
        result.reverse();
        result
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use rstest::rstest;

    #[rstest(root, expected,
    case(
        "[]",
        vec![]
    ),
    case(
        "[3,9,20,null,null,15,7]",
         vec![
            vec![15,7],
            vec![9,20],
            vec![3]
        ]),
    )]
    fn bfs_iterative(root: &str, expected: Vec<Vec<i32>>) {
        assert_eq!(
            Solution::bfs_iterative(TreeNode::from_str_and_wrap(root)),
            expected
        );
    }

    #[rstest(root, expected,
    case(
        "[]",
        vec![]
    ),
    case(
        "[3,9,20,null,null,15,7]", 
        vec![
            vec![15,7],
            vec![9,20],
            vec![3]
        ]),
    )]
    fn dfs_recursive(root: &str, expected: Vec<Vec<i32>>) {
        assert_eq!(
            Solution::dfs_recursive(TreeNode::from_str_and_wrap(root)),
            expected
        );
    }
}

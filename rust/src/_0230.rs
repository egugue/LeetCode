use crate::shared::tree_node::TreeNode;
use std::cell::RefCell;
use std::rc::Rc;

struct Solution;

/// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
impl Solution {
    /// 0 ms	3.1 MB
    pub fn kth_smallest(root: Option<Rc<RefCell<TreeNode>>>, k: i32) -> i32 {
        fn helper(node: &Rc<RefCell<TreeNode>>, k: i32, index: i32) -> Result<i32, (i32, i32)> {
            let node = node.borrow();
            let left_result = if let Some(left) = node.left.as_ref() {
                helper(left, k, index)
            } else {
                Err((k, index))
            };
            if left_result.is_ok() {
                return left_result;
            }

            let (k, mut index) = left_result.unwrap_err();
            if k == index {
                return Ok(node.val);
            }
            index += 1;

            if let Some(right) = node.right.as_ref() {
                helper(right, k, index)
            } else {
                Err((k, index))
            }
        }

        let root = root.as_ref().unwrap();
        match helper(root, k, 1) {
            Ok(index) => index,
            Err(_) => panic!()
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test() {
        assert_eq!(
            Solution::kth_smallest(TreeNode::from_str_and_wrap("[3,1,4,null,2]"), 1),
            1
        );
        assert_eq!(
            Solution::kth_smallest(TreeNode::from_str_and_wrap("[5,3,6,2,4,null,null,1]"), 3),
            3
        );
        assert_eq!(
            Solution::kth_smallest(TreeNode::from_str_and_wrap("[4,2,5,null,3]"), 1),
            2
        );
    }
}

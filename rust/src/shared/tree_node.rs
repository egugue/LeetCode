use std::cell::RefCell;
use std::collections::VecDeque;
use std::rc::Rc;
use Value::{Null, V};

#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    pub fn wrap(self) -> Option<Rc<RefCell<TreeNode>>> {
        Some(Rc::new(RefCell::new(self)))
    }

    #[inline]
    pub fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }

    /// https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation-
    pub fn from_array(array: &[Value]) -> TreeNode {
        assert!(!array.is_empty());
        let head = match array[0] {
            V(value) => TreeNode::new(value),
            Null => panic!("first is Null"),
        };

        let head = Rc::new(RefCell::new(head));
        let mut nodes = VecDeque::new();
        nodes.push_front(Rc::clone(&head));
        let mut i = 0;
        while !nodes.is_empty() {
            let node_rc = nodes.pop_back().unwrap();

            i += 1;
            match array.get(i) {
                Some(V(value)) => {
                    let value = *value;
                    let left = Rc::new(RefCell::new(TreeNode::new(value)));
                    nodes.push_front(Rc::clone(&left));
                    (*node_rc).borrow_mut().left = Some(left);
                }
                Some(Null) => {}
                None => break,
            }

            i += 1;
            match array.get(i) {
                Some(V(value)) => {
                    let value = *value;
                    let right = Rc::new(RefCell::new(TreeNode::new(value)));
                    nodes.push_front(Rc::clone(&right));
                    (*node_rc).borrow_mut().right = Some(right);
                }
                Some(Null) => {}
                None => break,
            }
        }

        head.replace(TreeNode::new(0))
    }

    pub fn from_array_and_wrap(array: &[Value]) -> Option<Rc<RefCell<TreeNode>>> {
        if array.is_empty() {
            None
        } else {
            Some(Rc::new(RefCell::new(TreeNode::from_array(array))))
        }
    }
}

pub enum Value {
    V(i32),
    Null,
}

#[cfg(test)]
mod tests {
    use super::Value::{Null, V};
    use super::*;

    #[test]
    fn tree_node_from_array() {
        // https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation-
        assert_eq!(
            TreeNode::from_array(&[V(1)]),
            TreeNode {
                val: 1,
                left: None,
                right: None,
            }
        );

        assert_eq!(
            TreeNode::from_array(&[V(1), V(2), V(3)]),
            TreeNode {
                val: 1,
                left: TreeNode::new(2).wrap(),
                right: TreeNode::new(3).wrap(),
            }
        );

        assert_eq!(
            TreeNode::from_array(&[V(1), Null, V(2), V(3)]),
            TreeNode {
                val: 1,
                left: None,
                right: TreeNode {
                    val: 2,
                    left: TreeNode::new(3).wrap(),
                    right: None
                }
                .wrap(),
            }
        );

        assert_eq!(
            TreeNode::from_array(&[V(5), V(4), V(7), V(3), Null, V(2), Null, V(-1), Null, V(9)]),
            TreeNode {
                val: 5,
                left: TreeNode {
                    val: 4,
                    left: TreeNode {
                        val: 3,
                        left: TreeNode::new(-1).wrap(),
                        right: None
                    }
                    .wrap(),
                    right: None
                }
                .wrap(),
                right: TreeNode {
                    val: 7,
                    left: TreeNode {
                        val: 2,
                        left: TreeNode::new(9).wrap(),
                        right: None
                    }
                    .wrap(),
                    right: None
                }
                .wrap()
            }
        );

        // ref: https://leetcode.com/problems/binary-tree-level-order-traversal/
        assert_eq!(
            TreeNode::from_array(&[V(3), V(9), V(20), Null, Null, V(15), V(7)]),
            TreeNode {
                val: 3,
                left: TreeNode::new(9).wrap(),
                right: TreeNode {
                    val: 20,
                    left: TreeNode::new(15).wrap(),
                    right: TreeNode::new(7).wrap(),
                }
                .wrap()
            }
        );
    }

    #[test]
    fn tree_node_from_array_and_wrap() {
        assert_eq!(TreeNode::from_array_and_wrap(&[]), None);
        assert_eq!(
            TreeNode::from_array_and_wrap(&[V(1)]),
            TreeNode::new(1).wrap()
        )
    }
}

use std::borrow::Borrow;
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
        let mut queue = VecDeque::new();
        queue.push_front(Rc::clone(&head));

        for chunk in array[1..].chunks(2) {
            let node_rc = queue.pop_back().unwrap();

            if let V(value) = chunk[0] {
                let left = Rc::new(RefCell::new(TreeNode::new(value)));
                queue.push_front(Rc::clone(&left));
                (*node_rc).borrow_mut().left = Some(left);
            }

            if let Some(V(value)) = chunk.get(1) {
                let right = Rc::new(RefCell::new(TreeNode::new(*value)));
                queue.push_front(Rc::clone(&right));
                (*node_rc).borrow_mut().right = Some(right);
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

    pub fn from_str_and_wrap(str: &str) -> Option<Rc<RefCell<TreeNode>>> {
        TreeNode::from_array_and_wrap(Value::array_from(str).borrow())
    }
}

#[derive(Debug, Eq, PartialEq)]
pub enum Value {
    V(i32),
    Null,
}

impl Value {
    pub fn from(str: &str) -> Value {
        if str == "null" {
            Null
        } else {
            let value = str.parse::<i32>().unwrap();
            V(value)
        }
    }

    /// "[1, null, 3]" -> vec!(V(1), Null, V[3])
    pub fn array_from(str: &str) -> Vec<Value> {
        if !str.starts_with('[') || !str.ends_with(']') {
            panic!("invalid format: {}", str);
        }

        let str = &str[1..str.len() - 1];
        if str.is_empty() {
            vec![]
        } else {
            str.split(',')
                .map(|s| Value::from(s.trim()))
                .collect::<Vec<_>>()
        }
    }
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
                left: w(TreeNode::new(2)),
                right: w(TreeNode::new(3)),
            }
        );

        assert_eq!(
            TreeNode::from_array(&[V(1), Null, V(2), V(3)]),
            TreeNode {
                val: 1,
                left: None,
                right: w(TreeNode {
                    val: 2,
                    left: w(TreeNode::new(3)),
                    right: None
                }),
            }
        );

        assert_eq!(
            TreeNode::from_array(&[V(5), V(4), V(7), V(3), Null, V(2), Null, V(-1), Null, V(9)]),
            TreeNode {
                val: 5,
                left: w(TreeNode {
                    val: 4,
                    left: w(TreeNode {
                        val: 3,
                        left: w(TreeNode::new(-1)),
                        right: None
                    }),
                    right: None
                }),
                right: w(TreeNode {
                    val: 7,
                    left: w(TreeNode {
                        val: 2,
                        left: w(TreeNode::new(9)),
                        right: None
                    }),
                    right: None
                }),
            }
        );

        // ref: https://leetcode.com/problems/binary-tree-level-order-traversal/
        assert_eq!(
            TreeNode::from_array(&[V(3), V(9), V(20), Null, Null, V(15), V(7)]),
            TreeNode {
                val: 3,
                left: w(TreeNode::new(9)),
                right: w(TreeNode {
                    val: 20,
                    left: w(TreeNode::new(15)),
                    right: w(TreeNode::new(7)),
                })
            }
        );
    }

    #[test]
    fn tree_node_from_array_and_wrap() {
        assert_eq!(TreeNode::from_array_and_wrap(&[]), None);
        assert_eq!(TreeNode::from_array_and_wrap(&[V(1)]), w(TreeNode::new(1)))
    }

    #[test]
    fn tree_node_from_str_and_wrap() {
        assert_eq!(TreeNode::from_str_and_wrap("[]"), None);
        assert_eq!(
            TreeNode::from_str_and_wrap("[1,null,3]"),
            w(TreeNode {
                val: 1,
                left: None,
                right: w(TreeNode::new(3)),
            })
        )
    }

    #[test]
    fn value_array_from() {
        assert_eq!(Value::array_from("[]"), Vec::new());
        assert_eq!(
            Value::array_from("[1, 2, null, -1]"),
            vec![V(1), V(2), Null, V(-1)]
        );
        assert_eq!(
            Value::array_from("[1,2,null,-1]"),
            vec![V(1), V(2), Null, V(-1)]
        );
    }

    // means to wrap
    fn w(node: TreeNode) -> Option<Rc<RefCell<TreeNode>>> {
        Some(Rc::new(RefCell::new(node)))
    }
}

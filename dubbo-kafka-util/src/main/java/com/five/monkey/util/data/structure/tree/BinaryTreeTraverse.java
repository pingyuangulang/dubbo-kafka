package com.five.monkey.util.data.structure.tree;

import com.five.monkey.util.data.structure.exception.TreeEmptyException;
import com.five.monkey.util.data.structure.link.Queue;
import com.five.monkey.util.data.structure.link.Stack;

import java.util.Objects;

/**
 * 二叉树遍历
 *
 * @author jim
 * @date 2020/8/27 15:27
 */
public class BinaryTreeTraverse<E> {

    /**
     * 二叉树先序遍历
     *
     * @param root 二叉树根结点
     */
    public void preOrder(TreeNode<E> root) {
        this.notNull(root);
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> node = root;
        while (Objects.nonNull(node) || stack.isNotEmpty()) {
            while (Objects.nonNull(node)) {
                System.out.println(node.getData());
                stack.push(node);
                node = node.getLeft();
            }
            if (stack.isNotEmpty()) {
                node = stack.pop().getRight();
            }
        }
    }

    /**
     * 二叉树中序遍历
     *
     * @param root 二叉树根结点
     */
    public void middleOrder(TreeNode<E> root) {
        this.notNull(root);
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> node = root;
    }

    private void notNull(TreeNode<E> root) {
        if (Objects.isNull(root)) {
            throw new TreeEmptyException();
        }
    }
}

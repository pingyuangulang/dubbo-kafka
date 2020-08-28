package com.five.monkey.util.data.structure.tree;

/**
 * 树结点
 *
 * @author jim
 * @date 2020/8/27 15:01
 */
public class TreeNode<E> {

    /** 数据域 */
    private E data;

    /** 左孩子 */
    private TreeNode<E> left;

    /** 右孩子 */
    private TreeNode<E> right;

    public TreeNode() {
        this(null);
    }

    public TreeNode(E data) {
        this(data, null, null);
    }

    public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }
}

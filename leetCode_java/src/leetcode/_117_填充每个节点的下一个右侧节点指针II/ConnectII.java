package leetcode._117_填充每个节点的下一个右侧节点指针II;

import leetcode.Node;

import java.util.ArrayList;

public class ConnectII {
    public Node connect(Node root) {
        connect(root,new ArrayList<>(),0);
        return root;
    }
    public void connect(Node root, ArrayList<Node>levelList, int level){
        if (root==null){
            return;
        }
        if (levelList.size()==level){
            levelList.add(root);
        }else {
            levelList.get(level).next=root;
            levelList.set(level,root);
        }
        connect(root.left,levelList,level+1);
        connect(root.right,levelList,level+1);
    }
}

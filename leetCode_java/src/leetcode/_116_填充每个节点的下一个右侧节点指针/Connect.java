package leetcode._116_填充每个节点的下一个右侧节点指针;


import leetcode.Node;

public class Connect {
    public Node connect(Node root) {
        connect(root,new Node[12],0);
        return root;
    }
    public void connect(Node root,Node []levelArray,int level){
        if (root==null){
            return;
        }
        if (levelArray[level]!=null){
            levelArray[level].next=root;
        }
        levelArray[level]=root;
        connect(root.left,levelArray,level+1);
        connect(root.right,levelArray,level+1);
    }

    public static void main(String[] args) {
        Connect connect = new Connect();
        Node node = new Node(1);


    }
}


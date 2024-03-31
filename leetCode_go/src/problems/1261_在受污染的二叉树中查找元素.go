package problems

import "fmt"

type FindElements struct {
	root *TreeNode
}

func Constructor(root *TreeNode) FindElements {
	var dfs func(node *TreeNode, x int)
	dfs = func(node *TreeNode, x int) {
		if node == nil {
			return
		}
		node.Val = x
		dfs(node.Left, x*2+1)
		dfs(node.Right, x*2+2)
	}
	dfs(root, 0)
	return FindElements{
		root: root,
	}
}

func (this *FindElements) Find(target int) bool {
	bs := fmt.Sprintf("%b", target+1)
	fmt.Println(bs)
	for t, p := this.root, 1; t != nil; p++ {
		if t.Val == target {
			return true
		}
		if p < len(bs) {
			if bs[p] == '0' {
				t = t.Left
			} else {
				t = t.Right
			}
		}
	}
	return false
}

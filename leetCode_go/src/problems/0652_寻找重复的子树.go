package problems

import (
	"fmt"
	"strconv"
)

func FindDuplicateSubtrees(root *TreeNode) []*TreeNode {
	return findDuplicateSubtrees(root)
}

func findDuplicateSubtrees(root *TreeNode) []*TreeNode {
	results := map[string]*TreeNode{}
	memMap := map[string]string{}
	var dfsSearch func(*TreeNode) string

	dfsSearch = func(root *TreeNode) string {
		if root == nil {
			return "_"
		}

		ustr := fmt.Sprintf("%d,%s,%s", root.Val, dfsSearch(root.Left), dfsSearch(root.Right))
		if _, ok := memMap[ustr]; !ok {
			memMap[ustr] = strconv.Itoa(len(memMap))
		} else {
			results[ustr] = root
		}
		result, _ := memMap[ustr]
		return result
	}
	dfsSearch(root)
	result := make([]*TreeNode, 0)
	for _, v := range results {
		result = append(result, v)
	}
	return result
}

//暴力超时
func findDuplicateSubtrees_timeout(root *TreeNode) []*TreeNode {
	results := map[*TreeNode]bool{}
	memMap := map[int][]*TreeNode{}
	var dfsSearch func(*TreeNode)
	var isSame func(*TreeNode, *TreeNode) bool
	isSame = func(r1, r2 *TreeNode) bool {
		if r1 == r2 {
			return true
		} else if r1 == nil || r2 == nil {
			return false
		} else if r1.Val == r2.Val {
			return isSame(r1.Left, r2.Left) && isSame(r1.Right, r2.Right)
		} else {
			return false
		}
	}
	dfsSearch = func(root *TreeNode) {
		if root == nil {
			return
		}
		if memMap[root.Val] == nil {
			memMap[root.Val] = make([]*TreeNode, 0)
		}
		appended := false
		if memMap[root.Val] != nil {
			for _, troot := range memMap[root.Val] {
				if isSame(troot, root) {
					results[troot] = true
					appended = true
				}
			}
		}
		if !appended {
			memMap[root.Val] = append(memMap[root.Val], root)

		}
		dfsSearch(root.Left)
		dfsSearch(root.Right)

	}
	dfsSearch(root)
	keys := make([]*TreeNode, 0, len(results))
	for tn := range results {
		keys = append(keys, tn)
	}

	return keys
}

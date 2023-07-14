package problems

import (
	"fmt"
)

func BtreeGameWinningMove(root *TreeNode, n int, x int) bool {
	return btreeGameWinningMove(root, n, x)
}

func btreeGameWinningMove(root *TreeNode, n int, x int) bool {
	//贪心，判定
	//统计节点数量
	var countNode func(*TreeNode) int
	countNode = func(r *TreeNode) int {
		if r == nil {
			return 0
		} else {
			return countNode(r.Left) + countNode(r.Right) + 1
		}
	}
	var findNode func(r *TreeNode) *TreeNode
	findNode = func(r *TreeNode) *TreeNode {
		if r == nil {
			return nil
		} else if r.Val == x {
			return r
		}

		ln := findNode(r.Left)
		if ln == nil {
			return findNode(r.Right)
		} else {
			return ln
		}
	}
	redNode := findNode(root)
	left, right := countNode(redNode.Left), countNode(redNode.Right)
	parent := n - 1 - right - left
	//存在一个数字大于总数一半即可
	if parent > n/2 || left > n/2 || right > n/2 {
		return true
	}
	return false
}

// 写成完全二叉树的dfs了。。。
func btreeGameWinningMove_error(root *TreeNode, n int, x int) bool {
	treeArr := translateTree2List(root, n)
	dyedArr := make([]int, n)
	for idx, number := range treeArr {
		if number == x {
			dyedArr[idx] = 1
		}
	}

	fmt.Println(dyedArr)
	//当前位置是否能染色
	canDye := func(arr []int, index int, color int) bool {
		//当前索引未染色且其临近位置同色 父 左右孩子
		if arr[index] == 0 {
			switch {
			case arr[(index-1)/2] == color:
				return true
			case index*2+1 < len(arr) && arr[index*2+1] == color:
				return true
			case index*2+2 < len(arr) && arr[index*2+2] == color:
				return true
			}
		}
		return false
	}
	var dyeColor func([]int, int, int) bool
	dyeColor = func(colorArr []int, color, dyedCount int) bool {
		//切片复制
		tpArr := make([]int, len(colorArr))
		copy(tpArr, colorArr)
		colorArr = tpArr
		if dyedCount == len(colorArr) {
			count := 0
			for _, num := range colorArr {
				count += num
			}
			return count < 0
		}
		result, dyed := true, false
		//尝试染色
		for index := range colorArr {
			//判定与剪枝
			if result && canDye(colorArr, index, color) {
				colorArr[index] = color
				dyed = true
				result = result && dyeColor(colorArr, -1*color, dyedCount+1)
				colorArr[index] = 0
			}
		}
		//染色失败，让对方染色
		if !dyed && result {
			for idx := range colorArr {
				if colorArr[idx] == 0 {
					colorArr[idx] = -1 * color
				}
			}
			result = result && dyeColor(colorArr, -1*color, len(colorArr))
		}

		return result
	}
	for idx, number := range treeArr {
		if number != x {
			dyedArr[idx] = -1
			if dyeColor(dyedArr, 1, 2) {
				return true
			}
			// fmt.Println(dyedArr)
			// fmt.Printf("dyeArr(treeArr, 1, true): %v\n", dyeColor(dyedArr, 1, 2))
			dyedArr[idx] = 0
		}
	}

	return false
}

func translateTree2List(root *TreeNode, lenth int) []int {
	result := make([]int, lenth)

	var walkTree func(*TreeNode, int)
	walkTree = func(treeroot *TreeNode, index int) {
		if treeroot == nil {
			return
		}
		result[index] = treeroot.Val
		walkTree(treeroot.Left, index*2+1)
		walkTree(treeroot.Right, index*2+2)
	}
	walkTree(root, 0)
	return result
}

package problems

import (
	"fmt"
	"sort"
	"strconv"
	"strings"
)

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type Codec struct {
}

func ConstructorTree() Codec {
	return Codec{}
}
func (this *Codec) Serialize(root *TreeNode) string {
	return this.serialize(root)
}
func (this *Codec) Deserialize(data string) *TreeNode {
	return this.deserialize(data)
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
	result := make([]int, 0)
	var dfs func(node *TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		result = append(result, node.Val)
		dfs(node.Left)
		dfs(node.Right)
	}
	dfs(root)
	return fmt.Sprintf("%v", result)
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	if len(data) < 3 {
		return nil
	}
	sArr := strings.Split(data[1:len(data)-1], " ")
	iArr := make([]int, 0, len(sArr))
	iArr2 := make([]int, 0, len(sArr))
	for _, sn := range sArr {
		in, _ := strconv.Atoi(sn)
		iArr = append(iArr, in)
		iArr2 = append(iArr2, in)
	}
	sort.Ints(iArr2)
	idx := 0
	var buildTree func(arr []int) *TreeNode
	buildTree = func(arr []int) *TreeNode {
		if len(arr) == 0 {
			return nil
		}
		var splitIdx int
		for i := 0; i < len(arr); i++ {
			if iArr[idx] == arr[i] {
				splitIdx = i
				break
			}
		}
		val := iArr[idx]
		idx++
		return &TreeNode{
			Val:   val,
			Left:  buildTree(arr[0:splitIdx]),
			Right: buildTree(arr[splitIdx+1:]),
		}
	}
	return buildTree(iArr2)
}

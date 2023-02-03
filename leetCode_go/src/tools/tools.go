package tools

import (
	"fmt"
	"src/problems"
	"strconv"
	"strings"
)

func ParseArr(str string) [][]int {
	var result = make([][]int, 0)
	if len(str) == 2 {
		return result
	}
	str = strings.TrimSpace(str)
	str = strings.TrimLeft(str, "[[")
	str = strings.TrimRight(str, "]]")
	split := strings.Split(str, "],[")
	for _, instr := range split {
		numArr := strings.Split(instr, ",")
		inArr := make([]int, 0)
		for _, v := range numArr {
			val, err := strconv.Atoi(v)
			if err != nil {
				println(numArr)
				println("转换失败")
			} else {
				inArr = append(inArr, val)
			}
		}
		result = append(result, inArr)
	}
	return result
}

func ParseTree(treeStr string) *problems.TreeNode {
	TreeArr := make([]*problems.TreeNode, 0)
	TreeArr = append(TreeArr, &problems.TreeNode{})
	treeStr = strings.TrimSpace(treeStr)[1 : len(treeStr)-1]
	fmt.Println(treeStr)
	strs := strings.Split(treeStr, ",")
	for index, strn := range strs {
		// fmt.Println(index, strn)
		// fmt.Println(TreeArr)
		num, err := strconv.Atoi(strings.TrimSpace(strn))
		TreeArr = append(TreeArr)
		if err == nil {
			node := &problems.TreeNode{Val: num}
			TreeArr = append(TreeArr, node)
			if index%2 == 0 {
				TreeArr[(index+1)/2].Right = node
			} else {
				TreeArr[(index+1)/2].Left = node
			}
		} else {
			TreeArr = append(TreeArr, nil)
		}

	}
	fmt.Println(TreeArr)
	return TreeArr[1]
}

func ShowArray(arr [][]int) {
	for i := 0; i < len(arr); i++ {
		for j := 0; j < len(arr[i]); j++ {
			print(arr[i][j], " ")
		}
		println()
	}
}
func ShowRuneArray(arr [][]rune) {
	for i := 0; i < len(arr); i++ {
		for j := 0; j < len(arr[i]); j++ {
			fmt.Printf("%c\t", arr[i][j])
		}
		println()
	}
}

func ShowTree(root *problems.TreeNode) {
	if root == nil {
		print("null ")
	} else {
		ShowTree(root.Left)
		print(root.Val, " ")
		ShowTree(root.Right)
	}
}

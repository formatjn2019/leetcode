package problems

import "fmt"

func CountHighestScoreNodes(parents []int) int {
	return countHighestScoreNodes(parents)
}

func countHighestScoreNodes(parents []int) int {
	lenth := len(parents)
	treeChildrens := make([][]int, lenth)
	for index, parent := range parents {
		if parent > -1 {
			treeChildrens[parent] = append(treeChildrens[parent], index)
		}
	}
	fmt.Println(treeChildrens)
	max := 0
	count := 0
	var dfsSearch func(int) int
	dfsSearch = func(index int) int {
		//节点的数
		current := 1
		result := 1
		for _, child := range treeChildrens[index] {
			num := dfsSearch(child)
			result *= num
			current += num
		}
		if lenth-current > 0 {
			result *= lenth - current
		}
		if result > max {
			count = 1
			max = result
		} else if result == max {
			count++
		}
		return current
	}
	dfsSearch(0)
	println(count)
	return count
}
func countHighestScoreNodes_timeout(parents []int) int {
	lenth := len(parents)
	countParent := make([]int, lenth)
	treeLeft := make([]int, lenth)
	treeRight := make([]int, lenth)
	for i := 0; i < lenth; i++ {
		treeRight[i] = -1
		treeLeft[i] = -1
	}
	for index, parent := range parents {
		if parent > -1 {
			if treeLeft[parent] > -1 {
				treeRight[parent] = index
			} else {
				treeLeft[parent] = index
			}
		}
		for parent > -1 {
			countParent[parent]++
			parent = parents[parent]
		}
	}
	resultMap := map[int]int{}
	result := 0
	for i := 0; i < lenth; i++ {
		//去掉
		//(总数 - 当前节点)*左子节点* 右子节点
		up := 1
		if lenth-countParent[i]-1 > 1 {
			up = lenth - countParent[i] - 1
		}
		left := 1
		if treeLeft[i] > -1 {
			left = countParent[treeLeft[i]] + 1
		}
		right := 1
		if treeRight[i] > -1 {
			right = countParent[treeRight[i]] + 1
		}
		temp := up * left * right
		num, _ := resultMap[temp]
		resultMap[temp] = num + 1
		if temp > result {
			result = temp
		}
	}
	return resultMap[result]
}

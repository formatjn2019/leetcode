package problems

func reachableNodes(n int, edges [][]int, restricted []int) int {
	nodeList := make([]int, n)
	for i := 0; i < n; i++ {
		nodeList[i] = i
	}

	var findAndMerge func(idx int) int
	findAndMerge = func(idx int) int {
		if nodeList[idx] == idx {
			return idx
		} else {
			nodeList[idx] = findAndMerge(nodeList[idx])
			return nodeList[idx]
		}
	}

	rejectSet := map[int]bool{}

	for _, nd := range restricted {
		rejectSet[nd] = true
	}

	for _, edge := range edges {
		if !(rejectSet[edge[0]] || rejectSet[edge[1]]) {
			nodeList[findAndMerge(edge[0])] = findAndMerge(edge[1])
		}
	}
	var result int
	st := findAndMerge(0)
	for i := 0; i < n; i++ {
		if findAndMerge(i) == st {
			result++
		}
	}
	return result
}

func reachableNodes_timeout(n int, edges [][]int, restricted []int) int {
	nodeList := make([]int, n)
	for i := 0; i < n; i++ {
		nodeList[i] = i
	}
	var find func(x int) int
	find = func(x int) int {
		if nodeList[x] == x {
			return x
		}
		return find(nodeList[x])
	}
	var merge func(x, y int) int
	merge = func(x, y int) int {
		ltry := find(y)
		if find(x) != ltry {
			nodeList[x] = ltry
			nodeList[find(x)] = ltry
		}
		return find(y)
	}

	rejectSet := map[int]bool{}

	for _, nd := range restricted {
		rejectSet[nd] = true
	}

	for _, edge := range edges {
		if !(rejectSet[edge[0]] || rejectSet[edge[1]]) {
			merge(edge[0], edge[1])
		}
	}
	var result int
	st := find(0)
	for i := 0; i < n; i++ {
		if find(i) == st {
			result++
		}
	}
	return result
}

package problems

func CountComponents(n int, edges [][]int) int {
	return countComponents(n, edges)
}
func countComponents(n int, edges [][]int) int {
	pArr := make([]int, n)
	for i := 0; i < n; i++ {
		pArr[i] = i
	}
	var findAndMerge func(idx int) int
	findAndMerge = func(idx int) int {
		if pArr[idx] == idx {
			return idx
		} else {
			pArr[idx] = findAndMerge(pArr[idx])
			return pArr[idx]
		}
	}
	for _, edge := range edges {
		pArr[findAndMerge(edge[0])] = findAndMerge(edge[1])
	}
	countMap := map[int]int{}
	for _, p := range pArr {
		if p == pArr[p] {
			countMap[p]++
		}
	}
	return len(countMap)
}

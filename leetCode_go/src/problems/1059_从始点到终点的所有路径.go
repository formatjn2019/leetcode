package problems

func LeadsToDestination(n int, edges [][]int, source int, destination int) bool {
	return leadsToDestination(n, edges, source, destination)
}
func leadsToDestination(n int, edges [][]int, source int, destination int) bool {
	degMap := map[int]map[int]bool{}
	for _, edge := range edges {
		if edge[0] == edge[1] {
			return false
		}
		if _, ok := degMap[edge[0]]; !ok {
			degMap[edge[0]] = map[int]bool{}
		}
		degMap[edge[0]][edge[1]] = true
	}
	var result, search int
	var dfs func(src, dest, depth int, walked ...int)
	dfs = func(src, dest, depth int, walked ...int) {
		for _, wk := range walked {
			if wk == src {
				return
			}
		}
		if src == dest {
			search += depth
			return
		}
		for start := range degMap[src] {
			result++
			dfs(start, dest, depth+1, append(walked, src)...)
		}
	}
	dfs(source, destination, 0)
	return search > 0 && result <= search
}

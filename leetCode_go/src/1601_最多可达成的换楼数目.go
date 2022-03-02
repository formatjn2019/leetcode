package main

func maximumRequests(n int, requests [][]int) int {
	result := 0
	dfsSearch(0, 0, requests, make([]int, n), &result)
	return result
}

func dfsSearch(count, depth int, requests [][]int, buildings []int, result *int) {
	if depth == len(requests) {
		if *result < count {
			for _, v := range buildings {
				if v != 0 {
					return
				}
			}
			*result = count
		}
		return
	}
	//剪枝
	if *result > count+(len(requests)-depth) {
		return
	}

	//选中
	from, to := requests[depth][0], requests[depth][1]
	if from == to {
		dfsSearch(count+1, depth+1, requests, buildings, result)
	} else {
		buildings[from]--
		buildings[to]++
		dfsSearch(count+1, depth+1, requests, buildings, result)
		//重置
		buildings[from]++
		buildings[to]--
		dfsSearch(count, depth+1, requests, buildings, result)
	}

}

//func main() {
//
//	//maximumRequests(5, [][]int{{0, 1}, {1, 0}, {1, 2}, {0, 1}, {2, 0}, {3, 4}})
//	//	4
//	//[[3,0],[2,2],[3,0],[0,1],[1,2],[0,0],[3,2],[1,2]]
//	requests := maximumRequests(4, tools.ParseArr("[[3,0],[2,2],[3,0],[0,1],[1,2],[0,0],[3,2],[1,2]]"))
//	println(requests)
//}

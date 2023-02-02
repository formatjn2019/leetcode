package problems

func ShortestAlternatingPaths(n int, redEdges [][]int, blueEdges [][]int) []int {
	return shortestAlternatingPaths(n, redEdges, blueEdges)
}

func shortestAlternatingPaths(n int, redEdges [][]int, blueEdges [][]int) []int {
	// fmt.Println(redEdges, blueEdges)
	//矩阵预处理
	edgesMap := make(map[int][]int)
	for _, arr := range redEdges {
		edgesMap[arr[0]+1] = append(edgesMap[arr[0]+1], arr[1])
	}
	for _, arr := range blueEdges {
		edgesMap[-1*(arr[0]+1)] = append(edgesMap[-1*(arr[0]+1)], arr[1])
	}
	// fmt.Println(edgesMap)
	result := make([]int, n)
	for i := 1; i < n; i++ {
		result[i] = -1
	}

	search := func(dir int) {
		depth := 1
		//方向标记
		walkedMap := map[int]bool{1: true}
		for extendArr := []int{0}; len(extendArr) > 0; dir *= -1 {
			tArr := make([]int, 0)
			for _, start := range extendArr {
				for _, end := range edgesMap[dir*(start+1)] {
					if !walkedMap[dir*(end+1)] {
						// println(start, end)
						walkedMap[dir*(end+1)] = true
						tArr = append(tArr, end)
						if result[end] < 0 || result[end] > depth {
							result[end] = depth
							tArr = append(tArr, end)
						}
					}
				}
			}
			extendArr = tArr
			depth++
		}
	}
	search(1)
	search(-1)
	return result
}

// func shortestAlternatingPaths(n int, redEdges [][]int, blueEdges [][]int) []int {
// 	//是否红色，其实位置，终止位置
// 	getSym := func(isRad bool, start int, end int) int {
// 		if isRad {
// 			return (1 << 14) | (start << 7) | end
// 		} else {
// 			return (start << 7) | end
// 		}
// 	}
// 	//预处理,矩阵转map
// 	// 1颜色位 7起始位 7结束位
// 	routerMap := map[int]bool{}
// 	for _, arr := range redEdges {
// 		routerMap[getSym(true, arr[0], arr[1])] = true
// 	}
// 	for _, arr := range blueEdges {
// 		routerMap[getSym(false, arr[0], arr[1])] = true
// 	}
// 	matrix := make([][]int, n)
// 	for i := 0; i < n; i++ {
// 		matrix[i] = make([]int, n)
// 	}

// 	fmt.Println(routerMap)

// 	for i := 0; i < n; i++ {
// 		for j := 0; j < n; j++ {
// 			fmt.Print(matrix[i][j], "\t")
// 		}
// 		fmt.Println()
// 	}
// 	//走过的节点
// 	//1位颜色位 7位索引位
// 	flag := true
// 	walkedMap := map[int]bool{getSym(true, 0, 0): true}
// 	result := make([]int, n)
// 	result[0] = 1
// 	walkList := []int{0}
// 	for flag = true; len(walkList) > 0; flag = !flag {
// 		walkList = make([]int, 0)
// 		for _, idx := range walkList {
// 			// 能走，且未走过，标记，更新
// 			for i := 0; i < n; i++ {
// 				if !walkedMap[getSym(flag, i, i)] && routerMap[getSym(flag, idx, i)] {
// 					//标记
// 					walkedMap[getSym(flag, i, i)] = true
// 					//更新
// 					nidx := result[idx] + 1
// 					if result[i] == 0 || result[i] > nidx {
// 						result[i] = nidx
// 					}
// 					walkList = append(walkList, i)
// 				}
// 			}
// 		}

// 	}

// 	return result
// }

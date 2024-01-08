package problems

func numberOfBoomerangs(points [][]int) int {
	var result int
	for _, sp := range points {
		dirMap := map[int][][]int{}
		for _, ep := range points {
			dir := (sp[0]-ep[0])*(sp[0]-ep[0]) + (sp[1]-ep[1])*(sp[1]-ep[1])
			dirMap[dir] = append(dirMap[dir], ep)
		}
		for _, dirList := range dirMap {
			n := len(dirList)
			// 排列公式
			result += n * (n - 1)
		}
	}
	return result
}

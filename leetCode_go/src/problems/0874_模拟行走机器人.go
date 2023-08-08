package problems

func RobotSim(commands []int, obstacles [][]int) int {
	return robotSim(commands, obstacles)
}
func robotSim(commands []int, obstacles [][]int) int {
	obstacleMap := map[int]map[int]bool{}
	for _, obstacle := range obstacles {
		if _, ok := obstacleMap[obstacle[0]]; !ok {
			obstacleMap[obstacle[0]] = map[int]bool{}
		}
		obstacleMap[obstacle[0]][obstacle[1]] = true
	}
	dirs, dirIndex := [][2]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}, 0
	x, y, result := 0, 0, 0
	for _, command := range commands {
		switch command {
		case -1:
			dirIndex = (dirIndex + 1) % 4
		case -2:
			dirIndex = (dirIndex + 3) % 4
		default:
			for ; command > 0 && !obstacleMap[x+dirs[dirIndex][0]][y+dirs[dirIndex][1]]; command-- {
				x += dirs[dirIndex][0]
				y += dirs[dirIndex][1]
			}
			if tp := x*x + y*y; tp > result {
				result = tp
			}
		}
	}
	return result
}

package problems

func Insert(intervals [][]int, newInterval []int) [][]int {
	return insert(intervals, newInterval)
}

func insert(intervals [][]int, newInterval []int) [][]int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	//左右合并
	m := len(intervals)
	result, mergeFlag := make([][]int, 0, m+1), false
	for i := 0; i < m; i++ {
		if mergeFlag || intervals[i][1] < newInterval[0] {
			//添加
			result = append(result, intervals[i])
		} else if intervals[i][1] >= newInterval[0] || intervals[i][0] <= newInterval[1] {
			mergeFlag = true
			//合并
			newInterval[0] = min(intervals[i][0], newInterval[0])
			for ; i < m && intervals[i][0] <= newInterval[1]; i++ {
				newInterval[1] = max(newInterval[1], intervals[i][1])
			}
			result = append(result, newInterval)
			i--
		}

	}
	if !mergeFlag {
		result = append(result, newInterval)
	}
	return result
}

func insert_old(intervals [][]int, newInterval []int) [][]int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	//左右合并
	m := len(intervals)
	for i := 0; i < m; i++ {
		if intervals[i][0] > newInterval[1] {
			//插入
			tp := append([][]int{newInterval}, intervals[i:]...)
			return append(intervals[:i], tp...)
		} else if intervals[i][1] >= newInterval[0] {
			//合并
			intervals[i][0] = min(newInterval[0], intervals[i][0])
			intervals[i][1] = max(newInterval[1], intervals[i][1])
			//再合并
			for i+1 < len(intervals) && intervals[i+1][0] <= intervals[i][1] {
				intervals[i][1] = max(intervals[i][1], intervals[i+1][1])
				intervals = append(intervals[:i+1], intervals[i+2:]...)
			}
			return intervals
		}
	}
	intervals = append(intervals, newInterval)
	return intervals
}

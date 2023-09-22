package problems

import "sort"

func minMeetingRooms(intervals [][]int) int {
	startArray, endArray := make([]int, 0, len(intervals)), make([]int, 0, len(intervals))
	for i := 0; i < len(intervals); i++ {
		startArray = append(startArray, intervals[i][0])
		endArray = append(endArray, intervals[i][1])
	}
	sort.Ints(startArray)
	sort.Ints(endArray)
	var result int
	count := 0

	for len(startArray) > 0 {
		if endArray[0] <= startArray[0] {
			endArray = endArray[1:]
			count--
		} else {
			startArray = startArray[1:]
			count++
			if count > result {
				result = count
			}
		}
	}
	return result
}

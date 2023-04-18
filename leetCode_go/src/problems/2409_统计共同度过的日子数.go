package problems

import "strconv"

func CountDaysTogether(arriveAlice string, leaveAlice string, arriveBob string, leaveBob string) int {
	return countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob)
}
func countDaysTogether(arriveAlice string, leaveAlice string, arriveBob string, leaveBob string) int {
	prefixSumArr := []int{0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334}
	parseStr := func(str string) int {
		mounth, _ := strconv.Atoi(str[0:2])
		day, _ := strconv.Atoi(str[3:])
		return prefixSumArr[mounth] + day
	}
	startA, leaveA, startB, leaveB := parseStr(arriveAlice), parseStr(leaveAlice), parseStr(arriveBob), parseStr(leaveBob)
	arr := make([]int, 366)
	for i := startA; i <= leaveA; i++ {
		arr[i]++
	}
	result := 0
	for i := startB; i <= leaveB; i++ {
		if arr[i] == 1 {
			result++
		}
	}
	return result
}

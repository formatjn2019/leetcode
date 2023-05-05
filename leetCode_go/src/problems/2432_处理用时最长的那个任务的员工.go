package problems

func HardestWorker(n int, logs [][]int) int {
	return hardestWorker(n, logs)
}
func hardestWorker(n int, logs [][]int) int {
	result, pre, dual := logs[0][0], 0, 0
	for _, arr := range logs {
		tpdual := arr[1] - pre
		if tpdual > dual || tpdual == dual && arr[0] < result {
			result = arr[0]
			dual = tpdual
		}
		pre = arr[1]
	}
	return result
}

package problems

func GoodDaysToRobBank(security []int, time int) []int {
	return goodDaysToRobBank(security, time)
}

func goodDaysToRobBank(security []int, time int) []int {
	result := make([]int, 0)
	judge := make([]bool, len(security))
	pre := 1000000
	tlen := time
	for i := 0; i < len(security); i++ {
		if security[i] > pre {
			tlen = time - 1
		} else {
			tlen--
		}
		if tlen < 0 {
			judge[i] = true
		}
		pre = security[i]
	}
	tlen = time
	pre = 1000000

	for i := len(security) - 1; i >= 0; i-- {
		if security[i] > pre {
			tlen = time - 1
		} else {
			tlen--
		}
		if tlen < 0 {
			judge[i] = judge[i]
		} else {
			judge[i] = false
		}
		pre = security[i]
	}
	for i := 0; i < len(judge); i++ {
		if judge[i] {
			result = append(result, i)
		}
	}
	return result
}

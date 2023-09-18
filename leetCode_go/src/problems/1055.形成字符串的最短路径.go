package problems

func shortestWay(source string, target string) int {
	sArr, tArr := []rune(source), []rune(target)
	sp, tp := 0, 0
	var result int
	for tp < len(target) {
		oldTp := tp
		result++
		for sp = 0; sp < len(sArr); sp++ {
			if tp < len(tArr) && sArr[sp] == tArr[tp] {
				tp++
			}
		}
		if oldTp == tp {
			return -1
		}
	}
	return result
}

func shortestWay_timeout(source string, target string) int {
	subMap := map[string]bool{source: true}
	tArr := []string{source}
	for lenth := len(source); lenth > 0; lenth-- {
		tpArr := make([]string, 0)
		for _, str := range tArr {
			for i := 0; i < lenth; i++ {
				sStr := str[0:i] + str[i+1:]
				if !subMap[sStr] {
					subMap[sStr] = true
					tpArr = append(tpArr, sStr)
				}
			}
		}
		tArr = tpArr
	}
	var result int
	for start := 0; start < len(target); start++ {
		if !subMap[target[start:start+1]] {
			return -1
		}
		result += 1
		ts := start
		for end := start + 1; end < len(target); end++ {
			if !subMap[target[ts:end+1]] {
				break
			}
			start = end
		}
	}
	return result
}

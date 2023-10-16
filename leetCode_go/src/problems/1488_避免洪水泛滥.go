package problems

func AvoidFlood(rains []int) []int {
	return avoidFlood(rains)
}
func avoidFlood(rains []int) []int {
	spaceList := make([]int, 0)
	result := make([]int, len(rains))
	rMap := map[int]int{}
	for i, rain := range rains {
		if rain > 0 {
			// 池塘第二次下雨时，尝试提前抽水
			if idx, ok := rMap[rain]; ok {
				sp, spIdx := 0, -1
				for ; sp < len(spaceList); sp++ {
					// 可抽
					if spaceList[sp] > idx {
						spIdx = spaceList[sp]
						break
					}
				}
				if sp == len(spaceList) {
					return []int{}
				} else {
					result[spIdx] = rain
					spaceList = append(spaceList[0:sp], spaceList[sp+1:]...)
					delete(rMap, rain)
				}
			}
			rMap[rain] = i
			result[i] = -1
		} else {
			spaceList = append(spaceList, i)
			result[i] = 1
		}
	}
	return result
}

func avoidFlood_timeout(rains []int) []int {
	result := make([]int, len(rains))
	rMap := map[int]int{}
	for i, rain := range rains {
		if rain > 0 {
			rMap[rain]++
		}
		result[i] = -1
	}
	// 下雨会积水的池塘统计
	// 移出队列
	removeMap := map[int]int{}
	for i := len(rains) - 1; i >= 0; i-- {
		if rains[i] > 0 {
			if rMap[rains[i]] > 1 {
				removeMap[rains[i]]++
			}
			rMap[rains[i]]--
		} else {
			if len(removeMap) > 0 {
				p := i - 1
				for p > 0 && removeMap[rains[p]] == 0 {
					p--
				}
				if p >= 0 {
					removeMap[rains[p]]--
					if removeMap[rains[p]] == 0 {
						delete(removeMap, rains[p])
					}
					result[i] = rains[p]
				}
			}
		}
	}
	rMap = map[int]int{}
	for i, rain := range rains {
		if rain > 0 {
			rMap[rain]++
			if rMap[rain] > 1 {
				return []int{}
			}
		} else if result[i] == -1 {
			// 随机移出一个大于1的池塘
			result[i] = 1
		} else if rMap[result[i]] > 0 {
			rMap[result[i]]--
			if rMap[result[i]] == 0 {
				delete(rMap, rMap[result[i]])
			}
		}
	}
	return result
}

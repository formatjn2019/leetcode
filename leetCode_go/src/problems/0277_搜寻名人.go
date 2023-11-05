package problems

func solution(knows func(a int, b int) bool) func(n int) int {
	queryMap := map[int]bool{}
	query := func(x, y int) bool {
		flag := x<<10 | y
		if _, ok := queryMap[flag]; !ok {
			queryMap[flag] = knows(x, y)
		}
		return queryMap[flag]
	}
	queryFlag := map[int]bool{}
	check := func(numIdx int, maxNum int) (result bool, subs []int) {
		if queryFlag[numIdx] {
			return false, []int{}
		}
		// 遍历
		flag := true
		// 不知道任何人
		for i := 0; i < maxNum; i++ {
			if numIdx == i {
				continue
			}
			if query(numIdx, i) {
				flag = false
				subs = append(subs, i)
			}
		}
		if !flag {
			return flag, subs
		}
		//所有人都知道
		for i := 0; i < maxNum; i++ {
			if !query(i, numIdx) {
				return false, subs
			}
		}
		return true, subs
	}

	return func(n int) int {
		tarr := []int{0}
		for len(queryFlag) < n && len(tarr) > 0 {
			ntarr := make([]int, 0)
			for _, cn := range tarr {
				if _, ok := queryFlag[cn]; !ok {
					if nf, na := check(cn, n); nf {
						return cn
					} else {
						queryFlag[cn] = false
						ntarr = append(ntarr, na...)
					}
				}
			}
			tarr = ntarr
		}
		return -1
	}
}

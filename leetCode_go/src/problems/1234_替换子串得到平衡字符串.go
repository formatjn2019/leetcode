package problems

import "fmt"

func BalancedString(s string) int {
	result := balancedString(s)
	fmt.Println(s, ":", result)
	return result
}

// func balancedString(s string) int {
// 	countMap, arr, n := map[rune]int{}, []rune(s), len(s)/4
// 	for _, c := range arr {
// 		countMap[c] = countMap[c] + 1
// 	}
// 	// fmt.Println(countMap)
// 	qc, wc, ec, rc := countMap['Q'], countMap['W'], countMap['E'], countMap['R']
// 	abs := func(x int) int {
// 		if x < 0 {
// 			return -x
// 		}
// 		return x
// 	}
// 	// fmt.Println((abs(qc-n) + abs(wc-n) + abs(ec-n) + abs(rc-n)) / 2)
// 	for r := (abs(qc-n) + abs(wc-n) + abs(ec-n) + abs(rc-n)) / 2; r > 0; r++ {
// 		// fmt.Println(r)
// 		tempMap := map[rune]int{}
// 		//初始化
// 		for _, c := range arr[:r-1] {
// 			tempMap[c] += 1
// 		}
// 		// fmt.Println(tempMap)
// 		for t := 0; t+r <= 4*n; t++ {
// 			tempMap[arr[t+r-1]] += 1
// 			if qc-tempMap['Q'] <= n && wc-tempMap['W'] <= n && ec-tempMap['E'] <= n && rc-tempMap['R'] <= n {
// 				return r
// 			}
// 			tempMap[arr[t]] -= 1
// 		}

// 	}
// 	return 0
// }

func balancedString(s string) int {
	min := func(a, b int) int {
		if a > b {
			return b
		}
		return a
	}
	cnt := map[byte]int{}
	for _, c := range s {
		cnt[byte(c)]++
	}
	partial := len(s) / 4
	check := func() bool {
		if cnt['Q'] > partial ||
			cnt['W'] > partial ||
			cnt['E'] > partial ||
			cnt['R'] > partial {
			return false
		}
		return true
	}

	if check() {
		return 0
	}

	res := len(s)
	r := 0
	for l, c := range s {
		for r < len(s) && !check() {
			cnt[s[r]]--
			r += 1
		}
		if !check() {
			break
		}
		res = min(res, r-l)
		cnt[byte(c)]++
	}
	return res
}

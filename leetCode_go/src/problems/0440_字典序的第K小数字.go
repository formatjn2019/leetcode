package problems

func FindKthNumber(n int, k int) int {
	println(findKthNumber_timeout(n, k))
	return findKthNumber(n, k)
}

func getSteps(cur, n int) (steps int) {
	min := func(a, b int) int {
		if a > b {
			return b
		}
		return a
	}
	first, last := cur, cur
	for first <= n {
		steps += min(last, n) - first + 1
		first *= 10
		last = last*10 + 9
	}
	return
}

func findKthNumber(n, k int) int {
	cur := 1
	k--
	for k > 0 {
		steps := getSteps(cur, n)
		if steps <= k {
			k -= steps
			cur++
		} else {
			cur *= 10
			k--
		}
	}
	return cur
}

func findKthNumber_timeout(n int, k int) int {

	num := 1
	for pre := 0; k > 1; {
		switch {
		//下层
		case num*10 <= n && pre < num*10:
			num *= 10
			pre = num
			k--
		//右移
		case num%10 < 9 && num < n:
			num++
			pre = num
			k--
		//上层
		default:
			num /= 10
		}
	}
	return num
}

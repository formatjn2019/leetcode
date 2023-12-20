package problems

func Divide(dividend int, divisor int) int {
	return divide(dividend, divisor)
}

func divide(dividend int, divisor int) int {
	abs := func(x int) (int, int) {
		if x > 0 {
			return x, 1
		} else {
			return -x, -1
		}
	}
	var result int
	multiple := 1
	newDivisor, flag1 := abs(divisor)
	newDividend, flag2 := abs(dividend)

	//增加倍数
	for newDivisor < newDividend {
		multiple, newDivisor = multiple<<1, newDivisor<<1
	}
	//减小倍数
	for multiple > 0 {
		if newDividend < newDivisor {
			newDivisor >>= 1
			multiple >>= 1
		} else {
			newDividend -= newDivisor
			result += multiple
		}
	}
	if flag1^flag2 != 0 {
		result = -result
	}
	if result > (1<<31 - 1) {
		return 1<<31 - 1
	} else if result < (-(1 << 32)) {
		return -(1 << 31)
	} else {
		return result
	}
}

package problems

import (
	"math"
	"strconv"
)

func NearestPalindromic(n string) string {
	return nearestPalindromic(n)
}
func isPalindromes(str string) bool {
	arr := []rune(str)
	for i := 0; i < len(arr)/2; i++ {
		if arr[i] != arr[len(arr)-1-i] {
			return false
		}
	}
	return true
}

func isPalindromesNum(n int64) bool {
	conv := int64(0)
	for t := n; t > 0; t /= 10 {
		conv = conv*10 + t%10
	}
	return conv == n
}

func nearestPalindromic(n string) string {
	value, _ := strconv.ParseInt(n, 10, 64)
	result := converToPalindromic("0")
	diff := value
	//减少，退位
	for sub := int64(1); sub < value; sub *= 10 {
		nval := value - (value%sub + 1)
		nstr := converToPalindromic(strconv.FormatInt(nval, 10))
		trueval, _ := strconv.ParseInt(nstr, 10, 64)
		ndiff := int64(math.Abs(float64(value - trueval)))
		if ndiff != 0 && ndiff <= diff {
			diff = ndiff
			result = nstr
		}
	}
	//增加,进位
	for sub := int64(1); sub < value; sub *= 10 {
		nval := value + (sub - value%sub)
		nstr := converToPalindromic(strconv.FormatInt(nval, 10))
		trueval, _ := strconv.ParseInt(nstr, 10, 64)
		ndiff := int64(math.Abs(float64(value - trueval)))
		if ndiff != 0 && ndiff < diff {
			diff = ndiff
			result = nstr
		}
	}

	return result
}

func converToPalindromic(s string) string {
	result := []rune(s)
	for i := 0; i < len(result); i++ {
		result[len(result)-1-i] = result[i]
	}
	return string(result)
}

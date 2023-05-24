package problems

import "fmt"

func AddNegabinary(arr1 []int, arr2 []int) []int {
	result := addNegabinary(arr1, arr2)
	fmt.Println(result)
	return result
}
func addNegabinary(arr1 []int, arr2 []int) []int {
	println((-2) >> 2)
	lenth := len(arr1) + 3
	if lenth < len(arr2)+3 {
		lenth = len(arr2) + 3
	}
	//取2的倍数
	lenth = lenth / 2 * 2
	arr1, arr2 = append(make([]int, lenth-len(arr1)), arr1...), append(make([]int, lenth-len(arr2)), arr2...)
	fmt.Println(arr1)
	fmt.Println(arr2)
	fmt.Println(lenth)
	carry := 0
	for i := lenth - 1; i >= 0; i -= 2 {
		n1, n2 := arr1[i-1]*-2+arr1[i], arr2[i-1]*-2+arr2[i]
		println(n1, n2)
	}
	println(carry)
	return nil
}
func addNegabinary_old(arr1 []int, arr2 []int) []int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	m, n := len(arr1), len(arr2)
	arr1, arr2 = append(make([]int, max(n-m, 0)+3), arr1...), append(make([]int, max(m-n, 0)+3), arr2...)
	carry, l := 0, len(arr1)
	result := make([]int, 0, max(m, n)+2)

	for i := l - 1; i >= 0; i-- {
		n1, n2 := arr1[i], arr2[i]
		b := n1 + n2 + carry
		switch b {
		case -1:
			carry = 1
			result = append(result, 1)
		case 0:
			carry = 0
			result = append(result, 0)
		case 1:
			carry = 0
			result = append(result, 1)
		case 2:
			carry = -1
			result = append(result, 0)
		case 3:
			carry = 0
			result = append(result, 1)
			result = append(result, 1)
			result = append(result, 1)
		}
		////借位或者进位，进位标志赋1
		//if (b+1)%3 == 0 {
		//	carry = 1
		//} else {
		//	carry = 0
		//}
		//// 不进位或者借位，赋1
		//if b*b == 1 {
		//	result = append(result, 1)
		//} else {
		//	result = append(result, 0)
		//}
	}
	if carry == -1 {
		result = append(result, 1)
		result = append(result, 1)
	}
	l = len(result)
	//首部去0
	for i := l - 1; i > 0; i-- {
		if result[i] != 0 {
			break
		}
		result = result[:i]
	}
	l = len(result)
	for i := 0; i < l/2; i++ {
		result[i], result[l-i-1] = result[l-i-1], result[i]
	}
	return result
}

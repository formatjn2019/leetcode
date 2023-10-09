package problems

import (
	"fmt"
)

func Calculate(s string) int {
	return calculate(s)
}

func calculate(s string) int {
	stack := make([]rune, 0)
	//flag := true
	//pre=""
	for _, c := range s {
		switch c {
		case '(':
			stack = append(stack, '(')
		case ')':
			for stack[len(stack)-1] != '(' {
				fmt.Print(string(stack[len(stack)-1]) + " ")
				stack = stack[:len(stack)-1]
			}
			stack = stack[:len(stack)-1]
		case '+', '-':
			stack = append(stack, c)
		case '*', '/':
			for len(stack) > 0 && (stack[len(stack)-1] == '+' || stack[len(stack)-1] == '-') {
				fmt.Print(string(stack[len(stack)-1]) + " ")
				stack = stack[:len(stack)-1]
			}
			stack = append(stack, c)
		default:
			fmt.Print(string(c) + " ")
		}
	}
	for len(stack) > 0 {
		fmt.Print(string(stack[len(stack)-1]) + " ")
		stack = stack[:len(stack)-1]
	}
	return 0
}

//func calculate3(s string) int {
//	toInt := func(s string) int {
//		i, _ := strconv.Atoi(s)
//		return i
//	}
//	var eval func(s string) int
//	var evalArr func(string) int
//	evalArr = func(ts string) int {
//		result, flag := 0, false
//		for i := 0; i < len(ts); i++ {
//
//		}
//		return result
//	}
//	eval = func(str string) int {
//		// 括号解析
//		ck := true
//		for ck {
//			ck = false
//			st, ed, kc := 0, 0, 0
//			for i := 0; i < len(str); i++ {
//				if str[i] == '(' {
//					kc++
//					st = i
//					ck = true
//				} else if str[i] == ')' {
//					kc--
//					if kc == 0 {
//						ed = i
//						break
//					}
//				}
//			}
//			if st != ed {
//				str = str[:st] + strconv.Itoa(eval(str[st+1:ed])) + str[ed+1:]
//			}
//		}
//
//		arr, opArr := []rune(s), make([]string, 0)
//		start := 0
//		for i := 0; i < len(arr); i++ {
//			switch arr[i] {
//			case '+', '-':
//				if start != i {
//					opArr = append(opArr, string(arr[start:i]))
//				}
//				opArr = append(opArr, string(arr[i:i+1]))
//				start = i + 1
//			default:
//				continue
//			}
//		}
//		var result int
//		op := 1
//		for i := 0; i < len(opArr); i++ {
//			if opArr[i] == "+" {
//				op = 1
//			} else if opArr[i] == "-" {
//				op = -1
//			} else {
//				result += op * evalArr(opArr[0])
//			}
//		}
//
//		return result
//		//return result
//	}
//	eval(s)
//	fmt.Println(s)
//	return 0
//}

//func calculate2(s string) int {
//	arr, opArr := []rune(s), make([]string, 0)
//	start := 0
//	for i := 0; i < len(arr); i++ {
//		switch arr[i] {
//		case '+', '-', '*', '/', '(', ')':
//			if start != i {
//				opArr = append(opArr, string(arr[start:i]))
//			}
//			opArr = append(opArr, string(arr[i:i+1]))
//			start = i + 1
//		default:
//			continue
//		}
//	}
//	if start < len(arr) {
//		opArr = append(opArr, string(arr[start:]))
//	}
//	fmt.Println(opArr)
//	toInt := func(s string) int {
//		i, _ := strconv.Atoi(s)
//		return i
//	}
//	var parseArr func(arr []string) int
//	parseArr = func(arr []string) int {
//		if len(arr) == 1 {
//			return toInt(arr[0])
//		}
//		// 去除括号
//		kc := 1
//		for kc > 0 {
//			//括号解析
//			kc = 0
//			st, ed := 0, 0
//			for i := 0; i < len(arr); i++ {
//				if arr[i] == "(" {
//					kc++
//					st = i
//				} else if arr[i] == ")" {
//					kc--
//					if kc == 0 {
//						ed = i
//						break
//					}
//				}
//			}
//			if st != ed {
//				arr[start] = strconv.Itoa(parseArr(arr[st+1 : ed-1]))
//				arr = append(arr[:st+1], arr[ed+1:]...)
//			}
//		}
//		//加减拆分
//		tArr, st := []string{}, 0
//		// 最低级拆分
//		for i := 0; i < len(arr); i++ {
//			if arr[i] == "+" || (arr[i] == "-") {
//				tArr = append(tArr, i)
//			}
//		}
//		return 0
//	}
//	parseArr([]string{})
//	return 0
//}

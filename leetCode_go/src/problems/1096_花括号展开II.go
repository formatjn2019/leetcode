package problems

import (
	"bytes"
)

func BraceExpansionII(expression string) []string {
	//testItem()
	return nil
}

//func (i *Item) toStringArr() []string {
//	if i.sub == nil || len(i.sub) == 0 {
//		return []string{i.str}
//	}
//	nameSet := map[string]bool{}
//	for _, sub := range i.sub {
//		for _, subStr := range sub.toStringArr() {
//			nameSet[i.str+subStr] = true
//		}
//	}
//	result := make([]string, 0)
//	for k, _ := range nameSet {
//		result = append(result, k)
//	}
//	return result
//}
//
//func (i *Item) toString() string {
//	result := fmt.Sprintf("{%s,[", i.str)
//	for _, sub := range i.sub {
//		result += sub.toString()
//	}
//	return result + "]}"
//}

func braceExpansionII(expression string) []string {
	//解析字符串
	//arr := []rune(expression)

	//result, _ := parseItem(arr, 0)
	//
	//fmt.Println(result)
	//fmt.Println(result.toStringArr())
	//{,[{,[{,[{a,[]}{z,[]}]}{a,[{,[{b,[]}{c,[]}]}{,[{ab,[]}{z,[]}]}]}]}]}
	return nil
}

func parseString(str string) ([]string, int) {
	if len(str) == 0 {
		return []string{}, 0
	}
	result := []string{}
	arr := []rune(str)
	for i := 0; i < len(str); i++ {
		if arr[i] == '{' {

		}
	}
	return result, len(str)
}

type Item struct {
	value string
	arr   *Item
}

func (i *Item) mutix(other Item) []string {
	result := make([]string, 0)
	return result
}
func (i *Item) String() string {
	return i.value
}

func parseTuple(str string) ([]string, int) {
	arr := []rune(str[1:])
	result := make([]string, 0)
	var bf bytes.Buffer
	for i := 0; i < len(arr); i++ {
		if arr[i] <= 'z' && arr[i] >= 'a' {
			bf.WriteRune(arr[i])
		} else if arr[i] == ',' {
			result = append(result, bf.String())
			bf.Reset()
			continue
		} else if arr[i] == '{' {
			//tp, _ := parseTuple(string(arr[i:]))
			//if
		} else if arr[i] == '}' {

		}
	}
	return result, 0
}

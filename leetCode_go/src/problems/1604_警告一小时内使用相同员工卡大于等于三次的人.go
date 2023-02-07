package problems

import (
	"fmt"
	"sort"
	"strconv"
)

func AlertNames(keyName []string, keyTime []string) []string {
	result := alertNames(keyName, keyTime)
	fmt.Println(result)
	return result

}
func alertNames(keyName []string, keyTime []string) []string {
	result := make([]string, 0)
	nameTimeDic := map[string][]int{}
	//预处理
	for index, name := range keyName {
		hour, _ := strconv.Atoi(keyTime[index][:2])
		second, _ := strconv.Atoi(keyTime[index][3:])
		nameTimeDic[name] = append(nameTimeDic[name], hour*60+second)
	}
	for name, times := range nameTimeDic {
		sort.Ints(times)
		// fmt.Println(name, times)
		for start := 0; start < len(times)-2; start++ {
			if times[start]+60 >= times[start+2] {
				result = append(result, name)
				break
			}
		}
	}
	sort.Strings(result)
	return result
}

package problems

import (
	"fmt"
)

func BraceExpansionII(expression string) []string {
	testItem()
	return braceExpansionII(expression)
}
func testItem() {
	root := Item{str: "a", sub: []*Item{&Item{str: "", sub: []*Item{&Item{str: "b"}, &Item{str: "c", sub: []*Item{&Item{str: "d"}, &Item{str: "e"}}}}}}}
	fmt.Println(root.toStringArr())
}

type Item struct {
	str string
	sub []*Item
}

func (i *Item) toStringArr() []string {
	if i.sub == nil || len(i.sub) == 0 {
		return []string{i.str}
	}
	nameSet := map[string]bool{}
	for _, sub := range i.sub {
		for _, subStr := range sub.toStringArr() {
			nameSet[i.str+subStr] = true
		}
	}
	result := make([]string, 0)
	for k, _ := range nameSet {
		result = append(result, k)
	}
	return result
}

func braceExpansionII(expression string) []string {
	//解析字符串
	arr := []rune(expression)
	parseItem := func(idx int) (*Item, int) {
		if arr[idx] == '{' {

		} else {
			end := idx
			for end < len(arr) && arr[end] >= 'a' && arr[end] <= 'z' {
				end++
			}
			return Item{str: string(arr[:])}
		}
	}
	for i := 0; i < len(expression); i++ {
		switch arr[i] {
		case '{':
			stack = append(stack, "{")
		case ',':

		}
	}

	return nil
}

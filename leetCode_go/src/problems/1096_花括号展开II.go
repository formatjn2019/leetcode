package problems

import (
	"fmt"
)

func BraceExpansionII(expression string) []string {
	//testItem()
	fmt.Println(expression)
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

func (i *Item) toString() string {
	result := fmt.Sprintf("{%s,[", i.str)
	for _, sub := range i.sub {
		result += sub.toString()
	}
	return result + "]}"
}

func braceExpansionII(expression string) []string {
	//解析字符串
	arr := []rune(expression)

	result, _ := parseItem(arr, 0)

	fmt.Println(result.toString())
	fmt.Println(result.toStringArr())
	//{,[{,[{,[{a,[]}{z,[]}]}{a,[{,[{b,[]}{c,[]}]}{,[{ab,[]}{z,[]}]}]}]}]}
	return nil
}

func parseItem(arr []rune, idx int) (*Item, int) {
	result := &Item{}
	for idx < len(arr) {
		str := fmt.Sprintf("%c", arr[idx])
		fmt.Println(str)
		switch c := arr[idx]; {
		case c == ',':
			idx += 1
			continue
		case c == '{':
			sub, newIdx := parseItem(arr, idx+1)
			result.sub = append(result.sub, sub)
			idx = newIdx
		case c == '}':
			return result, idx + 1
		case c <= 'z' && c >= 'a':
			end := idx + 1
			for end < len(arr) && arr[end] >= 'a' && arr[end] <= 'z' {
				fmt.Printf("%c", arr[idx])
				end++
			}
			if end < len(arr) && arr[end] == '{' {
				subs, tmp := parseItem(arr, end)
				subs.str = string(arr[idx:end])
				result.sub = append(result.sub, subs)
				idx = tmp
			} else {
				result.sub = append(result.sub, &Item{str: string(arr[idx:end])})
				idx = end
			}

		default:
			panic("error")
		}
	}
	return result, idx + 1
}

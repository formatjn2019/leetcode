package problems

func CanChange(start string, target string) bool {
	return canChange(start, target)
}
func canChange(start string, target string) bool {
	sArr, tArr := []rune(start), []rune(target)
	for p := 0; p < len(start); p++ {
		if sArr[p] != tArr[p] {
			//统一尝试移动
			if sArr[p] == 'R' {
			ot1:
				for tp := p; tp < len(target); tp++ {
					switch sArr[tp] {
					case '_':
						sArr[tp], sArr[p] = sArr[p], sArr[tp]
						break ot1
					case 'R':
						continue
					default:
						break ot1
					}
				}
			} else if tArr[p] == 'L' {
			ot2:
				for tp := p; tp < len(target); tp++ {
					switch tArr[tp] {
					case '_':
						tArr[tp], tArr[p] = tArr[p], tArr[tp]
						break ot2
					case 'L':
						continue
					default:
						break ot2
					}
				}
			}
		}
		if sArr[p] == tArr[p] {
			continue
		} else {
			return false
		}
	}
	return true
}

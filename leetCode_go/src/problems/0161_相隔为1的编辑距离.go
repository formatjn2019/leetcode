package problems

func IsOneEditDistance(s string, t string) bool {
	return isOneEditDistance(s, t)
}

func isOneEditDistance(s string, t string) bool {
	pcc, scc := 0, 0
	sa, ta := []rune(s), []rune(t)
	for ; pcc < len(sa) && pcc < len(ta); pcc++ {
		if sa[pcc] != ta[pcc] {
			break
		}
	}
	for ; scc < len(sa)-pcc && scc < len(ta)-pcc; scc++ {
		if sa[len(sa)-1-scc] != ta[len(ta)-1-scc] {
			break
		}
	}
	return (len(s)-len(t) == 1 && pcc+scc == len(t)) || (len(t)-len(s) == 1 && pcc+scc == len(s)) || (len(s) == len(t) && pcc+scc == len(s)-1)
}

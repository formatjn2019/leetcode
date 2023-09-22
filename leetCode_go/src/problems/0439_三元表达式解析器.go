package problems

func ParseTernary(expression string) string {
	return parseTernary(expression)
}
func parseTernary(expression string) string {
	if len(expression) == 1 {
		return expression
	} else {
		c, i := 1, 2
		for ; ; i++ {
			if expression[i] == '?' {
				c++
			} else if expression[i] == ':' {
				c--
			}
			if c == 0 {
				break
			}
		}
		if expression[0] == 'T' {
			return parseTernary(expression[2:i])
		} else {
			return parseTernary(expression[i+1:])
		}
	}
}

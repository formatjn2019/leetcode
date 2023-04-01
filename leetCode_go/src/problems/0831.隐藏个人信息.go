package problems

import (
	"fmt"
	"regexp"
	"strings"
)

func MaskPII(s string) string {
	return maskPII(s)
}

func maskPII(s string) string {
	//判断邮箱还是电话
	if strings.Contains(s, "@") {
		compile, _ := regexp.Compile(`^([a-z])(.*?)([a-z]@.*)$`)
		return compile.ReplaceAllString(strings.ToLower(s), `$1*****$3`)
	} else {
		compile, _ := regexp.Compile(`\D`)
		str := compile.ReplaceAll([]byte(s), []byte(""))
		gn := len(str) - 10
		str = str[len(str)-4:]
		if gn > 0 {
			return fmt.Sprintf("+%s-***-***-%s", strings.Repeat("*", gn), str)
		}
		return fmt.Sprintf("***-***-%s", str)
	}
}

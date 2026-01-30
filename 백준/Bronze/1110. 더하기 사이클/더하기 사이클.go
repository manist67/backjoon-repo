package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	var N int
	fmt.Scanf("%d", &N)

	var cnt int
	v := N
	for cnt = 0; ; cnt++ {
		a := strconv.Itoa(v)
		ans := 0
		splitNumber := strings.Split(a, "")
		for _, d := range splitNumber {
			digit, err := strconv.Atoi(d)
			if err != nil {
				return
			}
			ans += digit
		}

		ansStr := strings.Split(strconv.Itoa(ans), "")
		rightAns, err := strconv.Atoi(ansStr[len(ansStr)-1])
		if err != nil {
			return
		}

		l := len(splitNumber)
		rightFirst, err := strconv.Atoi(splitNumber[l-1])
		if err != nil {
			return
		}
		v = rightFirst*10 + rightAns

		if v == N {
			break
		}
	}

	fmt.Printf("%d", cnt+1)
}

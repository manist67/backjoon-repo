package main

import (
	"fmt"
	"strings"
)

func main() {
	var n int
	fmt.Scanf("%d\n", &n)

	var arr [][]rune
	for i := 0; i < n; i++ {
		var s string
		fmt.Scanf("%s\n", &s)
		arr = append(arr, []rune(s))
	}

	l := len(arr[0])

	var ans strings.Builder

	for i := 0; i < l; i++ {
		isAllCorrect := true

		controlChar := arr[0][i]

		for j := 1; j < n; j++ {
			if controlChar != arr[j][i] {
				isAllCorrect = false
				break
			}
		}

		if isAllCorrect {
			ans.WriteRune(controlChar)
		} else {
			ans.WriteString("?")
		}
	}

	fmt.Printf("%s\n", ans.String())
}

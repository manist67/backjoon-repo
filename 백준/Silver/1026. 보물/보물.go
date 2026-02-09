package main

import (
	"fmt"
	"sort"
)

func main() {
	var N int
	fmt.Scan(&N)

	var A []int
	for i := 0; i < N; i++ {
		var v int
		fmt.Scan(&v)
		A = append(A, v)
	}

	sort.Ints(A)

	var B []int
	for i := 0; i < N; i++ {
		var v int
		fmt.Scan(&v)
		B = append(B, v)
	}
	sort.Ints(B)
	sort.Sort(sort.Reverse(sort.IntSlice(B)))

	ans := 0

	for i := 0; i < N; i++ {
		ans += A[i] * B[i]
	}

	fmt.Printf("%d\n", ans)
}

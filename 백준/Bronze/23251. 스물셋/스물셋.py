T = int(input())
import sys
questions = [str(int(sys.stdin.readline().strip()) * 23) for i in range(T)]

print("\n".join(questions))

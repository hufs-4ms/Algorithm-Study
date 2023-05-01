def method(s, l):
	a = []
	for i in range(n):
		result = n + s[i] - l[i] - (i+1)  # n개의 수 중 가장 높은 수에서 A[i]보다 작은 수를 더하고 큰 수를 빼면 A[i]의 값이 나온다.
		a.append(result)
	return a

s = [int(x) for x in input().split()]  # 리스트 s의 n개의 값
l = [int(x) for x in input().split()]  # 리스트 l의 n개의 값
n = len(s)  # 리스트의 길이
A = method(s,l)
print(A)

# for문을 한번 돌려서 리스트 A를 구하는 것이므로 시간복잡도는 O(n)이된다.
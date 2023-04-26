/*
lv2 점프와 순간이동
*/
function solution(n) {
  //1:21
  var ans = 0

  while (n != 0) {
    if (n % 2 === 1) {
      n -= 1
      ans++
    } else {
      n /= 2
    }
  }

  return ans
}

/*
 lv1 폰켓몬
*/
function solution(nums) {
  var answer = 0
  const len = nums.length / 2
  const arr = [...new Set(nums)]
  if (arr.length >= len) {
    answer = len
  } else {
    answer = arr.length
  }
  return answer
}

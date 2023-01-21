/*
프로그래머스 lv1 [1차]비밀지도
*/
function solution(n, arr1, arr2) {
  var answer = [];
  let map1 = arr1.map(d=> d.toString(2).padStart(n,0))
  let map2 = arr2.map(d=> d.toString(2).padStart(n,0))

  for(let i=0; i<n; i++){
      const a = map1[i].split('')
      const b = map2[i].split('')
      answer.push(a.map((x,y)=>Number(x)+Number(b[y])))
  }
  const q = answer.map(d=> d.map(d1=> d1 > 0 ? '#' : ' ')).map(d=>d.join(''))
  return q;
}
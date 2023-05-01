/*
lv2 [1차] 캐시
*/
function solution(cacheSize, cities) {
  var answer = 0
  //LRU 캐시에서 최근까지 사용하지 않은 것은 교체
  let miss = 0
  let hit = 0
  let cach = []

  if (cacheSize === 0) {
    return cities.length * 5
  }

  for (let i = 0; i < cities.length; i++) {
    let city = cities[i].toUpperCase()
    if (!cach.includes(city)) {
      miss += 5
      //캐시테이블이 꽉찬 경우
      if (cach.length === cacheSize) {
        cach.shift()
        cach.push(city)
      } else {
        //캐시테이블이 여유있는 경우
        cach.push(city)
      }
    } else {
      hit += 1
      cach = cach.filter((d) => d != city)
      cach.push(city)
    }
  }
  answer = miss + hit

  return answer
}

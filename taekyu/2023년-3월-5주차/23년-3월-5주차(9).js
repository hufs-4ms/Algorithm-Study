/*
lv1 바탕화면 정리
*/
function solution(wallpaper) {
  let x = []
  let y = []

  wallpaper = wallpaper.map((d) => d.split(''))
  for (let i = 0; i < wallpaper.length; i++) {
    for (let j = 0; j < wallpaper[0].length; j++) {
      if (wallpaper[i][j] === '#') {
        x.push(i)
        y.push(j)
      }
    }
  }
  x.sort((a, b) => a - b)
  y.sort((a, b) => a - b)
  return [x[0], y[0], x[x.length - 1] + 1, y[y.length - 1] + 1]
}

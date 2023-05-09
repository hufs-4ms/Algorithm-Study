/*
lv2 피로도
*/
function solution(k, dungeons) {
  var answer = -1
  const visited = Array.from({ length: dungeons.length }, () => false)

  function dfs(k, D) {
    for (let i = 0; i < dungeons.length; i++) {
      if (k >= dungeons[i][0] && visited[i] == false) {
        visited[i] = true
        dfs(k - dungeons[i][1], D + 1)
        visited[i] = false
      }
    }
    answer = Math.max(answer, D)
  }

  dfs(k, 0)

  return answer
}

/*
Lv2 게임 맵 최단거리
*/
//BFS, 상하좌우, 계속 진행해도 되는지 여부, 충족하면 다음값을 큐에 넣어줌
function solution(maps) {
  var answer = 0
  let n = maps.length
  let m = maps[0].length

  let visit = Array(n)
    .fill()
    .map(() => Array(m).fill(0))
  visit[0][0] = 1

  let x = [0, 1, 0, -1]
  let y = [1, 0, -1, 0]

  let que = [[1, 1]]

  while (que.length) {
    // que에 있는 위치 확인
    let [cur_y, cur_x] = que.shift()

    for (let i = 0; i < 4; i++) {
      let next_x = cur_x + x[i]
      let next_y = cur_y + y[i]
      // 가도되되는지 확인
      // 맵을 빠져나갈때
      if (next_x <= 0 || next_y <= 0 || next_x > m || next_y > n) continue
      //벽 만났을때
      if (maps[next_y - 1][next_x - 1] === 0) continue
      // 방문한 적이 없을때
      if (visit[next_y - 1][next_x - 1] !== 0) continue
      // 모두 충족되면 이동한 값을 que에 저장하고 방문값도 true로 변경
      visit[next_y - 1][next_x - 1] = visit[cur_y - 1][cur_x - 1] + 1
      que.push([next_y, next_x])
    }
  }

  visit[n - 1][m - 1] === 0 ? (answer = -1) : (answer = visit[n - 1][m - 1])

  return answer
}

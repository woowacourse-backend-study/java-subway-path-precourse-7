# java-subway-path-precourse
# 구현 기능 목록
## 기능
- 초기 설정 
- [ ] 역, 노선, 구간 정보 초기 set up
    - [ ] 역 정보 초기 설정
    - [ ] 노선 정보 초기 설정
    - [ ] 구간 정보 (section) 초기 설정
    -  왼쪽역, 오른쪽역, 거리, 시간
  
- 경로 조회 기능
- [ ] 최단거리 계산 기준
- [ ] 최소시간 계산 기준 

- [ ] 재입력 로직 


## 입력
- [ ] 메인 옵션 입력 : 경로 조회, 종료
- [ ] 경로 기준 입력 : 최단, 최소, 돌아가기
- [ ] 출발역 입력
- [ ] 도착역 입력

## 출력
- [ ] 메인화면 출력
- [ ] 메세지: ## 원하는 기능을 선택하세요.
- [ ] 경로 기준 출력
- [ ] 조회 결과 출력


## 예외
- [ ] 출발역과 도착역이 같으면 예외 처리
- [ ] 없는 역을 입력했을 경우 예외 처리
- [ ] 출발역과 도착역이 연결되어 있지 않으면 예외 처리

### 최단 경로 라이브러리
    - jgrapht 라이브러리를 활용하면 간편하게 최단거리를 조회할 수 있음
    - Dijkstra 알고리즘을 반드시 이해할 필요는 없고 미션에 적용할 정도로만 이해하면 됨
    - JGraphtTest 클래스의 테스트를 활용하여 미션에 필요한 라이브러리의 기능을 학습할 수 있음
    - 정점(vertex)과 간선(edge), 그리고 가중치 개념을 이용
        - 정점: 지하철역
        - 간선: 지하철역 연결정보
        - 가중치: 거리 or 소요 시간
    - 최단 거리 기준 조회 시 가중치를 거리로 설정
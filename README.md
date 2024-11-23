# java-subway-path-precourse

## 기능 구현 목록

### 목표 : 등록된 지하철 노선도에서 경로 조회 기능

### 입력

- [ ] 원하는 기능을 선택하세요
    - 1 -> 경로 조회
    - Q -> 종료
    - 그 외 : 잘못된 입력 -> 재입력 처리

- [ ] 원하는 기능을 선택하세요
    - 1 -> 최단 거리 탐색
    - 2 -> 최소 시간 탐색
    - B -> 돌아가기

- [ ] 츨발역을 입력하세요.
    - 초기 설정에 없는 역의 이름인 경우 예외

- [ ] 도착역을 입력하세요.
    - 초기 설정에 없는 역의 이름인 경우 예외
    - 출발역과 이름이 같은 경우 예외
    - 출발역과 도착역이 연결되어있지 않은 경우 예외

### 출력

- [X] 메인 화면
    - 경로 조회
    - 종료

- [X] 경로 기준
    - 최단 거리
    - 최소 시간
    - 돌아가기

- [X] 조회 결과
    - [INFO] 키워드
    - 구분선
    - 총 거리
    - 총 소요 시간
    - 출발역부터 도착역까지 거치는 역 이름 정보

### 주요 기능

- [ ] 초기 설정
    - Station과 Line의 기본 생성자는 추가할 수 없다
    - 지하철 역 (Station) : 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역
    - 지하철 노선 (Line) : 2호선, 3호선, 신분당선
    - 노선별 역 정보
        - 2호선 : 교대역 - ( 2km / 3분 ) - 강남역 - ( 2km / 3분 ) - 역삼역
        - 3호선 : 교대역 - ( 3km / 2분 ) - 남부터미널역 - ( 6km / 5분 ) - 양재역 - ( 1km / 1분 ) - 매봉역
        - 신분당선 : 강남역 - ( 2km / 8분 ) - 양재역 - ( 10km / 3분 ) - 양재시민의숲역
    - 소요 거리 저장 (Distance) : 출발역 이름, 도착역 이름, 거리
    - 소요 시간 저장 (Time) : 출발역 이름, 도착역 이름, 시간

- [ ] 최단 거리 경로 찾기
    - JGrpaht 라이브러리를 이용한다
        - 출발역과 도착역, 그 사이의 역들을 조회하여 addVertex
        - 이어진 역들끼리 addEdge
        - 역들 간 거리를 가중치로 설정 setEdgeWeight
        - DijkstraShortestPath의 getPath와 getVetTexList를 이용하여 최단 경로 조회

- [ ] 최단 시간 경로 찾기
    - 위 방법에서 가중치를 시간으로 setEdgeWeight
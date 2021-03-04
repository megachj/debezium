# debezium poc
### 실행 방법
맥에서 아래 순서대로 실행한다.

1. system 실행
```bash
# zookeeper, kafka, mysql, debezium 컨테이너 실행
cd ./system
docker-compose up -d

# debezium cdc 실행
sh init.sh
```

2. app 실행

3. 데이터를 변경해본다.
- CUD
- 스키마 변경

4. app 에서 변경 데이터를 잘 캡쳐하는지 확인한다.

5. 테스트 후 컨테이너 종료
```bash
docker-compose down
```
# spring-boot/aop

## aop 配下について

- Spring Boot における AOP の実装をしてみる

## AOP の要点

### JoinPoint

- Advice を挿入する場所

### Advice

- JoinPoint で実行される処理

### PointCut

- Advice を実行するかどうかの条件

## 動作確認

1\. spring boot 起動

```
./gradlew bootRun
```

2\. 以下を実行

```
curl -i -X GET 'http://localhost:8081/api/sample'
```

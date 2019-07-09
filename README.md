# AndroidLayouts

> 자바로 연습했던 레이아웃들을 코틀린으로 바꿔서 연습해보자!

<br>

## WebView

💁 06/25 코틀린으로 간단한 웹뷰를 띄워보는 프로젝트 ( 블로그 사이트를 띄웠다. )

<br>

## FirebaseInit

💁 07/09 ~ Firebase 프로젝트와 안드로이드 프로젝트를 연동시켜보는 프로젝트("Firebase로 안드로이드 SNS 앱 만들기(하울)" 책 참고)

1. 안드로이드 프로젝트가 Firebase에 접근하기 위해서 Firebase에서 발급한 증명서(google-services.json파일)를 연결한다.
  > 이 json파일 안에는 FIrebase의 기능들을 사용할 때 필요한 여러 API 키가 담겨져 있다. 푸시, SNS로그인 등 각 기능에 따른 각각의 API 키가 이 파일에 모여있다.
  >
  > google-service.json파일과 안드로이드 프로젝트를 연결하는 방법은 Gradle에 직접 연결하는 방법, Asistant를 이용해서 간단히 연결하는 방법이 있다.
  
  <br>

  1-1 Gradle에 직접 연결하는 방법
  
    - 

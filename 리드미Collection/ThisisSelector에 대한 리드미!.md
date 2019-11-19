## ✋ 셀렉터 만드는 나만의 라이브러뤼~

> SOPT 5주차 과제로 디자인팀이 제작한 UI를 제플린을 사용하여 안드로이드 개발팀과 협업해오는 것이 있었다. 
> 
> 제플린에 올려진 UI를 보고 레이아웃 파일을 작성하다가 __selector__ 로 구현하는 것이 편할 것 같은 뷰를 발견했다.
>
> ![01](https://user-images.githubusercontent.com/31889335/69126021-864c6500-0aea-11ea-8b6f-b56b1df37c65.PNG) --> 이와 같은 그림에서 별모양 아이콘을 클릭하면 좋아요가 반영되면서 노란색으로 채워진 별모양 이미지로 바뀌어야 했다. 이 부분을 selector로 구현하기로 했다!! 😐
>
> 안드로이드 개발자 사이트의 Docs에서 [Selector 부분](https://developer.android.com/guide/topics/resources/drawable-resource#StateList) 을 띄워놓고 Selector에 대해 알아보면서 개발해봤다.


<br>

- _Selector가 뭐지?_

    일단, 안드로이드 개발자 사이트에 들어가서 Selector를 검색해보니 Selector에 대한 문서를 발견할 수 있었다.

    ![02](https://user-images.githubusercontent.com/31889335/69126339-505bb080-0aeb-11ea-9854-0734ebd607aa.PNG)

    이렇게 Selector에 대한 문서는 docs의 목차에서 Resource types 안의 Drawable 에서 볼 수 있다. 

    즉, Selector의 소속은 안드로이드 Resource 중의 하나인 Drawable 안에 있다는 뜻이다!

    ![03](https://user-images.githubusercontent.com/31889335/69126341-52be0a80-0aeb-11ea-8f59-525d6a160fab.PNG)

    위 그림과 같이, Drawable 문서안에서도 Drawable에 속하는 것들을 쭈루룩 소개해놓았는데 그 중 Selector에 대한 설명은 State list 라는 부분에서 발견할 수 있었다! 

    <br>

- _그럼 State list가 뭘까?_

    안드로이드 문서에 따르면 StateListDrawable은 xml 문서안에서 정의되는 Drawable 객체이다. 나는 이 말을 StateListDrawable 객체를 사용하려면 xml파일에서 정의해야 한다고 이해했다.

    StateListDrawable은 객체의 상태에 따라 같은 그래픽을 여러 다른 이미지로 나타내야 할 때 사용된다. 즉, 객체의 상태가 바뀌면 이미지가 바뀌어야 하는 경우!

    예를 들어 Button은 버튼이 눌렸을 때, 버튼에 focus가 되었을 때 등등 여러 상태를 가질 수 있다. 그래서 이럴 때 state list drawable을 사용하면 각 상태에 따라 버튼에 다른 background image를 적용할 수 있다!

    <br>

- _state list에 대해서는 알았다! 어떻게 state list를 구현하지?_

    일단 state list를 xml 파일 안에서 나타낼 수 있다. 

    이 xml 파일은 아래 그림에서 알 수 있듯이

    ![04](https://user-images.githubusercontent.com/31889335/69128287-45a31a80-0aef-11ea-8f93-2ce1fe80356b.PNG)

    안드로이드 프로젝트의 res 폴더 안에 있는 drawable 폴더 안에 생성하면 된다.
    
    state list에서 사용될 각각의 그래픽들은 __\<selector>__ 요소 안에 존재하는 __\<item>__ 요소들로 나타내진다. 

    각 __\<item>__ 에는 객체의 상태를 나타내는 다양한 속성들을 줄 수 있다.

    객체의 상태가 변하는 동안, state list로 정의한 item들을 첫 번째 item에서부터 마지막 item까지 쭉 훑는다. 그리고 현재 상태와 매칭되는 첫 item을 만나면 그 item이 사용되는 것이다.

    ![05](https://user-images.githubusercontent.com/31889335/69128378-8307a800-0aef-11ea-91ae-672683c6181c.PNG)

    위 코드에서 볼 수 있듯이 selector에도 true나 false값을 줄 수 있는 여러 속성이 있고, item 에도 true나 false값을 줄 수 있는 여러 속성이 있다!

    각 속성에 대한 설명은 이 문서를 더 자세히 읽어보면 알 수 있다.

    selector에 대한 xml 파일을 만든 후, 이 selector을 적용할 뷰의 background 속성 값으로 selector xml 파일을 적용시켜주면 된다.

    예를 들어 위 코드처럼 되어 있는 xml 파일의 이름이 selector.xml 이라고 하고, 이 selector을 button에 적용시켜 button의 상태에 따라 이미지가 바뀌게 하고 싶다면??

    해당 button이 작성되어 있는 xml 파일에 있는 이 button의 background 속성 값을 __@drawable/selector__ 으로 하면 된다.
    
    <br>







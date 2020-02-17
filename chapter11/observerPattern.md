상속 원리에 근거한 행위 패턴중 하나

어떤 객체가 자기 상태값을 바꿀 때 다른 객체들에게 그 사실을 알리는 것

한 객체(subject)의 상태값이 바뀌면 나머지 연관 객체(observer)들이 이를 통지받아 자동으로 업데이트 될 수 있도록 객체 간 일대다 관계를 맺는 것

subject - 자기 상태를 바꾸는 객체, 주체

observer - 상태 변경을 통지받는 객체, 옵저버

###상태-데이터 전달 방식

- PUSH
    - subject가 observer에게 상태를 보내는 방식
- PULL
    - observer의 구현체들이 상태값을 요청하거나 가져가는 방식 - subject에 상태값에 대한 getter을 열어줌

###옵저버패턴이 활용되는 분야

- UI 프레임워크
    - 리스너 패턴( listnener pattern) 이라고도 함
    - 이벤트 리스너 등
- MVC 패턴
    - 내부적으로 옵저버 패턴 사용
- 분산 이벤트 핸들링 시스템


###자바는 observer를 자체 지원

###Observer

상태변화에 따른 로직을 구현
```
    public interface Observer {
        void 업데이트();
    }
    
    public class 구독자 implements Observer {
    
        @Override
        public void 업데이트() {
    			//...
    			System.out.println("newItem");
        }
    }
```
###Observable

각 옵저버들에게 상태변화를 알리는 메서드를 포함
```
    public interface Observable {
    
        void 구독하기(Observer o);
    
        void 구독해지(Observer o);
    
        void 알리기();
    }
    
    public class NewsAgency implements Observable {
    
     ****  
        private boolean newConts;
    
        public boolean isNewConts() {
            return newConts;
        }
    
        public void newConts() {
            알리기();
        }
    
        @Override
        public void 구독하기(Observer o) {
            //...
        }
    
        @Override
        public void 구독해지(Observer o) {
            //...
        }
    
        @Override
        public void 알리기() {
    	      //...
    				observerList.forEach(Observer::업데이트);
        }
    }

    NewsAgency newsAgency = new NewsAgency();
    구독자 구독자1 = new 구독자();
    
    newsAgency.구독하기(구독자1);
    newsAgency.newConts(); //신규아이템생성
    
    // 구독자 : newItem 출력

```


##자바 EE에서는 @observer 와 Event 인터페이스롤 이용

- @observer 가 붙은 타입의 객체에 발생한 이벤트를 메서드가 리스닝 하게 함

###Observable
```    
    public class EventService {
    	
    		@Inject
        private String message;
    
    		@Inject
    		Event<String> event;
    	
    		public void startService(){
    				event.fire("start Service" + message );
    		}
    }
```

###Observer

- @Observer 가 붙은 타입의 객체에 발생한 이벤트를 메서드가 리스닝하게 만듬
```
    public class TraceObserver{
    		//String 타입의 이벤트를 관찰하는 메서드로 변함
    		public void serviceTrace( @Observer String message){
    				
    				System.out.println("메세지" + message);
    		}
    }
    
    //startService를 호출 -> 이벤트 변화를 캐치해서 serviceTrace 실행
```


장점

- 상호 의존성이 낮아 변화에 대해 유연함 - 느슨한 결합
    - observer에 추가/제거가 쉬움

단점

- Subject 를 구현하기 위해서는 Observable 을 반드시 상속 받아야 함
    - 추상클래스가 아닌 일반 클래스라 나중에 필요한 기능을 확장하기 위해 상속받기 어려움

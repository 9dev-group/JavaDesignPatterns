# AOP (Aspect-Oriented-Programming)

1. 공통된 기능을 재사용하기 위한 기법

   상속을 통해서 해결하기 힘든경우에 사용 \
   예를 들면 서로 성격이 많이 다른 클래스에서 같은 로그를 남기는 경우 \
   상속을 통한 코드 재사용이 어렵다.

2. 로그, 보안, 등에 사용

   어디에나 공통으로 사용하는 기능인 경우에 사용하면 좋다.

3. 관점(관심) 지향 프로그래밍

   로깅 등의 공통 기능을 모아서 관리하고 각 코드는 본래의 목적에 집중

- Target

  부가기능을 부여 받을 대상

- Aspect

  부가기능

- Advice

  부가기능의 구현체, 순수하게 부가 기능에 집중

- PointCut

  부가기능을 적용하는 지점을 결졍

- JoinPoint

  Target과 Aspect가 결합되는 지점

```java
// AspectJ
@Aspect
public class Advice {

	@Before("within (io.hashfunc.controller.Controller)")
	public void before() {
		System.out.println("before");
	}

	@After("execution(* io.hashfunc.controller.Controller.get*(..))")
	public void after() {
		System.out.println("after");
	}
}
```

```java
// Spring AOP
@Component
@Aspect
public class Advice {

@Around("execution(* io.hashfunc.controller.Controller.get*(..))")
public Object logger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
  long begin = System.currentTimeMillis();

  Object ret = proceedingJoinPoint.proceed();

  System.out.println(System.currentTimeMillis() - begin);

  return ret;
  }
}
```

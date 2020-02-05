package design.pattern.facade.example1;

public class Client {

	public static void main(String[] args) {
       FacadeService facadeService = new FacadeService();
       facadeService.work("Client");
	}

}

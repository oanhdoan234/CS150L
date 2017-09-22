public class HelloWorld{

	public static void main(String[] args){
		HelloWorld h = new HelloWorld();
		if (args.length > 1 || args.length == 0){
			System.out.println("Sorry you don't want to say hello");
		} else {
			try{
				int num = Integer.parseInt(args[0]);
				h.printHello(num);
			} catch (Exception e){
				System.out.println(e);
			}
		}
	}

	public void printHello(int num){
		for (int i = 0; i < num; i ++){
			System.out.println("Hello World");
		}
	}

}
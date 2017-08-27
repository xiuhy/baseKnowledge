package com.yhx.basejava.polyMorphic;

//方法金泰分配演示
public class DynamicDispatch {

	static class Human{
		
		 void sayHello(Human man){
			 System.out.println("hello ,guys");
		}
		 
		void sayHello(Man man) {
			System.out.println("human mam say hello");			
		}
		
//		void sayHello(Woman man) {
//			System.out.println("human woman say hello");			
//		}
		
	}
	
	static class Man extends Human{

		 void sayHello(Human man){
			 System.out.println("man say hello,guys");
		}
		 
		void sayHello(Man man) {
			System.out.println("man say hello");			
		}
		
		void sayHello(Woman man) {
			System.out.println("woman say hello");			
		}
		
	}
	
	static class Woman extends Human{
		
		void sayHello(Woman man) {
			System.out.println("woman say hello");			
		}
		
		
	}
	
	
	public static void main(String[] args){
		
		Human man =new Man();
		Human woman=new Woman();
		
		man.sayHello(woman);  //guy
		woman.sayHello(man);  //
		man.sayHello(new Woman()); // guy

		
	}
}

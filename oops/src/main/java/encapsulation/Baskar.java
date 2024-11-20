package encapsulation;

public class Baskar {

	   public static void main(String[] args) {
		   
		   MySelf my = new MySelf();
		   System.out.println(my.atm_pin);
		   System.out.println(my.pswd);
		   my.set_atm_pin();
		   my.take_bike();
	}
}

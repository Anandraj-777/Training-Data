package encapsulation;

public class MySelf {

	 public int atm_pin = 1234;
	 public int pswd = 3214;
	  
	public static void main(String[] args) {

		 MySelf my = new MySelf();
	     System.out.println(my.atm_pin);
	     System.out.println(my.pswd);
	     my.set_atm_pin();
	}
	
	 public void set_atm_pin () {
		System.out.println("pswd theriyathu podaa");
	}
    public void take_bike () {
    	 System.out.println("Ridingggg");
     }
     
}

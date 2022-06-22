package roman.skrypnyk.java_8_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Buyer{

	String name;
	int amount;

	public Buyer(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}
}

public class Function_Example_02 {

	public static void main(String[] args) {

		List<Buyer> listOfBuyers = new ArrayList<>();
		listOfBuyers.add(new Buyer("Momo", 2500));
		listOfBuyers.add(new Buyer("Bairak", 999));
		listOfBuyers.add(new Buyer("Mari", 3210));

		Function<Buyer, Float> countOfDiscountPoints = x -> {
			int getAmount = x.amount;
			if(getAmount > 1000){
				return (float) ((getAmount * 10) / 100);
			}else {
				return (float) ((getAmount * 5) / 100);
			}
		};

		for(Buyer employee : listOfBuyers){
			System.out.println( "Fot buyer: " + employee.name + " is apply " + countOfDiscountPoints.apply(employee) + " points.");
		}


	}

}

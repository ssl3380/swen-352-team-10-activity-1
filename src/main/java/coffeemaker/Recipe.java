package coffeemaker;

import coffeemaker.exceptions.RecipeException;

/**
 * @author   Sarah Heckman
 */
public class Recipe {
    private String name;
    private int price;
    private int amtCoffee;
    private int amtMilk;
    private int amtSugar;
    private int amtChocolate;
    
    /**
     * Creates a default recipe for the coffee maker.
     */
    public Recipe() {
    	this.name = "";
    	this.price = 0;
    	this.amtCoffee = 0;
    	this.amtMilk = 0;
    	this.amtSugar = 0;
    	this.amtChocolate = 0;
    }
    
    /**
	 * @return   Returns the amtChocolate.
	 */
    public int getAmtChocolate() {
		return amtChocolate;
	}
    /**
	 * @param chocolate   The amtChocolate to set.
	 */
    public void setAmtChocolate(String chocolate) throws RecipeException {
    	int amtChocolate;
    	try {
    		amtChocolate = Integer.parseInt(chocolate);
    	} catch (NumberFormatException e) {
    		throw new RecipeException("Units of chocolate must be a positive integer");
    	}
		if (amtChocolate > 0) {
			this.amtChocolate = amtChocolate;
		} else {
			throw new RecipeException("Units of chocolate must be a positive integer");
		}
	}
    /**
	 * @return   Returns the amtCoffee.
	 */
    public int getAmtCoffee() {
		return amtCoffee;
	}
    /**
	 * @param coffee   The amtCoffee to set.
	 */
    public void setAmtCoffee(String coffee) throws RecipeException {
    	int amtCoffee;
    	try {
    		amtCoffee = Integer.parseInt(coffee);
    	} catch (NumberFormatException e) {
    		throw new RecipeException("Units of coffee must be a positive integer");
    	}
		if (amtCoffee > 0) {
			this.amtCoffee = amtCoffee;
		} else {
			throw new RecipeException("Units of coffee must be a positive integer");
		}
	}
    /**
	 * @return   Returns the amtMilk.
	 */
    public int getAmtMilk() {
		return amtMilk;
	}
    /**
	 * @param milk   The amtMilk to set.
	 */
    public void setAmtMilk(String milk) throws RecipeException{
    	int amtMilk;
    	try {
    		amtMilk = Integer.parseInt(milk);
    	} catch (NumberFormatException e) {
    		throw new RecipeException("Units of milk must be a positive integer");
    	}
		if (amtMilk > 0) {
			this.amtMilk = amtMilk;
		} else {
			throw new RecipeException("Units of milk must be a positive integer");
		}
	}
    /**
	 * @return   Returns the amtSugar.
	 */
    public int getAmtSugar() {
		return amtSugar;
	}
    /**
	 * @param sugar   The amtSugar to set.
	 */
    public void setAmtSugar(String sugar) throws RecipeException {
    	int amtSugar;
    	try {
    		amtSugar = Integer.parseInt(sugar);
    	} catch (NumberFormatException e) {
    		throw new RecipeException("Units of sugar must be a positive integer");
    	}
		if (amtSugar > 0) {
			this.amtSugar = amtSugar;
		} else {
			throw new RecipeException("Units of sugar must be a positive integer");
		}
	}
    /**
	 * @return   Returns the name.
	 */
    public String getName() {
		return name;
	}
    /**
	 * @param name   The name to set.
	 */
    public void setName(String name) {
    	if(name != null) {
    		this.name = name;
    	}
	}
    /**
	 * @return   Returns the price.
	 */
    public int getPrice() {
		return price;
	}
    /**
	 * @param price   The price to set.
	 */
    public void setPrice(String price) throws RecipeException{
    	int amtPrice;
    	try {
    		amtPrice = Integer.parseInt(price);
    	} catch (NumberFormatException e) {
    		throw new RecipeException("Price must be a positive integer");
    	}
		if (amtPrice > 0) {
			this.price = amtPrice;
		} else {
			throw new RecipeException("Price must be a positive integer");
		}
	} 
    
    /**
     * Returns the name of the recipe.
     * @return String
     */
    public String toString() {
    	return name;
    }

	/**
	 * Indicates whether another object is "equal to" this one.  Only a
	 * {@link Recipe} object whose {@link #name} is the same as this one is
	 * considered "equal to" this one.
	 *
	 * @param obj the reference object with which to compare
	 * @return {@code true} if this object is the same as the {@code obj}
	 * argument; {@code false} otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		//NO FUNCTIONAL DEFECTS

		//OK: == operator checks for mem location; if pt to same memory then must have same name value
		if (this == obj)
			return true;
		//OK: if null then nothing to compare
		if (obj == null)
			return false;
		//OK: if not same class at runtime then nothing to compare (test case would be parent/child class)
		//we will never enter this control structure as there are no parent/child class relations with Recipe
		if (getClass() != obj.getClass())
			return false;

		final Recipe other = (Recipe) obj;

		// name is never null; we will never enter this control structures true flow
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		// final int prime = 31;
		// int result = 1;
		// result = prime * result + ((name == null) ? 0 : name.hashCode());
		// Formula above can be optimized
		// name is never equal to null in lifecycle of recipe object - proof in setName()
		// Using PEMDAS we can further optimize
		// In ( (prime * result) + name.hashCode()) prime * result is always 31 so simplify to prime + name,hashCode()
		// Prime is just a constant so no practical affect to uniqueness of hashcode so can be simplified to name.hashCode()
		// Optimized formula: int result = name.hashCode();
		return name.hashCode();
	}
}

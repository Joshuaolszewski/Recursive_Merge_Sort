
//Joshua Olszewski 
//This is a Currency Simulator 
public class USD 
{
    private int whole;
    private int fraction; 
    private String currencyName;
    
    //default constructor 
    public USD()
    {
        this.whole = 0; 
        this.fraction = 0;
        this.currencyName = "USD";
    }
    
    //variable constructor 
    public USD(int whole, int fraction, String currencyName)
    {
        this.whole = whole; 
        this.fraction = fraction;
        this.currencyName = currencyName;
    }
    
    //copy constructor 
    public USD(USD copy)
    {
        this.whole = copy.getWhole();
        this.fraction = copy.getFraction(); 
        this.currencyName = copy.getName(); 
    }
    
    //java destructor- not 100% sure how to use
    protected void finalize()
    {
        
    }
    
    //getter method for whole
    public int getWhole()
    {
        return this.whole; 
    }
    
    //getter method for fraction
    public int getFraction()
    {
        return this.fraction; 
    }
    
    //getter method for name 
    public String getName()
    {
        return this.currencyName; 
    }
    
    //setter method for whole 
    public void setWhole(int wholeAmount)
    {
        this.whole = wholeAmount; 
    }
    
    //setter method for fraction
    public void setFraction(int fractionAmount)
    {
        this.fraction = fractionAmount; 
    }
    
    //setter method for name 
    public void setName(String currencyName)
    {
        this.currencyName = currencyName; 
    }
    
    /* Compares two USD object's name type ex) USD or C2D.
     
    Precondition: the two USD objects need to have identical string names 
    Postcondition: will return a boolean variable true or false 
    return: void
    PseudoCode: 1) if obj 1 name = obj 2 name 
                    1) return true 
                2) else
                    1) return false
    */
    
    
    public boolean sameType(USD other)
    {
        if(getName().equals(other.getName()))
        {
            return true;
        }
        else
        {
            return false; 
        }
    }
    
    /* adds currency to a usd object using another usd object. 
     
    Precondition: Needs to be the same two currencies. 
    Postcondition: will update the values of the added to usd object to reflect the addition of money.
    return: void 
    PseudoCode: 1) if obj 1 type = obj 2 type
                    1) if fraction 1 + fraction 2 > 99
                        1) whole # = whole #1 + whole #2 + (fraction 1 + fraction 2 / 100) 
                        2) fraction = fraction 1 + fraction 2 % 100
                    2) else
                        1)whole = whole 1 + whole 2
                        2)fraction = frac 1 + frac 2
                2) not the same currency 
    */
    public void addCurrency(USD other)
    {
        if(sameType(other))
        {
            if(getFraction() + other.getFraction() > 99)
            {
                setWhole(getWhole() + other.getWhole() + (int)Math.floor(((getFraction() + other.getFraction()) / 100)));
                setFraction((getFraction() + other.getFraction()) % 100);
            }
            else
            {
                setWhole(getWhole() + other.getWhole());
                setFraction(getFraction() + other.getFraction());
            }  
        }
        else
        {
            System.out.println("These are not the same Currencies");
        }
    }
    
    /* subtracts currency from a usd object using another usd object. 
     
    Precondition: Needs to be the same two currencies. 
    Postcondition: will update the values of the subtracted from usd object to reflect the addition of money.
    return: void 
    PseudoCode: 1) if obj 1 type = obj 2 type
                    1) if obj 1 is >= to obj 2
                        1) if fraction 1 - fraction 2 < 0
                            1) whole # = whole #1 - whole #2 -1 
                            2) fraction = 100 - +(fraction 1 - fraction 2)
                        2) else
                            1)whole = whole 1 - whole 2
                            2)fraction = frac 1 - frac 2
                    2) else
                        1) cant subtract
                2) not the same currency 
    */
    public void subtractCurrency(USD other)
    {
        if(sameType(other))
        {
            if(isLargerThan(other) || isEqual(other))
            {
                if(getFraction() - other.getFraction() < 0)
                {
                    setWhole(getWhole() - other.getWhole() -1);
                    setFraction((100-Math.abs(getFraction() - other.getFraction())));
                }
                else
                {
                    setWhole(getWhole() - other.getWhole());  
                    setFraction(getFraction() - other.getFraction());
                }                     
            }
            else
            {
                System.out.println("");
                System.out.println("Cant subtract");
                System.out.println("");
            }
        }
        else
        {
            System.out.println("These are not the same Currencies");
        }
    }
    
    /* checks to see if the values of two same name usd objects are equal
     
    Precondition: Needs to be the same two currencies. 
    Postcondition: None
    return: boolean 
    PseudoCode: 1) if obj 1 type = obj 2 type
                    1) if obj 1 whole = obj 2 whole and obj 1 frac = obj 2 frac
                        1) true 
                    2) else
                        1) false
                2) not the same currency 
    */
    public boolean isEqual(USD other) 
    {
        if(sameType(other))
        {
            if(getWhole() == other.getWhole() && getFraction() == other.getFraction())
            {
                return true;
            }
            else
            {
                return false; 
            }
        }
        else
        {
            System.out.println("These are not the same Currencies");
            return false; 
        }
    }
    
    /* checks to see if the values of obj 1 is larger than an inputed obj 2
     
    Precondition: Needs to be the same two currencies. 
    Postcondition: None
    return: boolean 
    PseudoCode: 1) if obj 1 type = obj 2 type
                    1) if whole 1 > whole 2
                        1) true 
                    2) else if whole1 = whole 2 and frac 1 > frac 2
                        1) true
                    3)else
                        1) false
                 2) not the same currency 
    */
    public boolean isLargerThan(USD other)
    {
        if(sameType(other))
        {
            if(getWhole() > other.getWhole()) 
            {
                return true;
            }
            else if(getWhole() == other.getWhole() && getFraction() > other.getFraction())
            {
                return true;
            }
            else 
            {
                return false; 
            }
        }
        else
        {
            System.out.println("These are not the same Currencies");
            return false; 
        }
    }
    
    /* checks to see if the values of obj 1 is less than an inputed obj 2
     
    Precondition: Needs to be the same two currencies. 
    Postcondition: None
    return: boolean 
    PseudoCode: 1) if obj 1 type = obj 2 type
                    1) if whole 1 < whole 2
                        1) true 
                    2) else if whole1 = whole 2 and frac 1 < frac 2
                        1) true
                    3)else
                        1) false
                 2) not the same currency 
    */
    public boolean isLessThan(USD other)
    {
        if(sameType(other))
        {
            if(getWhole() < other.getWhole()) 
            {
                return true;
            }
            else if(getWhole() == other.getWhole() && getFraction() < other.getFraction())
            {
                return true;
            }
            else 
            {
                return false; 
            }
        }
        else
        {
            System.out.println("These are not the same Currencies");
            return false; 
        }
    }
    
    /* returns a string of info regarding current usd object 
     
    Precondition: Needs to be a usd object 
    Postcondition: none
    return: String
    PseudoCode: 1) return whole + frac + name
                
    */
    public String getInfo()
    {
        return getWhole() + "." + getFraction() + " " + getName();
    }
} 
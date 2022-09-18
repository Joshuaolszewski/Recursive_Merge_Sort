
//Joshua Olszewski 
//This is a Currency Simulator 
public class C2D extends USD
{
    private double conversionFactor; 
    
    //default constructor 
    public C2D()
    {
        this.conversionFactor = 0.74;
    }
      
    //argument constructor 
    public C2D(int whole, int fraction, String currencyName)
    {
        super(whole, fraction, currencyName);
        this.conversionFactor = 0.74;
    }
    
    //copy constructor 
    public C2D(C2D copy)
    {
        super(copy.getWhole(), copy.getFraction(), copy.getName()); 
    }
    
    //getter for conversionfactor
    public double getConversionFactor()
    {
        return this.conversionFactor; 
    }
    
    //setter for conversionfactor
    public void setConversionFactor(double factor)
    {
        this.conversionFactor = factor; 
    }
    
    /* takes a c2d object and converts it to a usd object with adjusted whole and fractional values 
     
    Precondition: Needs to be a c2d object 
    Postcondition: returns a usd object with adjusted value: c2d value * conversion factor 
    return: USD
    PseudoCode: 1) total amount = c2d object whole + fraction * conversion factor in the form of: x.yz
                2) whole = x
                3) fraction = yz
                4) string = USD
                5) return new usd object
    */
    public USD convertToUSD()
    {
        double totalAmount = Math.floor((getWhole() + ((double)getFraction()/100)) * conversionFactor * 100.0) / 100.0;
        
        int whole = (int)Math.floor(totalAmount);
        int fraction = (int)((totalAmount - whole)*100);
        String name = "USD";
      
        return(new USD(whole, fraction, name));
    }
    
    /* takes a USD object and converts it to a c2d object with adjusted whole and fractional values 
     
    Precondition: Needs to be a usd object 
    Postcondition: returns a c2d object with adjusted value: c2d value / conversion factor 
    return: USD
    PseudoCode: 1) total amount = usd object whole + fraction / conversion factor in the form of: x.yz
                2) whole = x
                3) fraction = yz
                4) string = C2D
                5) return new C2D object
    */
    public C2D convertToC2D()
    {
        double totalAmount = Math.floor((getWhole() + ((double)getFraction()/100)) / conversionFactor * 100.0) / 100.0;
        
        int whole = (int)Math.floor(totalAmount);
        int fraction = (int)((totalAmount - whole)*100);
        String name = "C2D";
      
        return(new C2D(whole, fraction, name)); 
    }
    
    //polymorphed getInfo
    public String getInfo()
    {
        return getWhole() + "." + getFraction() + " " + getName() + " " + getConversionFactor();
    }
}
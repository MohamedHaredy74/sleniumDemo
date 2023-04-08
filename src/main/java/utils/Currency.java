package utils;

public enum Currency {

    //[Euro , US Dollar]
    EURO("Euro"),USDOLAR("US Dollar");
    private String value;

    Currency(String value)
    {
        this.value=value;

    }
    @Override
    public String toString()
    {
        return value;
    }


}

public class CalcApp {
    public double addValues(double val1, double val2){
        return val1 + val2;
    }
    public double subtValue(double val1, double val2){
        return val1 - val2;
    }
    public double toThePower (int val1, int val2){
        if(val2 >= 0){
        return Math.pow(val1, val2);
    }else{
            throw new ArithmeticException();
        }
    }
    public double divValue(double v1, double v2){
        if(v2>0){
        return v1/v2;
    }else{
            throw new ArithmeticException();
        }
    }
    public double squareRoot(double v1){
        if(v1>0){
        return Math.sqrt(v1);
    }else{
            throw new ArithmeticException();

        }
    }
}
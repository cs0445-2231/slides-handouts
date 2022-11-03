public class Misc {

    public static void main(String[] args){
        new Misc();
    }

    public Misc(){
        towersOfHanoi(3, 0, 1, 2);
        System.out.println(better(90));
        System.out.println(tailRecursive(90));
    }

    public void towersOfHanoi(int n, int start, int temp, int end){
        if(n > 0){
            towersOfHanoi(n-1, start, end, temp);
            System.out.println("Move one disk form " + start + " to " + end);
            towersOfHanoi(n-1, temp, start, end);    
        }    
    }

    /**
     *  Lab 7 
     */
    public long better(int k){
        if(k==0) return 0;
        if(k==1) return 1;
        long first = better(k/2);
        long second = better(k/2 - 1);
        if(k%2 == 0){//even
            return first*first + 2*first*second;
        } else {
            return 2*first*first + 2*first*second + second*second;
        }
    }

    public long tailRecursive(int n){
        return helper(n, 1, 0);
    }

    private long helper(long n, long first, long second){

        long fi, se;
        if(n == 0){
            return second;
        }

        if(n==1){
            return first;
        }
        if(secondMSB(n) == true){
            //first is F(n/2)
            //second is F(n/2-1)
            fi = 2*first*first + 2*first*second + second*second;
            se = first*first + 2*first*second;
        } else {
            fi = first*first + 2*first*second;
            se = first*first + second*second;
        }
        return helper(reduceBy2ndMSB(n), fi, se);
    }

     /**
     * secondMSB - Determine the value of the second most significant bit.
     * 
     * @param  n   A positive integer 
     * @return     True if the second most significant bit is 1, false otherwise.
     */    
    public boolean secondMSB(long n)
    {
        while(n>4)
            n = n/2;
        return (n%2==1);
    }


    /**
     * reduceBy2ndMSB - Reduce the number by removing the second most significant bit
     * from the representation.
     * 
     * @param  n   A positive integer > 1
     * @return     The integer value equivalent to removing the 2nd most significant bit
     *              from n.
     */    
    public long reduceBy2ndMSB(long n)
    {
        long result = 1;
        long lsb;
        
        if(n>3)
        {
            lsb = n%2;
            result = reduceBy2ndMSB(n/2);
            result = result*2 + lsb;
        }
       
        return result;
    }
}
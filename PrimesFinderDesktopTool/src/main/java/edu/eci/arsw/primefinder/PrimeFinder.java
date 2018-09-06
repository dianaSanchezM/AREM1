package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class PrimeFinder extends Thread{
        private BigInteger _a;
	private  BigInteger _b;
        private PrimesResultSet prs;

    public PrimeFinder(BigInteger _a, BigInteger _b, PrimesResultSet prs) {
        this._a = _a;
        this._b = _b;
        this.prs = prs;
    }
	
        
	public void run(){
            
                BigInteger a=_a;
                BigInteger b=_b;

                MathUtilities mt=new MathUtilities();
                
                int itCount=0;
            
                BigInteger i=a;
                while (i.compareTo(b)<=0){
                    itCount++;
                    if (mt.isPrime(i)){
                        prs.addPrime(i);
                    }

                    i=i.add(BigInteger.ONE);
                }
                
	}
	
	
	
	
	
}

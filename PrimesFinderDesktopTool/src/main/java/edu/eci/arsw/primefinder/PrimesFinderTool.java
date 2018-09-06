package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

	public static void main(String[] args) {
		            
            int maxPrim=1000;
            
            ArrayList<PrimeFinder> primeThreads = new ArrayList<>();
            
            PrimesResultSet prs=new PrimesResultSet("john");
            
            BigInteger from = new BigInteger("1");
            BigInteger to = new BigInteger("10000");
            
            int range= (to.intValue()-from.intValue())/4;
            for (int i=0; i<4;i++){
                primeThreads.add(new PrimeFinder(from.setBit(from.intValue()*i), to.setBit(to.intValue()*(i+1)), prs));
            }
            
            for (PrimeFinder p:primeThreads){
                p.start();
            }
            
            for (PrimeFinder p:primeThreads){
                try {
                    p.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            System.out.println("Prime numbers found:");
            
            System.out.println(prs.getPrimes());
            
            
            /*while(task_not_finished){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        System.out.println("Idle CPU ");
                    }
                    else{
                        System.out.println("User working again!");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
                        
            
            
            
            
	}
	
}



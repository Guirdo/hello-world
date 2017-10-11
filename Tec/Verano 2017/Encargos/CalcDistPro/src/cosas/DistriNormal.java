package cosas;

public class DistriNormal {
    
    public static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // use Horner's method
        double ans = 1 - t * Math.exp( -z*z   -   1.26551223 +
                                            t * ( 1.00002368 +
                                            t * ( 0.37409196 + 
                                            t * ( 0.09678418 + 
                                            t * (-0.18628806 + 
                                            t * ( 0.27886807 + 
                                            t * (-1.13520398 + 
                                            t * ( 1.48851587 + 
                                            t * (-0.82215223 + 
                                            t * ( 0.17087277))))))))));
        
        ans = Math.rint(ans*10000)/10000;
        
        if (z >= 0) return  ans;
        else        return -ans;
    }
    
    public static double calculaPunto(double v){ //funcion de densidad de probabilidad normal
		double N=Math.exp(-Math.pow(v, 2)/2)/Math.sqrt(2*Math.PI);
                N = Math.rint(N*10000)/10000;
		return N;
	}
    
    public static double calculaZ(double x,double media,double ro){
        double z = (x-media)/ro;
        z = Math.rint(z*10000)/10000;
        return z;
    }
    
    
}

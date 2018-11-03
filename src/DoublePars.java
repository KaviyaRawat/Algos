public class DoublePars
{





    static int[] arbitrage(String[] quotes) {

        int[] results = new int[quotes.length];//();

        for(int i=0; i<quotes.length; i++){
            double result = 100000;
            for(int j=0; j<3; j++){
                result = result/Double.parseDouble(quotes[j]);
            }
            if(result < 100000){
                results[i] = 0;
            }else
                results[i] = (int) Math.round(100000 - (int)result);
        }

        return results;

    }

    public static void main(String[] args) {
        arbitrage(new String[]{"1.189998", "1.09877", "0.8"});
    }
}

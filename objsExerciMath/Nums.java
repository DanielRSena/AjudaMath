package objsExerciMath;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Nums {

    static Random random = new Random();
    int until = 0;
    
    public static double arredonda(double num){

        BigDecimal resNum = BigDecimal.valueOf(num).setScale(2, RoundingMode.HALF_UP);
        num = resNum.doubleValue();
        return num;
    }

    public static int intRandom(int until){

        int num;
        if (until <= 0) num = random.nextInt(10) + 1; //se não colocar o intervalo, será de 1 até 10
        else num = random.nextInt(until) + 1; //se colocar, será do 1 até o número especificado
        return num;
    }

    public static double doubleRandom(int until){

        double num;
        if (until <= 0) num = random.nextDouble(10) + 1; //se não colocar o intervalo, será de 1 até 10
        else num = random.nextDouble(until) + 1; //se colocar, será do 1 até o número especificado
        return num;
    }
}

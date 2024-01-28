package objExerciMath;

import java.util.Random;

public class Nums {

    static Random random = new Random();
    int until = 0;
    

    public static int intRandom(int until){

        int num;
        if (until == 0) num = random.nextInt(10) + 1; //se não colocar o intervalo, será de 0 até 1
        else num = random.nextInt(until); //se colocar, será do 0 até o número especificado

        return num;
    }

    public static double doubleRandom(){

        double doubleNum = Math.random() * 10 + 1;
        int num = (int) doubleNum;
        return num;
    }
}

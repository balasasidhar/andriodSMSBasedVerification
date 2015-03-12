package com.balasasidhar.balasasidhark.smsverification;

import android.content.Context;

import java.util.Random;

/**
 * Created by BALA SASiDHAR K on 12-Mar-15.
 */
public class GenerateUniqueCode {

    public static int generate(int[] codeReceived){

        int uniqueCode = random(codeReceived);
        return uniqueCode;
    }

    public static int  random(int[] code){

        Random rand = new Random();
        int randomNum = rand.nextInt((9 - 0) + 1) + 0;
        boolean flag = checkSum(randomNum,code);
        if(flag)
            return random(code);
        else
            return randomNum;
    }

    private static boolean checkSum(int randomNum, int[] code) {
        for(int i=0;i<3;i++){
            if(code[i] == randomNum)
                return true;
        }
        return false;
    }
}

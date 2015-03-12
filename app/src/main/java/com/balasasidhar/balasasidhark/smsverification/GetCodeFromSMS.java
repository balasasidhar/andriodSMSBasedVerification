package com.balasasidhar.balasasidhark.smsverification;

/**
 * Created by BALA SASiDHAR K on 12-Mar-15.
 */
public class GetCodeFromSMS {
    public static int getCodeFromSMS(String sms){
        int codeNumber;
        int index = sms.indexOf("SASI");
        int startIndex = index + 5;
        int endIndex =  index+8;

        String code = sms.substring(startIndex, endIndex);
        codeNumber = Integer.parseInt(code);

        return codeNumber;
    }

    public static int[] extractDigits(int codeReceived) {
        int i=2;
        int code[]={0,0,0};
        while (codeReceived > 0) {
            code[i] = codeReceived % 10;
            codeReceived = codeReceived / 10;
            i--;
        }
        return code;
    }
}

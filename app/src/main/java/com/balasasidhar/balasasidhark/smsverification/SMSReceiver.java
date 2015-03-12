package com.balasasidhar.balasasidhark.smsverification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by BALA SASiDHAR K on 12-Mar-15.
 */
public class SMSReceiver extends BroadcastReceiver{
    String msgBody;
    int codeReceived;
    int[] codeArray = {0,0,0};

    @Override
    public void onReceive(Context context, Intent intent) {
        MainActivity mainActivity = ((MyApplication) context.getApplicationContext()).mainActivity;
        final Bundle bundle = intent.getExtras();
        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    msgBody = currentMessage.getDisplayMessageBody();
                    codeReceived = GetCodeFromSMS.getCodeFromSMS(msgBody);

                    codeArray = GetCodeFromSMS.extractDigits(codeReceived);

                    mainActivity.msgBody = msgBody;
                    mainActivity.codeReceived = codeReceived;
                    mainActivity.codeReceivedArray = codeArray;

                    mainActivity.e0.setText(""+codeArray[0]);
                    mainActivity.e1.setText(""+codeArray[1]);
                    mainActivity.e2.setText(""+codeArray[2]);

                } // end for loop
            } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);
        }
    }
}

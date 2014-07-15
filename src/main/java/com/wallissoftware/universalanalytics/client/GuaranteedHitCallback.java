package com.wallissoftware.universalanalytics.client;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.wallissoftware.universalanalytics.shared.HitCallback;

public class GuaranteedHitCallback implements HitCallback {

    private final HitCallback callback;

    private boolean hasRun;

    public GuaranteedHitCallback(final HitCallback callback) {
        this.callback = callback;
        Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {

            @Override
            public boolean execute() {
                callback.onCallback();
                return false;
            }
        }, 350);
    }


    @Override
    public void onCallback() {
        if (!hasRun) {
            hasRun = true;
            callback.onCallback();
        }

    }

}

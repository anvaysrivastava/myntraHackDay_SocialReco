package com.anprache.social.processor.processes;

import com.anprache.social.processor.Processor;

/**
 * Created by anvay.srivastava on 26/04/15.
 */
public class DummyProcess implements Process{
    @Override
    public void run() {
        System.out.println("Dummy Process Starts");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Dummy Process Ends");

    }
}

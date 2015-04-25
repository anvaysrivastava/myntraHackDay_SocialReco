package com.anprache.social.processor;

import com.anprache.social.processor.processes.DummyProcess;

/**
 * Created by anvay.srivastava on 26/04/15.
 */
public class Processor {
    public static void main(String args[]){
        while(true){
            System.out.println("Processing The process");
            DummyProcess dummyProcess = new DummyProcess();
            dummyProcess.run();
            System.out.println("Processing Complete");
        }
    }
}

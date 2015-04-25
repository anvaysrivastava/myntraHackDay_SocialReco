package com.anprache.social.processor;

import com.anprache.social.processor.processes.FeedStreamProcessor;
import com.anprache.social.processor.processes.PeopleYouMayLikeProcessor;

/**
 * Created by anvay.srivastava on 26/04/15.
 */
public class Processor {
    public static void main(String args[]){
        while(true){
            System.out.println("Processing The process");
            FeedStreamProcessor feedStreamProcessor = new FeedStreamProcessor();
            feedStreamProcessor.run();

            PeopleYouMayLikeProcessor peopleYouMayLikeProcessor = new PeopleYouMayLikeProcessor();
            peopleYouMayLikeProcessor.run();

            System.out.println("Processing Complete");
        }
    }
}

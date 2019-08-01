package com.test.glidelib;

import java.util.concurrent.LinkedBlockingQueue;

public class RequestManager {

    private static RequestManager requestManager= new RequestManager();

    private RequestManager(){
        start();
    }

    public static RequestManager getInstance(){
        return requestManager;
    }

    private LinkedBlockingQueue<BitmapRequest> requestQueue = new LinkedBlockingQueue<>();

    private BitmapDispatcher[] bitmapDispatchers;

    public void addRequestQueue(BitmapRequest bitmapRequest){
        if(bitmapRequest == null){
            return;
        }
        if(!requestQueue.contains(bitmapRequest)){
            requestQueue.add(bitmapRequest);
        }
    }

    private void start(){
        stop();
        startAllDispatcher();
    }

    private void startAllDispatcher() {
        int count = Runtime.getRuntime().availableProcessors();
        bitmapDispatchers = new BitmapDispatcher[count];
        for(int i = 0; i < count; i++){
            BitmapDispatcher bitmapDispatcher = new BitmapDispatcher(requestQueue);
            bitmapDispatcher.start();
            bitmapDispatchers[i] = bitmapDispatcher;
        }
    }

    private void stop() {
        if(bitmapDispatchers != null && bitmapDispatchers.length > 0){
            for(int i = 0; i < bitmapDispatchers.length; i++){
                if(!bitmapDispatchers[i].isInterrupted()){
                    bitmapDispatchers[i].interrupt();
                }
            }
        }
    }

}

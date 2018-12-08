package com.got.producers;

import java.util.concurrent.LinkedBlockingQueue;

public class Player2MessageProducer implements Runnable{
    private final LinkedBlockingQueue queue;

    public Player2MessageProducer(LinkedBlockingQueue player2Queue) {
        this.queue = player2Queue;
    }

    @Override
    public void run() {
        System.out.println("Starting player2 producer");
    }
}

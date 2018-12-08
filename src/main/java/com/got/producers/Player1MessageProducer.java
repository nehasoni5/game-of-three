package com.got.producers;

import java.util.concurrent.LinkedBlockingQueue;

public class Player1MessageProducer  implements Runnable{

    private final LinkedBlockingQueue queue;

    public Player1MessageProducer(LinkedBlockingQueue player1Queue) {
        this.queue = player1Queue;
    }

    @Override
    public void run() {
        System.out.println("Starting player1 producer");
    }
}

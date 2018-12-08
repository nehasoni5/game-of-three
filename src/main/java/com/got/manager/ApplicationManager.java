package com.got.manager;

import com.got.consumers.Player1MessageConsumer;
import com.got.consumers.Player2MessageConsumer;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ApplicationManager {

    private Player2MessageConsumer player2MessageConsumer;
    private Player1MessageConsumer player1MessageConsumer;

    private LinkedBlockingQueue<Integer> player1Queue;
    private LinkedBlockingQueue<Integer> player2Queue;

    public ApplicationManager() {
        player1Queue = new LinkedBlockingQueue<>();
        player2Queue = new LinkedBlockingQueue<>();

        player2MessageConsumer = new Player2MessageConsumer(player1Queue, player2Queue);
        player1MessageConsumer = new Player1MessageConsumer(player1Queue, player2Queue);
    }


    public void initiateTheGame() throws InterruptedException {
        int seed = ThreadLocalRandom.current().nextInt(0, 1000);

        this.startGame(seed);
    }

    private void startGame(int seed) throws InterruptedException {
        System.out.println(String.format("Initiating the Game of Three with seed value: %d", seed));
        player1Queue.put(seed);

        Thread player1ConsumerThread = new Thread(player1MessageConsumer);
        Thread player2ConsumerThread = new Thread(player2MessageConsumer);

        player2ConsumerThread.start();
        player1ConsumerThread.start();

    }
}

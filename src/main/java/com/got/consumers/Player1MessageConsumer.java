package com.got.consumers;

import java.util.concurrent.LinkedBlockingQueue;

public class Player1MessageConsumer implements Runnable {
    private final LinkedBlockingQueue<Integer> player1Queue;
    private final LinkedBlockingQueue<Integer> player2Queue;

    public Player1MessageConsumer(LinkedBlockingQueue<Integer> player1Queue, LinkedBlockingQueue<Integer> player2Queue) {
        this.player1Queue = player1Queue;
        this.player2Queue = player2Queue;
    }

    @Override
    public void run() {
        System.out.println("Starting player1 consumer");

        while(true){
            try {
                sleepForThreeSeconds();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Integer p2Move = (Integer) this.player2Queue.poll();

            if(null == p2Move){
                System.out.println("Nothing to Poll");
                System.exit(0);
            }
            System.out.println(String.format("Player1 consumes player2's move: %d", p2Move));
            int remainder = p2Move % 3;
            if(p2Move <= 3){
                // Call Function
                System.out.println("Congratulations!! Player1 wins!!");
                System.exit(0);
            }
            if(remainder == 2){
                p2Move += 1;
            } else if(remainder == 1) {
                p2Move -= 1;
            }

            try {
                player1Queue.put(p2Move/3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void sleepForThreeSeconds() throws InterruptedException {
        Thread.sleep(4000l);
    }
}

package com.got.consumers;

import java.util.concurrent.LinkedBlockingQueue;

public class Player2MessageConsumer implements Runnable{
    private final LinkedBlockingQueue<Integer> player1Queue;
    private final LinkedBlockingQueue<Integer> player2Queue;

    public Player2MessageConsumer(LinkedBlockingQueue<Integer> player1Queue, LinkedBlockingQueue<Integer> player2Queue) {
        this.player1Queue = player1Queue;
        this.player2Queue = player2Queue;
    }

    @Override
    public void run() {
        System.out.println("Starting player2 consumer");



        while(true){
            try {
                sleepForThreeSeconds();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer p1Move = (Integer) this.player1Queue.poll();
            if(null == p1Move){
                System.out.println("Nothing to Poll");
                System.exit(0);
            }
            System.out.println(String.format("Player2 consumes player1's move: %d", p1Move));
            int remainder = p1Move % 3;
            if(p1Move <= 3){
              //need to call function of divisible and add 1,0, -1
                System.out.println("Congratulations!! Player2 wins!!");
                System.exit(0);
            }
            if(remainder == 2){
                p1Move += 1;
            } else if(remainder == 1) {
                p1Move -= 1;
            }

            try {
                player2Queue.put(p1Move/3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void sleepForThreeSeconds() throws InterruptedException {
        Thread.sleep(3000l);
    }
}

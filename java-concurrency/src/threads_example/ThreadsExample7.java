package threads_example;

public class ThreadsExample7 {

    public static class StoppableRunnable implements Runnable {

        private boolean stopRequest = false;

        public synchronized void requestStop(){
            this.stopRequest = true;
        }

        public synchronized boolean isStopRequested(){
            return this.stopRequest;
        }

        private void sleep(long millies){
            try {
                Thread.sleep(millies);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            System.out.println("Stoppable Runnable running");
            while(!isStopRequested()){
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("Stoppable Runnable stopped");

        }
    }

    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread(stoppableRunnable);
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("requesting stop");
        stoppableRunnable.requestStop();
        System.out.println("stop requested");
    }
}

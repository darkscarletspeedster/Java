package Test6Threading;

public class ConcurrentCollection {
    public static void main(String[] args) throws InterruptedException {
        InventoryManager inventoryManager = new InventoryManager();

        // direct method
        new Thread(new Runnable(){
            @Override
            public void run() {
                inventoryManager.addProducts();
            }
        }).start(); // a thread can be started this way too if has to be started immediately

        // making thread sleep so that above new thread gets time to add some relevant amount of data
        Thread.sleep(100);
        // made main class throw exception just to make to less trivial for now

        Thread displayTask = new Thread(new Runnable() {
            @Override
            public void run() {
                inventoryManager.displayProducts();
            }
        }); // .start() could not be applied here as start() method return void and not Tread

        displayTask.start();
        // this will basically make the main thread stop executing till the time it finishes it's work 
        displayTask.join(); // no code from here will be executed so makes this new thrred to run sequencially with main thread 
                       // beating the purpose of parallel run

        // self synchronisation
        Thread taskAdd = new Thread(new Runnable(){
            @Override
            public void run() {
                inventoryManager.selfSyncAddProducts();
            }
        });

        taskAdd.start();
        Thread.sleep(100);
        
        new Thread(new Runnable(){
            @Override
            public void run() {
                inventoryManager.selfSyncDisplayProduct();
            }
        }).start();
        // above self method not much sufficient as after sometime when display index gets
        // larger than that is being added it throws a outofBoundException but
        // if adding remains to be ahead of displaying than no problems would occur
    }
}
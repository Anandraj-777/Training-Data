package Assessment;

public class InventoryRepoImpl {

    private static InventoryRepoImpl inventoryRepoImpl;

    private InventoryRepoImpl() {
        System.out.println("Instance created! HashCode: " + this.hashCode());
    }

    public static InventoryRepoImpl getInstance() {
        synchronized (InventoryRepoImpl.class) {
            if (inventoryRepoImpl == null) {
                inventoryRepoImpl = new InventoryRepoImpl();
            }
        }
        return inventoryRepoImpl;
    }

    public void performTask() {
        System.out.println("HashCode: " + this.hashCode());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            InventoryRepoImpl instance = InventoryRepoImpl.getInstance();
            instance.performTask();
        });

        Thread thread2 = new Thread(() -> {
            InventoryRepoImpl instance = InventoryRepoImpl.getInstance();
            instance.performTask();
        });

        Thread thread3 = new Thread(() -> {
            InventoryRepoImpl instance = InventoryRepoImpl.getInstance();
            instance.performTask();
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

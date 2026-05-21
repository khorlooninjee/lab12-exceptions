public class Shop {

    public static int autoSaveCount = 0;

    public void buy(Character buyer, Item item) throws InsufficientGoldException {

        if (buyer.getGold() < item.getPrice()) {
            throw new InsufficientGoldException(
                    buyer.getName() + "-ийн алт хүрэлцэхгүй байна"
            );
        }

        buyer.setGold(
                buyer.getGold() - item.getPrice()
        );
    }

    public void autoSave(boolean shouldFail) {

        try {
            if (shouldFail) {
                throw new RuntimeException("Save failed");
            }
        } finally {
            autoSaveCount++;
        }
    }

    public void buyWithChain(Character buyer, Item item) throws Exception {

        try {
            buy(buyer, item);
        } catch (InsufficientGoldException cause) {
            throw new Exception("Transaction failed", cause);
        }
    }
}
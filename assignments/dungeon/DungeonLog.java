public class DungeonLog implements AutoCloseable {

    private boolean closed = false;
    private StringBuilder log = new StringBuilder();

    public void write(String entry) {
        log.append(entry).append("\n");
    }

    public boolean isClosed() {
        return closed;
    }

    @Override
    public void close() {
        closed = true;
    }
}
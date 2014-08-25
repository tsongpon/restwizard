package transport;

import java.util.List;

/**
 *
 */
public class ResponseTransport<V> {
    private List<V> result;
    private int count;

    public ResponseTransport(List<V> data, int count) {
        this.result = data;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<V> getResult() {
        return result;
    }

    public void setResult(List<V> result) {
        this.result = result;
    }
}

/*
You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

    record(order_id): adds the order_id to the log
    get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

You should be as efficient with time and space as possible
*/

public class Solution {

    public static void main(String... args) {
        OrderLog orderLog = new OrderLog(5);
        System.out.println(orderLog.getLast(3));    // -1
        orderLog.record(1);
        System.out.println(orderLog.getLast(3));    // -1
        orderLog.record(2);
        System.out.println(orderLog.getLast(3));    // -1
        orderLog.record(3);
        System.out.println(orderLog.getLast(3));    // -1
        orderLog.record(4);
        System.out.println(orderLog.getLast(3));    // 1
        orderLog.record(5);
        System.out.println(orderLog.getLast(3));    // 2
        orderLog.record(6);
        System.out.println(orderLog.getLast(3));    // 3
        orderLog.record(7);
        System.out.println(orderLog.getLast(3));    // 4
        orderLog.record(8);
        System.out.println(orderLog.getLast(3));    // 5
        orderLog.record(9);
        System.out.println(orderLog.getLast(3));    // 6
        orderLog.record(10);
        System.out.println(orderLog.getLast(3));    // 7
        orderLog.record(11);
        System.out.println(orderLog.getLast(3));    // 8
    }

    public static final class OrderLog {

        private final long[] buf;
        private int size;
        private int head;
        private int tail = -1;

        public OrderLog(int size) {
            buf = new long[size];
        }

        public void record(long orderId) {
            if (size == buf.length) {
                head = next(head);
                size--;
            }

            tail = next(tail);
            buf[tail] = orderId;
            size++;
        }

        public long getLast(int i) {
            if (i < 0 || i >= size)
                return -1;

            int j = tail;

            for (; i > 0; i--)
                j = prev(j);

            return buf[j];
        }

        private int next(int i) {
            return i + 1 == buf.length ? 0 : i + 1;
        }

        private int prev(int i) {
            return i == 0 ? buf.length - 1 : i - 1;
        }
    }

}

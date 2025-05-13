package Stack.no0084;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int[] heights = {4, 2, 0, 3, 2, 5};
        System.out.println(largestRectangleInHistogram.largestRectangleArea(heights));
    }

    // TODO: use a stack to track all tuples of start index, height.
    //  Start index tells us from where the histogram which the given height start from
    //  The histogram would extend to the current index
    //  When to push: Every index
    //  When to pop: When the current index has the height smaller than that of the top element on the stack
    //  This would mean that the histogram starting from the start index with the height on top of the stack
    //  could not be extended to the current index
    //  Each time we pop, we also have to update the largest area accordingly
    //  When meeting a height lower than that of the top element on the stack.
    //  Remember to check where that height could be extended to the left
    //  (Since it could be lower than many elements on the stack, hence it could have started way earlier than the current index)
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        Stack<Tuple<Integer, Integer>> stack = new Stack<>();
        int largestArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[i] >= stack.peek().getHeight()) {
                stack.push(new Tuple<>(i, heights[i]));
            }
            /// current height is smaller than that of top stack element.
            /// in this case we have to push from the stack and also update the max area
            else {
                int startIndex = -1;
                while (!stack.isEmpty() && heights[i] < stack.peek().getHeight()) {
                    Tuple<Integer, Integer> toBePopped = stack.pop();
                    startIndex = toBePopped.getIndex();
                    int width = i - startIndex;
                    int height = toBePopped.getHeight();
                    largestArea = Math.max(width * height, largestArea);
                }
                /// if we have consumed everything from the stack,
                /// it means the current height could be extended to the last element that gets popped
                if (stack.isEmpty()) {
                    stack.push(new Tuple<>(startIndex, heights[i]));
                }
                /// Now that we have popped every height that is higher than the current one, we know that the top element on the stack
                /// now has height lower or equal to that of the current index
                else if (heights[i] > stack.peek().getHeight()) {
                    /// it means the current height can be extended to the left, and at most to the last element that gets popped
                    stack.push(new Tuple<>(startIndex, heights[i]));
                }
                /// the last case is when the current height is equal to that of the top element on stack, we can skip this since it means
                /// the top element can be extended further right
            }
        }
        /// When we reach the end of the array and there are still stuffs left in the stack, it means they all extend to the end of the array
        while (!stack.isEmpty()) {
            Tuple<Integer, Integer> toBePopped = stack.pop();
            int startIndex = toBePopped.getIndex();
            int width = heights.length - startIndex;
            int height = toBePopped.getHeight();
            largestArea = Math.max(width * height, largestArea);
        }
        return largestArea;
    }

    public static class Tuple<X, Y> {
        private X index;
        private Y height;

        public Tuple(X index, Y height) {
            this.index = index;
            this.height = height;
        }

        public Y getHeight() {
            return height;
        }

        public void setHeight(Y height) {
            this.height = height;
        }

        public X getIndex() {
            return index;
        }

        public void setIndex(X index) {
            this.index = index;
        }
    }
}

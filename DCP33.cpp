/*
---------Question--------

Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2
--------- End Question ---------
*/


// Max heap contains numbers smaller than median
// Min heap contains numbers larger than median
// heap is balanced when the size difference between the heaps becomes more than 1
// if both sizes are same then median is avg of the tops of heaps
// else the heap containing more numbers has the median at the top
class Solution {
public:
    priority_queue<int> maxHeap;
    priority_queue<int, vector<int>, greater<int>> minHeap;
    double median;
    MedianFinder() {
        median = INT_MIN;
    }
    
    void addNum(int num) {
        if(this->median == INT_MIN) 
            this->median = (double) num;
        
        if(num >= this->median) minHeap.push(num);
        else maxHeap.push(num);
        
        if(minHeap.size() > maxHeap.size()+1){
            maxHeap.push(minHeap.top());
            minHeap.pop();
        }
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.push(maxHeap.top());
            maxHeap.pop();
        } 

        if(minHeap.size() == maxHeap.size())
            this->median = (double) (minHeap.top() + maxHeap.top())/2;
        else if(minHeap.size() > maxHeap.size() )
            this->median = (double) minHeap.top();
        else 
            this->median = (double) maxHeap.top();
        
        // printf("num: %d , median: %0.5f\n", num,median);
    } 
    
    double findMedian() {
        return this->median;
    }
};

/**
 * MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */

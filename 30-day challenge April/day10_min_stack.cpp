// Leetcode 30-day day 10
// Design a stack that supports push, pop, top and retrieving the minimum element

// have each node keep track of the minimum value up to that node

#include <iostream>
#include <string>

class MinStack {
public:
    MinStack() {
        end = new Node(NULL);
    }
    
    void push(int x) {
        end->item = x;
        // This nest if it to keep track of the minimum of the current stack, if end->prev == NULL, we are at head node, so initialize minimum it itself
        if (end->prev != NULL)
        {
            if (end->prev->minimum > x)
            {
                end->minimum = x;
            }
            else
            {
                end->minimum = end->prev->minimum;
            }
        }
        else
        {
            end->minimum = x;
        }
        end = new Node(end);
    }
    
    void pop() {
        Node* temp = end;
        end = end->prev;
        delete temp;
    }
    
    int top() {
        return end->prev->item;
    }
    
    int getMin() {
        return end->prev->minimum;
    }
    
private:
    struct Node
    {
        int item;
        int minimum; // the minimum value on stack up to this node
        Node* next;
        Node* prev;
        Node(Node* n)
        {
            prev = n;
            next = NULL;
        }
    };
    Node* end;   
};

int main()
{

	MinStack* obj = new MinStack();
  	obj->push(-2);
  	obj->push(0);
  	obj->push(-3);
 	int param_1 = obj->getMin(); // -3
	obj->pop();
 	int param_2 = obj->top();
 	int param_3 = obj->getMin();

 	std::cout << "First getMin: " << param_1 << std::endl;
 	std::cout << "Get top after pop: " << param_2 << std::endl;
 	std::cout << "New minimum: " << param_3 << std::endl;

	return 0;
}


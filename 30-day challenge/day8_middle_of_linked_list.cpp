// Leetcode 30-day day 8
// Given non-empty singly linked list, with head node,
// return middle of node, if two middles return second middle

// tortoise and hare algorithm
// hare iterates twice as fast as tortoise, when hare reaches end
// tortoise is at middle.

#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

ListNode* middleNode(ListNode* head)
{
	ListNode* tortoise = head;
	ListNode* hare = head;

	while (hare->next != NULL)
	{	

		if (tortoise->next != NULL)
			tortoise = tortoise->next;
		// hare will iterate twice as fast as tortoise, if possible
		if (hare->next != NULL)
			hare= hare->next;
		if (hare->next != NULL)
			hare = hare->next;
	} 

	return tortoise;
}


int main()
{
	// create example node [1,2,3,4,5,6] 
	// output should be 4, because it is the second middle
	ListNode* head;
	ListNode* iterator;
	head = new ListNode(1);
	iterator = head;
	for (int i = 2; i < 7; i++)
	{
		iterator->next = new ListNode(i);
		iterator = iterator->next;
	}

	iterator = head;

	std::cout << "Input Linked List: [";
	while (iterator != NULL)
	{
		std::cout << iterator->val;
		iterator = iterator->next;
		if (iterator == NULL)
			std::cout << "]\n";
		else
			std::cout << ", ";
	}

	std::cout << "Middle node in linked list is: " << middleNode(head)->val << std::endl;

	// deallocation
	while (head != NULL)
	{
		iterator = head->next;
		delete head;
		head = iterator;
	}

	return 0;
}


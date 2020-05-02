#include <iostream>

using namespace std;

int main()
{
	unsigned int start, newNum = 0;
	unsigned int seen[10] = {0};

	cout << "Enter a postive number: ";
	cin >> start;

	while (seen[start % 10] != start)
	{
		seen[start % 10] = start;
		while (start != 0)
		{
			newNum += (start % 10) * (start % 10);
			start /= 10;
		}

		if (newNum == 1)
		{
			cout << "happy\n";
			break;
		}
		else
		{
			start = newNum;
			newNum = 0;
		}
	}
	cout << "not happy\n";

	return 0;
}

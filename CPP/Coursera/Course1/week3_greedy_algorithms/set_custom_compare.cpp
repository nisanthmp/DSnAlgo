#include <set>
#include <iostream>

using namespace std;

bool compare (int a, int b) {
	return a > b;
}
int main() {
	set<int, bool (*)(int, int)> s(compare);
	s.insert(1);
	s.insert(2);
	for (int a : s) {
		cout << a << endl;
	}
	return 0;
}

#include <algorithm>
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;
//using std::vector;

/*class bin {
public:
  int val;
  int count = 0;
}*/

int get_majority_element(vector<int> &a, int left, int right) {
  if (left == right) return -1;
  if (left + 1 == right) return a[left];
  //write your code here
  unordered_map<int, int> bins;
  for (int b : a) {
    auto itr = bins.find(b);
    if (itr == bins.end()) bins[b] = 1;
    else itr->second ++;
  }
  int size_by_2 = a.size() >> 1;
  for (auto b : bins) {
    if (b.second > size_by_2) return b.first;
  }
  return -1;
}

int main() {
  int n;
  std::cin >> n;
  vector<int> a(n);
  for (size_t i = 0; i < a.size(); ++i) {
    std::cin >> a[i];
  }
  std::cout << (get_majority_element(a, 0, a.size()) != -1) << '\n';
}

#include <iostream>
#include <cassert>
#include <vector>

using std::vector;

int rec_bin_search (const vector<int> &a, int left, int right, int x) {
  if (left > right) return -1;
  if (left < 0 || right >= a.size()) return -1;
  if (left == right) {
    if (x == a[left]) return left;
    else return -1;
  }
  int mid = (left + right) / 2;
  if (x == a[mid]) return mid;
  else if (x < a[mid]) return rec_bin_search(a, left, mid - 1, x); 
  else return rec_bin_search(a, mid + 1, right, x);
}
int binary_search(const vector<int> &a, int x) {
  int left = 0, right = (int)a.size(); 
  //write your code here
  return rec_bin_search(a, left, right - 1, x); 
}

int linear_search(const vector<int> &a, int x) {
  for (size_t i = 0; i < a.size(); ++i) {
    if (a[i] == x) return i;
  }
  return -1;
}

int main() {
  int n;
  std::cin >> n;
  vector<int> a(n);
  for (size_t i = 0; i < a.size(); i++) {
    std::cin >> a[i];
  }
  int m;
  std::cin >> m;
  vector<int> b(m);
  for (int i = 0; i < m; ++i) {
    std::cin >> b[i];
  }
  for (int i = 0; i < m; ++i) {
    //replace with the call to binary_search when implemented
    std::cout << binary_search(a, b[i]) << ' ';
  }
}

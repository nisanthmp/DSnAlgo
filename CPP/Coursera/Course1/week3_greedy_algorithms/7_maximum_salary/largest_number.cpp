#include <algorithm>
#include <sstream>
#include <iostream>
#include <vector>
#include <string>
#include <stack>

using std::vector;
using std::string;

static int count = 0;

bool compare(const string &a, const string &b) {
  int ia = std::stoi(a);
  int ib = std::stoi(b);
  std::stack<int> stack_a;
  std::stack<int> stack_b;

  std::cout << "count = " << count++ << std::endl;
  if (count == 351) {
    std::cout << count << " reached" << std::endl;
  }

  while (ia != 0) {
    stack_a.push(ia % 10);
    ia /= 10;
  }

  while (ib != 0) {
    stack_b.push(ib % 10);
    ib /= 10;
  }

  int fa = stack_a.top();
  int fb = stack_b.top();

  int da, db;
  int i = 0;
  int stk_a_size = stack_a.size();
  int stk_b_size = stack_b.size();
  for (; i < stk_a_size && i < stk_b_size; i ++) {
    da = stack_a.top();
    db = stack_b.top();
    stack_a.pop();
    stack_b.pop();
    if (da > db) return true;
    else if (da < db) return false;
  }
  
  if (i == stk_a_size && i == stk_b_size) return true;

  if (i == stk_a_size) {
    db = stack_b.top();
    if (fa > db) return true;
    else return false;
  }
  else {
    da = stack_a.top();
    if (da > fb) return true;
    else return false;
  }
  

  //std::stringstream ssa, ssb;
  //string sa, sb;
  //sa = itoa(a);
  //sb = itoa(b);
  //return std::strcmp(b, a);

  //ssa << a; ssa >> sa;
  //ssb << b; ssb >> sb;
}

bool compare2(string a, string b) {
  std::stringstream ssa, ssb;
  ssa << a << b;
  ssb << b << a;
  std::string sa, sb;
  ssa >> sa;
  ssb >> sb;
  
  if (sa.compare (sb) > 0) return true;
  else return false;
}

string largest_number(vector<string> a) {
  //write your code here
  std::stringstream ret;
  std::sort(a.begin(), a.end(), compare2);
  //std::sort(a.begin(), a.end());

  for (size_t i = 0; i < a.size(); i++) {
    ret << a[i];
  }
  string result;
  ret >> result;
  return result;
}

int main() {
  int n;
  std::cin >> n;
  vector<string> a(n);
  for (size_t i = 0; i < a.size(); i++) {
    std::cin >> a[i];
  }
  std::cout << largest_number(a);
}

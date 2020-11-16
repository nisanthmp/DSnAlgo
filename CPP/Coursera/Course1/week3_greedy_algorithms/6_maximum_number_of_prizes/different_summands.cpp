#include <iostream>
#include <vector>
#include <cmath>

using std::vector;

/* k * (k + 1) <= 2 * n
 * k^2 + k - 2n <= 0
 * k <= (-1 +- ((1^2 + 8n)^0.5))/2
 * k <= ((8n + 1)^0.5 - 1)/2
 */

vector<int> optimal_summands(int n) {
  vector<int> summands;
  long long int k = (long long int)((sqrt(8 * ((long long int)n) + 1) - 1)/2);
  for (int i = 1; i < k; i ++) {
    summands.push_back(i);
  }
  long long int sum_k = (k * (k - 1))/2;
  summands.push_back(n - sum_k);
  //write your code here
  return summands;
}

int main() {
  int n;
  std::cin >> n;
  vector<int> summands = optimal_summands(n);
  std::cout << summands.size() << '\n';
  for (size_t i = 0; i < summands.size(); ++i) {
    std::cout << summands[i] << ' ';
  }
}

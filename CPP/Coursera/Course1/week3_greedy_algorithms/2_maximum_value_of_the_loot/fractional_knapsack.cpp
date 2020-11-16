#include <iostream>
#include <vector>

using std::vector;

double get_optimal_value(int capacity, vector<int> weights, vector<int> values) {
  double value = 0.0;

  // write your code here
  vector<double> val_per_weight;
  double total_val = 0;
  double total_weight = 0;
  for (int i = 0; i < weights.size(); i ++) {
    val_per_weight.push_back(((double)values[i])/((double)(weights[i])));
  }
  while (total_weight < capacity) {
    double highest_val_per_weight = val_per_weight[0];
    int idx = 0;
    for (int i = 0; i < val_per_weight.size(); i ++) {
      if (highest_val_per_weight < val_per_weight[i]) {
        highest_val_per_weight = val_per_weight[i];
	idx = i;
      }
    }
    val_per_weight[idx] = 0;
    if (highest_val_per_weight == 0) break;
    double remaining_weight = capacity - total_weight;
    double weight_taken = weights[idx] < remaining_weight ? weights[idx] : remaining_weight;
    total_val += weight_taken * highest_val_per_weight;
    total_weight += weight_taken;
  }
  return total_val;
}

int main() {
  int n;
  int capacity;
  std::cin >> n >> capacity;
  vector<int> values(n);
  vector<int> weights(n);
  for (int i = 0; i < n; i++) {
    std::cin >> values[i] >> weights[i];
  }

  double optimal_value = get_optimal_value(capacity, weights, values);

  std::cout.precision(10);
  std::cout << optimal_value << std::endl;
  return 0;
}

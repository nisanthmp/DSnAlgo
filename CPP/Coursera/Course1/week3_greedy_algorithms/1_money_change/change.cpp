#include <iostream>
#define NUM_DENOMS (3)
int get_change(int m) {
  //write your code here
  int denoms[NUM_DENOMS] = {1, 5, 10};
  int num_coins = 0;
  int remaining = m;
  for (int i = NUM_DENOMS - 1; i >= 0; i --) {
    num_coins += remaining/denoms[i];
    remaining = remaining % denoms[i];
    if (remaining == 0) break;
  }
  return num_coins;
}

int main() {
  int m;
  std::cin >> m;
  std::cout << get_change(m) << '\n';
}

#include <iostream>
#include <vector>
#include <algorithm>

long int MaxPairwiseProduct(const std::vector<int>& numbers) {
    long int max_product = 0;
    int n = numbers.size();

    /*for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            max_product = std::max(max_product,
                numbers[i] * numbers[j]);
        }
    }*/
    int max_nums[2];
    int max_idx[2] = { -1, -1 };
    for (int i = 0; i < 2; ++i) {
	if (max_idx[0] != 0) {
	    max_nums[i] = numbers[0];
	    max_idx[i] = 0;
	}
	else {
	    max_nums[i] = numbers[1];
	    max_idx[i] = 1;
	}
        for (int j = 0; j < n; ++j) {
	    if(max_nums[i] < numbers[j] && max_idx[0] != j) {
		max_nums[i] = numbers[j];
		max_idx[i] = j;
	    }
	}
    }
    max_product = ((long int) max_nums[0]) * ((long int) max_nums[1]);
    return max_product;
}

int main() {
    int n;
    std::cin >> n;
    std::vector<int> numbers(n);
    for (int i = 0; i < n; ++i) {
        std::cin >> numbers[i];
    }

    std::cout << MaxPairwiseProduct(numbers) << "\n";
    return 0;
}

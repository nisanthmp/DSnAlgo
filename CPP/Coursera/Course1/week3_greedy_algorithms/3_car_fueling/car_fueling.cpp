#include <iostream>
#include <vector>

using std::cin;
using std::cout;
using std::vector;
using std::max;

int compute_min_refills(int dist, int tank, vector<int> & stops) {
    // write your code here
    int num_stops = 0;
    int curr_stop = 0;
    for (int i = 0; i < stops.size(); ) {
        int next_stop = stops[i];
	int next_idx = i;
	while (next_stop - curr_stop <= tank) {
	    i ++;
	    if (i < stops.size()) next_stop = stops[i];
	    else if (dist - curr_stop <= tank) return num_stops;
	    else break;
	}
	if (i == next_idx) return -1;
	num_stops ++;
	if (i == stops.size()) {
	    if (dist - stops[i - 1] <= tank) return num_stops;
	    else return -1;
	}
	curr_stop = stops[i - 1];    
    }
	    
    return -1;
}


int main() {
    int d = 0;
    cin >> d;
    int m = 0;
    cin >> m;
    int n = 0;
    cin >> n;

    vector<int> stops(n);
    for (size_t i = 0; i < n; ++i)
        cin >> stops.at(i);

    cout << compute_min_refills(d, m, stops) << "\n";

    return 0;
}

#include <algorithm>
#include <iostream>
#include <climits>
#include <vector>

using std::vector;

struct Segment {
  int start, end;
};

bool compare(struct Segment a, struct Segment b) {
    return a.start < b.start;
}

vector<int> optimal_points(vector<Segment> &segments) {
  vector<int> points;
  //write your code here
  sort (segments.begin(), segments.end(), compare);

  for (size_t i = 0; i < segments.size(); ) {
    int overlap_end = segments[i].end;
    if (i == segments.size() - 1) {
	points.push_back(overlap_end);
	break;
    }
    int j = i + 1;
    while (segments[j].start <= overlap_end) {
        if (overlap_end > segments[j].end) {
	    overlap_end = segments[j].end;
	}
        if (j == segments.size() - 1) {
	    points.push_back(overlap_end);
	    return points;
	}
	j ++;
    }
    points.push_back(overlap_end);
    i = j;
  }
  return points;
}

int main() {
  int n;
  std::cin >> n;
  vector<Segment> segments(n);
  for (size_t i = 0; i < segments.size(); ++i) {
    std::cin >> segments[i].start >> segments[i].end;
  }
  vector<int> points = optimal_points(segments);
  std::cout << points.size() << "\n";
  for (size_t i = 0; i < points.size(); ++i) {
    std::cout << points[i] << " ";
  }
}

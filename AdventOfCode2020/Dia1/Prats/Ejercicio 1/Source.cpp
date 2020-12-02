#include <iostream>
#include <fstream>
#include <algorithm>
#include <string>
#include <list>
#include <iomanip>
#include <vector>

void resuelveCaso() {

	int input_num;

	std::vector<int> v;

	std::cin >> input_num;
	if (!std::cin) return;
	v.push_back(input_num);
	while (std::cin) {
		std::cin >> input_num;
		v.push_back(input_num);
	}

	std::sort(v.begin(), v.end());

	int i = 0, j = v.size() - 1, actual;

	while (i < j) {
		actual = v[i] + v[j];
		if (actual < 2020) {
			i++;
		}
		else if (actual > 2020) {
			j--;
		}
		else {
			std::cout << v[i] * v[j] << '\n';
			return;
		}
	}

}

int main() {

	std::ifstream in("input.txt");
	auto cinbuf = std::cin.rdbuf(in.rdbuf());

	resuelveCaso();

	return 0;
}
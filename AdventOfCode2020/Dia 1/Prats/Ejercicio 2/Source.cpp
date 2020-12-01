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

	int i = 0, k = i + 1, j = v.size() - 1, actual;

	while (i < j && k > i && k < j) {
		actual = v[i] + v[j] + v[k];
		if (actual < 2020 && k < j - 1) {
			k++;
		}
		else if (k == j - 1) {
			i++;
			k = i + 1;
		}
		else if (actual > 2020) {
			j--;
			k = i + 1;
		}
		else {
			std::cout << v[i] * v[j] * v[k] << '\n';
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
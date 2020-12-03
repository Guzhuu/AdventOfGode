#include <iostream>
#include <fstream>
#include <algorithm>
#include <string>
#include <list>
#include <iomanip>
#include <vector>

void resuelveCaso() {

	std::string range, letra, secuencia, low_range, high_range;
	int total_count = 0;

	while (std::cin) {
		std::cin >> range >> letra >> secuencia;
		int i = 0, actual_count = 0;
		low_range = range.substr(0, range.find("-"));
		high_range = range.substr(range.find("-") + 1);
		while (i < secuencia.size() && actual_count < range[2]) {
			if (secuencia[i] == letra[0]) actual_count++;
			i++;
		}
		if (actual_count >= std::stoi(low_range) && actual_count <= std::stoi(high_range)) total_count++;
	}
	std::cout << total_count;

}

int main() {

	std::ifstream in("input.txt");
	auto cinbuf = std::cin.rdbuf(in.rdbuf());

	resuelveCaso();

	return 0;
}
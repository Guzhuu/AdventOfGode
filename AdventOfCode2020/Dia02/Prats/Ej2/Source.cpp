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

	std::cin >> range >> letra >> secuencia;
	if (!std::cin) return;

	while (std::cin) {
		low_range = range.substr(0, range.find("-"));
		high_range = range.substr(range.find("-") + 1);
		if (secuencia[std::stoi(low_range) - 1] == letra[0] && secuencia[std::stoi(high_range) - 1] != letra[0]) total_count++;
		else if (secuencia[std::stoi(low_range) - 1] != letra[0] && secuencia[std::stoi(high_range) - 1] == letra[0]) total_count++;
		std::cin >> range >> letra >> secuencia;
	}
	std::cout << total_count;

}

int main() {

	std::ifstream in("input.txt");
	auto cinbuf = std::cin.rdbuf(in.rdbuf());

	resuelveCaso();

	return 0;
}
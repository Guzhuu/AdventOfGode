var lineas = require('fs').readFileSync('Dia02/Ghuzuu/input.txt', 'utf8').split('\n');
var min, max, car, zones, texto, aux, count;

count = 0;
for(var i in lineas){
	zones = lineas[i].split(" ");
	min = parseInt(zones[0].split("-")[0]);
	max = parseInt(zones[0].split("-")[1]);
	car = zones[1].charAt(0);
	texto = zones[2];
	aux = 0;
	
	for(var i in texto){
		if(texto[i] == car){
			aux++;
			if(aux > max){
				break;
			}
		}
	}
	if(aux >= min && aux <= max){
		count++;
	}

}

console.log("Numero de correstas: " + count);
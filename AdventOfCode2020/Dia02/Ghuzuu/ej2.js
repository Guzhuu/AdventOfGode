var lineas = require('fs').readFileSync('Dia02/Ghuzuu/input.txt', 'utf8').split('\n');
var i1, i2, car, zones, texto, count;

count = 0;
for(var i in lineas){
	zones = lineas[i].split(" ");
	i1 = parseInt(zones[0].split("-")[0]);
	i2 = parseInt(zones[0].split("-")[1]);
	car = zones[1].charAt(0);
	texto = zones[2];

	if(i1 > 0){
		i1--;
	}else{
		continue;
	}
	if(i2 > 0){
		i2--;
	}else{
		continue;
	}

	if((i1 < texto.length && texto[i1] == car) ^ (i2 < texto.length && texto[i2] == car)){
		count++;
	}

}

console.log("Numero de correstas: " + count);
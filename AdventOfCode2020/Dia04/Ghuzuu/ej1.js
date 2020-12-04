var fields = ["byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"/*, "cid"*/];
var lineas = require('fs').readFileSync('Dia04/Ghuzuu/input.txt', 'utf8').split('\n\r\n');
var count = 0;
var valid = 0;

for(var i in lineas){
	valid = 0;
	for(var j in fields){
		if(lineas[i].indexOf(fields[j] + ":") != -1){
			valid++;
		}else{
			break;
		}
	}
	if(valid == fields.length){
		count++;
	}
}
console.log("Total: " + count);
var fields = ["byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"];
var eyeColor = ["amb", "blu", "brn", "gry", "grn", "hzl", "oth"];
var lineas = require('fs').readFileSync('Dia04/Ghuzuu/input.txt', 'utf8').split('\r\n\r\n');
var count = 0;
var valid = 0;
var value = "";
var camposPasaporte;
var field = "";

for(var i in lineas){
	valid = 0;
	camposPasaporte = lineas[i].split(/ |\r\n/g);
	camposPasaporte.sort();
	for(var j in camposPasaporte){
		field = camposPasaporte[j].split(":")[0].trim();
		value = camposPasaporte[j].split(":")[1].trim();
		if(fields.indexOf(field) != -1){
			switch(field){
				case "byr":
					try{
						value = parseInt(value);
						if(value >= 1920 && value <= 2002){
							valid++;
						}
					}catch(e){

					}
					break;
				case "iyr":
					try{
						value = parseInt(value);
						if(value >= 2010 && value <= 2020){
							valid++;
						}
					}catch(e){

					}
					break;
				case "eyr":
					try{
						value = parseInt(value);
						if(value >= 2020 && value <= 2030){
							valid++;
						}
					}catch(e){

					}
					break;
				case "hgt":
					var end = value.substring(value.length - 2, value.length);
					try{
						value = parseInt(value.substring(0, value.length - 2));
					}catch(e){
						console.log("Error:" + e.toString());
					}
					if(end == "cm"){
						if(value >= 150 && value <= 193){
							valid++;
						}
					}else if(end == "in"){
						if(value >= 59 && value <= 76){
							valid++;
						}
					}
					break;
				case "hcl":
					if(value.match(/#[a-f0-9]{6}/)){
						valid++;
					}
					break;
				case "ecl":
					if(eyeColor.indexOf(value) != -1){
						valid++;
					}
					break;
				case "pid":
					if(value.match(/[0-9]{9}/) == value){
						valid++;
					}
					break;
			}
		}
		
	}
	if(valid == fields.length){
		count++;
	}
}
console.log("Total: " + count);
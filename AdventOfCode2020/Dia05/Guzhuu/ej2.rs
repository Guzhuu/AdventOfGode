use std::fs;

fn main() {
	let filename = "input.txt";

    let contents = fs::read_to_string(filename).expect("Something went wrong reading the file");

	let mut _max_fila = 127;
	let mut _min_fila = 0;
	let mut _min_columna = 0;
	let mut _max_columna = 7;
	let mut _id = 0;
	let mut _min = 1024;
	let mut _max = 0;
	let mut _seat = 0;

	let split = contents.split("\r\n");
	let vec: Vec<&str> = split.collect();
	let mut _passed = vec![];
	_passed.push(10);
	_passed.pop();

	for x in &vec{
		_max_fila = 127;
		_min_fila = 0;
		_max_columna = 7;
		_min_columna = 0;
		for c in x.chars(){
			match c {
				'F' => 	if _min_fila + 1 == _max_fila{
							_min_fila = _min_fila
						}else{
							_max_fila = ((_max_fila + _min_fila) as f32 / 2.0).floor() as i32
						},
				'B' => 	if _min_fila + 1 == _max_fila{
							_min_fila = _max_fila
						}else{
							_min_fila = ((_max_fila + _min_fila) as f32 / 2.0).ceil() as i32
						},
				'R' => 	if _min_columna + 1 == _max_columna{
							_min_columna = _max_columna
						}else{
							_min_columna = ((_max_columna + _min_columna) as f32 / 2.0).ceil() as i32
						},
				'L' => 	if _min_columna + 1 == _max_columna{
							_min_columna = _min_columna;
						}else{
							_max_columna = ((_max_columna + _min_columna) as f32 / 2.0).floor() as i32
						},
				_ => print!("Ou shit illegal"),
			}
		}
		_id = _min_fila * 8 + _min_columna;
		if _min > _id{
			_min = _id;
		}
		if _max < _id {
			_max = _id;
		}
		_passed.push(_id);
	}
	_passed.sort();
	for x in &_passed{
		if !_passed.contains(&(x + 1)) && x < &_max{
			_seat = *x + 1;
		}
		println!("{}", x);
	}
	println!("Seat {}", _seat);
}
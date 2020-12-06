filename = Dir.pwd + '/Dia06/Ghuzuu/input.txt'
contents = File.read(filename)
grupos = contents.split("\n\n")
count = 0

grupos.each do |item|
	personas = item.split("\n")
	preguntas = []
	personas.each do |persona|
		persona.split("").each do |problema|
			if !preguntas.include? problema
				preguntas.push(problema)
			end
		end
	end
	
	count += preguntas.count()
end

puts "Total: #{count}"
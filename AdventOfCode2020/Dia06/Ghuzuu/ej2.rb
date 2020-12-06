filename = Dir.pwd + '/Dia06/Ghuzuu/input.txt'
contents = File.read(filename)
grupos = contents.split("\n\n")
count = 0

grupos.each do |item|
	personas = item.split("\n")
	preguntas = []
	personas.each do |persona|
		persona.split("").each do |problema|
			preguntas.push(problema)
		end
	end
	
	done = []
	preguntas.each do |pregunta|
		if !done.include?(pregunta) && preguntas.count(pregunta) == personas.count()
			count += 1
			done.push(pregunta)
		end
	end
end

puts "Total: #{count}"
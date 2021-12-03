string path = @"./input.txt";

int[] ReadInput(string filePath)
{
	if (!File.Exists(filePath))
		return new int[0];
	return File.ReadAllLines(filePath).Select(l => Int32.Parse(l)).ToArray();
}

int CheckIncrements(int[] lines)
{
	if (lines == null || lines.Length <= 0)
		return 0;
	int increments = 0;
	for (int i = 0; i < lines.Length - 1; i++)
	{
		if (lines[i] < lines[i + 1])
			increments++;
	}
	return increments;
}

int CheckIncrementsThreeMeasurement(int[] lines)
{
	if (lines == null || lines.Length <= 0)
		return 0;
	int increments = 0, curr = 0, aux = lines[0] + lines[1] + lines[2];
	for (int i = 0; i < lines.Length - 2; i++)
	{
		curr = lines[i] + lines[i + 1] + lines[i + 2];
		if (curr > aux)
			increments++;
		aux = curr;
	}
	return increments;
}

int[] lines = ReadInput(path);
Console.WriteLine("Ex 1: " + CheckIncrements(lines));
Console.WriteLine("Ex 2: " + CheckIncrementsThreeMeasurement(lines));
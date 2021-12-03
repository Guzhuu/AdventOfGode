string path = @"./input.txt";

string[] ReadInput(string filePath)
{
	if (!File.Exists(filePath))
		return new string[0];
	return File.ReadAllLines(filePath).ToArray();
}

int[] CalculatePosition(string[][] movements)
{
	int h = 0, d = 0;
	foreach (string[] m in movements)
	{
		switch (m[0])
		{
			case "forward":
				h += Int32.Parse(m[1]);
				break;
			case "down":
				d += Int32.Parse(m[1]);
				break;
			case "up":
				d -= Int32.Parse(m[1]);
				break;
		}
	}
	return new int[] { h, d };
}

int[] CalculatePositionWithAim(string[][] movements)
{
	int h = 0, d = 0, a = 0, value = 0;
	foreach (string[] m in movements)
	{
		value = Int32.Parse(m[1]);
		switch (m[0])
		{
			case "forward":
				h += value;
				d += value * a;
				break;
			case "down":
				a += value;
				break;
			case "up":
				a -= value;
				break;
		}
	}
	return new int[] { h, d, a };
}

int[] pos1 = CalculatePosition(ReadInput(path).Select(l => l.Split()).ToArray());
int[] pos2 = CalculatePositionWithAim(ReadInput(path).Select(l => l.Split()).ToArray());
Console.WriteLine("Ex 1: " + pos1[0] * pos1[1]);
Console.WriteLine("Ex 2: " + pos2[0] * pos2[1]);
using System.Diagnostics;
string path = @"./input.txt";

string[] ReadInput(string filePath)
{
	if (!File.Exists(filePath))
		return new string[0];
	return File.ReadAllLines(filePath).ToArray();
}

char FindMostCommon(string[] lines, int position)
{
	int zeroCount = 0, oneCount = 0;
	foreach (string line in lines)
	{
		if (line[position] == '0')
			zeroCount++;
		else
			oneCount++;
	}
	return zeroCount > oneCount ? '0' : '1';
}

string GetBinaryGamma(string[] lines)
{
	string binaryGamma = "";
	for (int i = 0; i < lines[0].Length; i++)
	{
		binaryGamma += FindMostCommon(lines, i);
	}
	return binaryGamma;
}

string GetOxygenRating(string[] lines, int position)
{
	if (lines.Length > 1)
	{
		List<string> remainingLines = new List<string>();
		char mostCommon = FindMostCommon(lines, position);
		foreach (string line in lines)
		{
			if (line[position] == mostCommon) remainingLines.Add(line);
		}
		return GetOxygenRating(remainingLines.ToArray(), position + 1);
	}
	return lines[0];
}

string GetCO2ScrubberRating(string[] lines, int position)
{
	if (lines.Length > 1)
	{
		List<string> remainingLines = new List<string>();
		char mostCommon = FindMostCommon(lines, position);
		foreach (string line in lines)
		{
			if (line[position] != mostCommon) remainingLines.Add(line);
		}
		return GetCO2ScrubberRating(remainingLines.ToArray(), position + 1);
	}
	return lines[0];
}

string[] lines = ReadInput(path);
string binaryGamma = GetBinaryGamma(lines);
string binaryEpsilon = new string(binaryGamma.Select(c => c == '1' ? '0' : '1').ToArray());
Console.WriteLine("Ex 1: " + Convert.ToInt32(binaryGamma, 2) * Convert.ToInt32(binaryEpsilon, 2));
Console.WriteLine("Ex 2: " + Convert.ToInt32(GetOxygenRating(lines, 0), 2) * Convert.ToInt32(GetCO2ScrubberRating(lines, 0), 2));
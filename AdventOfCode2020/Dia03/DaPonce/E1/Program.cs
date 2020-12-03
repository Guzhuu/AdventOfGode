using System;

namespace E1
{
    class Program
    {
        static int barbol = 0;
        static void Main(string[] args)
        {
            string[] lines = System.IO.File.ReadAllLines("input.txt");
            int linesLength = lines[0].Length;
            int x = 3;

            for (int y = 1; y < lines.Length; y++)
            {
                if (lines[y][x] == '#')
                {
                    barbol++;
                }

                x = (x + 3) % linesLength;
            }
            Console.WriteLine(barbol);
        }
    }
}

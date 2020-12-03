using System;

namespace E2
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] lines = System.IO.File.ReadAllLines("input.txt");

            int totalBarbol;

            totalBarbol = barbolCount(1, 1, lines);
            totalBarbol = totalBarbol * barbolCount(3, 1, lines);
            totalBarbol = totalBarbol * barbolCount(5, 1, lines);
            totalBarbol = totalBarbol * barbolCount(7, 1, lines);
            totalBarbol = totalBarbol * barbolCount(1, 3, lines);

            Console.WriteLine("Total: " + totalBarbol);
        }

        static int barbolCount(int xMove, int yMove, string[] lines)
        {
            int barbol = 0;
            int x = xMove;
            int linesLength = lines[0].Length;

            for (int y = yMove; y < lines.Length; y += yMove)
            {
                // if (yMove > 1) Console.WriteLine(y + " + " + yMove + " < " + (lines.Length - (yMove - 1)));

                if (lines[y][x] == '#')
                {
                    barbol++;
                }

                x = (x + xMove) % linesLength;
            }
            Console.WriteLine(xMove + "x " + " " + yMove + "y " + barbol);
            return barbol;
        }
    }
}

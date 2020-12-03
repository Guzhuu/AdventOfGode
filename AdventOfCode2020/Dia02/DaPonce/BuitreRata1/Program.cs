using System;
using System.Linq;

namespace BuitreRata1
{
    class Program
    {
        static int correctPasswords = 0;
        static void Main(string[] args)
        {
            string[] lines = System.IO.File.ReadAllLines("input.txt");

            foreach (string line in lines)
            {
                string[] lineParts = line.Split(" ");
                string[] ruleParts = lineParts[0].Split("-");
                char lookingFor = lineParts[1][0];
                int min = int.Parse(ruleParts[0]);
                int max = int.Parse(ruleParts[1]);

                int rep = 0;
                foreach (char c in lineParts[2].ToCharArray())
                {
                    if (c == lookingFor) rep++;
                }

                if (rep >= min && rep <= max)
                {
                    correctPasswords++;
                }
            }
            Console.WriteLine(correctPasswords);
        }
    }
}

using System;

namespace BuitreRata2
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
                int first = int.Parse(ruleParts[0]);
                int second = int.Parse(ruleParts[1]);

                int rep = 0;

                if (lineParts[2][first - 1] == lookingFor ^ lineParts[2][second - 1] == lookingFor) correctPasswords++;
            }
            Console.WriteLine(correctPasswords);
        }
    }
}

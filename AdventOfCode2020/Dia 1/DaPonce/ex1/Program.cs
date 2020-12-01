using System;
using System.Linq;

namespace ex1
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = System.IO.File.ReadAllLines("input.txt").Select((l) => int.Parse(l)).ToArray();
            Array.Sort(nums);

            int a = 0, b = nums.Length - 1, number = 2020, sum = 0;

            while (a < b)
            {
                sum = nums[a] + nums[b];
                if (sum > number)
                {
                    b--;
                }
                else if (sum < number)
                {
                    a++;
                }
                else
                {
                    Console.WriteLine(nums[a] * nums[b]);
                    break;
                }
            }
        }
    }
}
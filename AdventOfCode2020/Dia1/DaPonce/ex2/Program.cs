using System;
using System.Linq;

namespace ex2
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = System.IO.File.ReadAllLines("input.txt").Select((l) => int.Parse(l)).ToArray();
            Array.Sort(nums);

            ExistsNumbers(nums);
        }

        static bool ExistsNumbers(int[] nums)
        {
            int a = 0, b = 0, number = 2020, sum = 0;

            for (int i = 0; i < nums.Length - 2; i++)
            {
                a = i + 1;
                b = nums.Length - 1;
                while (a < b)
                {
                    sum = nums[a] + nums[b] + nums[i];
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
                        Console.WriteLine(nums[a] * nums[b] * nums[i]);
                        return true;
                    }
                }
            }

            return false;
        }
    }
}

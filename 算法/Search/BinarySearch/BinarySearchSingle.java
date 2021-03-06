//该程序只返回首次找到需要查找的元素的索引

public class BinarySearchSingle
{
	private static int[] arr = {1, 8, 10, 89, 1000, 1234};
	
	//二分法要求数组必须为有序数组，如果不是有序数组，需要首先对数组进行排列
	//二分法的思想即每次将数组一分为二，通过判断中间值来确定要查找的值在哪一个区间
	//经过递归后，即可锁定该值的位置，或者不存在该值
	//1.首先求出中间索引mid 和 中间索引的值midValue
	//2.判断midValue 和 findValue的大小
	// 2.1如果 midValue > findValue，则说明要找的值位于当前数组的左侧，即向左侧递归
	// 2.2如果 midValue < findValue，则说明要找的值位于当前数组的右侧，即向右侧递归
	// 2.3如果 midValue = findValue，则返回当前索引
	//3.退出的条件
	// 3.1找到结果，同2.3
	// 3.2没有找到，即递归后left > right
	public static int binarySearch(int[] arr, int left, int right, int findValue)
	{
		//首先应该判断当前时候继续执行该算法，即3.2条件是否满足
		if (left > right)
		{
			return -1;
		}
		//如果还可以继续查找的话，求出1中的两个值
		int mid = (left + right) / 2;
		int midValue = arr[mid];

		//执行2，判断情况，然后选择路径
		//此时对mid +1/-1 的操作是避免下一次递归是仍然判断mid处的值，造成运算浪费
		if (midValue > findValue)
		{
			return binarySearch(arr, left, mid - 1, findValue);
		}
		else if (midValue < findValue)
		{
			return binarySearch(arr, mid + 1, right, findValue);
		}
		else 
		{
			//此时说明midValue = findValue，返回当前索引
			return mid;
		}
	}

	public static void main(String[] args) 
	{
		int value1 = 8;
		int value2 = -2;
		int value3 = 10;
		System.out.println(value1 +"在数组中的位置是：" + BinarySearchSingle.binarySearch(arr, 0, arr.length, value1));
		System.out.println(value2 +"在数组中的位置是：" + BinarySearchSingle.binarySearch(arr, 0, arr.length, value2));
		System.out.println(value3 +"在数组中的位置是：" + BinarySearchSingle.binarySearch(arr, 0, arr.length, value3));
	}
}

public class LinkedListTest 
{
	public static void main(String[] args) 
	{
		//新建几个英雄节点 添加到链表
		HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
		HeroNode heroNode4 = new HeroNode(4, "公孙胜", "入云龙");
		HeroNode heroNode5 = new HeroNode(5, "李逵", "黑旋风");

		//定义一个链表
		SingleLinkedList sll = new SingleLinkedList();
		sll.addElement(heroNode1);
		sll.addElement(heroNode2);
		sll.addElement(heroNode3);
		sll.addElement(heroNode4);
		sll.addElement(heroNode5);

		//--------------
		//不可重复添加，否则会陷入死循环，因为重复添加时，会将带有next信息的节点添加进去
		//--------------

		//展示链表
		sll.showLinkedList();
	}
}


//创建一个管理链表的类
class SingleLinkedList
{
	//包含一个不存放数据的头节点
	private HeroNode head = new HeroNode(0, null, null);

	//给链表添加数据的方法
	public void addElement(HeroNode data)
	{
		//如果当前链表为空，则直接添加
		if (head.getNext() == null)
		{
			head.setNext(data);
			return;
		}
		//如果当前链表不为空，
		//1、则遍历链表找到尾部，
		//2、往链表尾部添加数据

		//定义一个辅助节点 来遍历链表
		HeroNode toolMan = head;
		while (true)
		{
			toolMan = toolMan.getNext();
			if (toolMan.getNext() == null)
			{
				//如果到了链表尾部
				toolMan.setNext(data);
				return;
			}
		}
	}

	public void showLinkedList()
	{
		//继续用辅助节点遍历
		HeroNode toolMan = head;
		while (true)
		{
			toolMan = toolMan.getNext();
			System.out.println(toolMan);
			if (toolMan.getNext() == null)
			{
				//如果到了链表尾部
				return;
			}
		}
	}
}

//创建一个链表的元素类
class HeroNode
{
	//数据包含了排名，名字，绰号，下一个英雄的地址
	private int no;
	private String name;
	private String nickName;
	private HeroNode next;

	//构造器
	public HeroNode(int no, String name, String nickName)
	{
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	//设置next
	public void setNext(HeroNode next)
	{
		this.next = next;
	}

	//查询next
	public HeroNode getNext()
	{
		return next;
	}

	//重写toString方法来输出结果
	public String toString()
	{
		return "HeroNode[no = " + no + ",name = " + name + ",nickName = " + nickName + "]";
	}
}
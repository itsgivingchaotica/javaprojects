public class FamilyLinkedList {
	QNode front, rear;
	
	public FamilyLinkedList()
	{
		this.front = this.rear = null;
	}
	
	void add(String name, int num)
	{
		QNode temp = new QNode(name,num);
		
		if (this.rear == null)
		{
			this.front = this.rear = temp;
			return;
		}
		this.rear.next = temp;
		this.rear = temp;
	}
	
	QNode getFront()
	{
		if (this.front == null)
			System.out.println("Queue is empty");
		return front;			
	}
}

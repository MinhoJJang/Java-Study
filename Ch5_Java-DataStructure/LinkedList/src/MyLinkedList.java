public class MyLinkedList {

    private MyListNode head;
    int count;

    public MyLinkedList()
    {
        head = null;
        count = 0;
    }

    // 리스트에 요소 추가하기
    public MyListNode addElement( String data )
    {
        MyListNode newNode = new MyListNode(data);
        if(head == null) {
            // 만약 링크드리스트에 아무것도 없다면? head = newNode이다.
            head = newNode;
        }
        else{
            // 만약 head에 무언가 존재한다면, LinkedList의 마지막 노드를 찾아야한다.
            MyListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        count++;

        return newNode; // true false를 반환해도 됨
    }

    // 리스트에 요소 삽입하기
    public MyListNode insertElement(int position, String data )
    {
        MyListNode newNode = new MyListNode(data);
        MyListNode temp = head;

        // position의 삽입 위치에 따라 분기를 나눈다.

        // 데이터가 존재하지 않는 곳이라면 즉시 삽입 실패
        if(position < 0 || position > count){
            return null;
        } else if (position == 0) {
            newNode.next = temp;
            head = newNode;
        } else {
            int i = position;
            MyListNode preNode = head;
            while (i-- > 1) {
                preNode = preNode.next;
            }
            newNode.next = preNode.next;
            preNode.next = newNode;
        }
        count++;

        return newNode;
    }

    public MyListNode removeElement(int position)
    {
        MyListNode temp = head;
        MyListNode preNode = temp;
        MyListNode removedNode = null;
        // position의 위치에 따라 분기를 나눈다.
        if(position < 0 || position > count){
            return null;
        }
        else if(position == 0){
            head = temp.next;
            removedNode = temp;
        } else{
            int i = position;
            while (i-- > 1){
                preNode = temp.next;
            }
            removedNode = preNode.next;
            preNode.next = removedNode.next;
        }
        count--;

        // C에서는 removedNode를 free 해줘야 하지만 Java는 grabage Collector가 자동으로 제거해준다.

        return removedNode;
    }

    public String getElement(int position)
    {
        int i;
        MyListNode tempNode = head;

        if(position >= count ){
            System.out.println("검색 위치 오류 입니다. 현재 리스트의 개수는 " + count +"개 입니다.");
            return new String("error");
        }

        if(position == 0){  //맨 인 경우

            return head.getData();
        }

        for(i=0; i<position; i++){
            tempNode = tempNode.next;

        }
        return tempNode.getData();
    }

    public MyListNode getNode(int position)
    {
        int i;
        MyListNode tempNode = head;

        if(position >= count ){
            System.out.println("검색 위치 오류 입니다. 현재 리스트의 개수는 " + count +"개 입니다.");
            return null;
        }

        if(position == 0){  //맨 인 경우

            return head;
        }

        for(i=0; i<position; i++){
            tempNode = tempNode.next;

        }
        return tempNode;
    }

    public void removeAll()
    {
        head = null;
        count = 0;

    }

    public int getSize()
    {
        return count;
    }

    public void printAll()
    {
        if(count == 0){
            System.out.println("출력할 내용이 없습니다.");
            return;
        }

        MyListNode temp = head;
        while(temp != null){
            System.out.print(temp.getData());
            temp = temp.next;
            if(temp!=null){
                System.out.print("->");
            }
        }
        System.out.println("");
    }

    public boolean isEmpty()
    {
        if(head == null) return true;
        else return false;
    }


}

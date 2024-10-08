/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xBrand, int xColor, int xWeight) {
    //You should write here appropriate statements to complete this function.
    if(xBrand.charAt(0) == 'B'){
        return;
    }
    Bike b = new Bike(xBrand, xColor, xWeight);
    Node newNode = new Node(b);
    if(isEmpty()){
        head = tail = newNode;
        return;
    }
    tail.next = newNode;
    tail = newNode;
   }

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void addFirst(Bike b){
      Node newNode = new Node(b);
      if(isEmpty()){
          head = tail = newNode;
          return;
      }
      newNode.next = head;
      head = newNode;
  }
 
  void addPos(Bike b, int index){
      Node newNode = new Node(b);
      if(isEmpty()){
          if(index == 0){
          head = tail = newNode;
          return;
          }
      }
      Node temp = head;
      if(index == 0){
          addFirst(b);
          return;
      }
      
      int count = 0;
      while(temp!=null){
          if(index - count == 1){
              newNode.next = temp.next;
              temp.next = newNode;
              if(temp == tail){
                  tail = newNode;
              }
              return;
          }
          count++;
          temp = temp.next;
      }
  }
  void f2() throws Exception {
     clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Bike x, y;
     x = new Bike("X",1,2);
     y = new Bike("Y",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      addPos(x, 1);
      addPos(y, 4);

    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
void delete(Node p){
        Node temp = this.head;
        if(isEmpty()){
            return;
        }
        while(temp != null){
            if(temp == p){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     if (head == null || head.next == null) {
        return;
    }
    
    Node prev = head;
    Node curr = head.next;
    Node min = head;
    Node secondMin = null;
    
    // find the minimum and second minimum nodes
    while (curr != null) {
        if (curr.info.color < min.info.color) {
            secondMin = min;
            min = curr;
        } else if (secondMin == null || curr.info.color < secondMin.info.color) {
            secondMin = curr;
        }
        prev = curr;
        curr = curr.next;
    }
    
    // remove the second minimum node
    if (secondMin == null) {
        return;
    }
    prev.next = secondMin.next;
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

//==================================================================
    Node get(int x){
        int count = 0;
        Node temp = head;
        while(temp!=null){
            if(count == x){
                return temp;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }
  void sortAsc(int start, int end){
      Node pi, pj;
      for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
		pi = get(i);
		pj = get(j);
		if(pi.info.color < pj.info.color) {
                    Bike temp;
                    temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
		}
            }	
	}
  }
  void sortDesc(int end, int start){
      Node pi, pj;
      for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
		pi = get(i);
		pj = get(j);
		if(pi.info.color > pj.info.color) {
                    Bike temp;
                    temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
		}
            }	
	}
  }
  int count(){
      Node p = head;
      int count = 0;
      while(p!=null){
          count++;
          p = p.next;
      }
      return count;
  }
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      sortAsc(0, 3);
      sortDesc(4, count()-1);

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }

/*
    In this question you should complete some methods in MyList.java file. The class Bike with 3 data members: brand, color and weight is given and you do not need to edit it. 
    The MyList class is a linked list of Bike objects. The following methods should be completed:
    =====================================================

    void addLast(String xBrand, int xColor, int xWeight) - check if xBrand.charAt(0) == 'B' then do nothing,   
    otherwise add new node with brand=xBrand, color=xColor, weight=xWeight to the end of the list. (color and weight can get arbitrary, even negative values).

    void f1()-Do not edit this method. Your task is to complete the addLast(...) method above only. 
    Output in the file f1.txt must be the following: 
    (A,9,8) (C,6,5) (D,2,4) (E,7,9) (F,4,-7) (G,-3,2)

    void f2()-There are 2 given Bike objects x, y in this function. Suppose the list contains at least 3 elements. 
    Write statements to insert x and y to the list so that x will be the 2nd, y will be the 5th node. 
    Output in the file f2.txt must be the following: 
    (C,9,8) (D,6,3) (E,8,5) (F,5,4) (1,4,9) (1,3,7)

    void f3()- Remove the second node having min color (thus if there is only one min color then do nothing). 
    Output in the file f3.txt must be the following: 
    (C,8,6) (D,3,8) (E,9,2) (F,5,8) (G,3,7) (H,6,8) (1,7,3)
    (C,8,6) (D,3,8) (E,9,2) (F,5,8) (H,6,8) (1,7,3)

    void f4() - Suppose the list contains at least 7 elements. Sort the first 4 elements ascendingly and the last 3 elements descendingly by color. 
    The content of the output file f4.txt must be the followeight:
    (C,9,8) (D,3,2) (E,10,7) (F,1,9) (1,6,4) (J,11,5) (K,7,6) 
    (F,1,9) (D,3,2) (C,9,8) (E,10,7) (J,11,5) (K,7,6) (1,6,4)
*/

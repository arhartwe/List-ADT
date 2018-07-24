/*
 *   Name         : Andrew Hartwell
 *   CruzID       : arhartwe
 *   Assignment   : pa1
*/

public class ListClient{
	public static void main(String[] args){
		List A = new List();
		List B = new List();

		for(int i = 1; i <= 20; i++){
			A.append(i);
			B.prepend(i);
		}
		System.out.println(A);
		System.out.println(B);

		for(A.moveFront(); A.index() >= 0; A.moveNext()){
			System.out.print(A.get() + " ");
		}
		System.out.println();
		for(B.moveBack(); B.index() >= 0; B.movePrev()){
			System.out.print(B.get() + " ");
		}
		System.out.println();

		List C = A.copy();
		System.out.println(A.equals(B));
		System.out.println(B.equals(C));
		System.out.println(C.equals(A));
		
		A.moveFront();
		for(int i = 0; i < 5; i++) A.moveNext();
		A.insertBefore(-1);
		for(int i = 0; i < 9; i++) A.moveNext();
		A.insertAfter(-2);
		for(int i = 0; i < 5; i++) A.movePrev();
		A.delete();
		System.out.println(A);
		System.out.println(A.length());
		A.clear();
		System.out.println(A.length());
	}
}

package arrays;

//Quickly find multiple left rotations of an array | Set 1

public class Prgm7 {
	int a[] = { 1, 3, 5, 7, 9 };
	int start = 0;
	int end = a.length - 1;

	public static void main(String[] args) {
		Prgm7 p = new Prgm7();
		int k = 1;
		p.rotateByK(k);	// time complexity = n
		k = 3;
		p.rotateByK(k);
		k = 4;
		p.rotateByK(k);
		k = 6;
		p.rotateByK(k);
		k = 7;
		p.rotateByK(k);
	}

	private void rotateByK(int k) {
		for (int i = k; i < a.length + k; i++)
			System.out.print(a[i % a.length] + " ");
		System.out.println();
	}
}
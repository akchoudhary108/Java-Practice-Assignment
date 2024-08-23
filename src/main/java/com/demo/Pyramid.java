package com.demo;

/**
 * @author Anjani Choudhary
 *
 */
public class Pyramid {
	public static void main(String[] args) {
		Pyramid pyramid = new Pyramid();
		pyramid.pyramid1();
		pyramid.pyramid2();
		pyramid.pyramid3();
		pyramid.pyramid4();
		pyramid.pyramid5();
		pyramid.pyramid6();
	}

	private void pyramid1() {
//		*
//		**
//		***
//		****
//		*****
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void pyramid2() {
//		     *
//		    **
//		   ***
//		  ****
//		 *****
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void pyramid3() {
//		*****
//		****
//		***
//		**
//		*		
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void pyramid4() {
//		*****
//		 ****
//		  ***
//		   **
//		    *
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 5; k >= i; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void pyramid5() {
//		*       *
//		**     **
//		***   ***
//		**** ****
//		*********
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			for (int k = 5; k > i + 1; k--) {
				System.out.print(" ");
			}
			for (int l = 5; l > i + 2; l--)
				System.out.print(" ");
			for (int l = 0; l <= i; l++) {
				if (l == 4 && i == 4)
					break;
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void pyramid6() {
//		*********
//		**** ****
//		***   ***
//		**     **
//		*       *
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			for (int k = 5; k > i; k--) {
				System.out.print(" ");
			}
			for (int m = 3; m >= i; m--) {
				if (i == 5 || i == 4)
					break;
				System.out.print(" ");
			}
			for (int l = 1; l <= i; l++) {
				if (i == 5 && l == 5)
					break;
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void pyramid7() {
//		    *
//		   ***
//		  *****
//		 *******
//		*********
	}

	private void pyramid8() {
//		*********
//		 *******
//		  *****
//		   ***
//	        *
	}
}

package src.main.java;

// Simple input from the keyboard for all primitive types. ver 1.0
// Copyright (c) Peter van der Linden,  May 5 1997.
//     corrected error message 11/21/97
//
// The creator of this software hereby gives you permission to:
//  1. copy the work without changing it
//  2. modify the work providing you send me a copy which I can
//     use in any way I want, including incorporating into this work.
//  3. distribute copies of the work to the public by sale, lease, 
//     rental, or lending
//  4. perform the work
//  5. display the work
//  6. fold the work into a funny hat and wear it on your head.
//
// This is not thread safe, not high performance, and doesn't tell EOF.
// It's intended for low-volume easy keyboard input.
// An example of use is:
//     EasyIn easy = new EasyIn();
//     int i = easy.readInt();   // reads an int from System.in
//     float f = easy.readFloat();   // reads a float from System.in

import java.io.*;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class EasyIn.
 */
public class EasyIn {

	/** The is. */
	static InputStreamReader is = new InputStreamReader(System.in);

	/** The br. */
	static BufferedReader br = new BufferedReader(is);

	/** The st. */
	StringTokenizer st;

	/**
	 * Instantiates a new easy in.
	 */
	public EasyIn() {
		st = null;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	StringTokenizer getToken() throws IOException {
		String s = br.readLine();
		return new StringTokenizer(s);
	}

	/**
	 * Read boolean.
	 *
	 * @return true, if successful
	 */
	public boolean readBoolean() {
		try {
			st = getToken();
			return new Boolean(st.nextToken()).booleanValue();
		} catch (IOException ioe) {
			System.err.println("IO Exception in EasyIn.readBoolean");
			return false;
		}
	}

	/**
	 * Read byte.
	 *
	 * @return the byte
	 */
	public byte readByte() {
		try {
			st = getToken();
			return Byte.parseByte(st.nextToken());
		} catch (IOException ioe) {
			System.err.println("IO Exception in EasyIn.readByte");
			return 0;
		}
	}

	/**
	 * Read short.
	 *
	 * @return the short
	 */
	public short readShort() {
		try {
			st = getToken();
			return Short.parseShort(st.nextToken());
		} catch (IOException ioe) {
			System.err.println("IO Exception in EasyIn.readShort");
			return 0;
		}
	}

	/**
	 * Read int.
	 *
	 * @return the int
	 * @throws NullPointerException
	 *             the null pointer exception
	 * @throws NumberFormatException
	 *             the number format exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public int readInt() throws NullPointerException, NumberFormatException,
			IOException {
		while (true) {
			int count = 0;
			while (count < 4) {
				count++;
				try {
					st = getToken();
					if (!(st.hasMoreTokens())) {
						System.err.println("You did not enter a Integer value"
								+ "\nPlease Enter a Integer Value: ");
					} else {
						count = 4;
						return Integer.parseInt(st.nextToken());
					}
				} catch (IOException ioe) {
					System.err.println("IO Exception in EasyIn.readInt");
				} catch (NumberFormatException nme) {
					System.err
							.println("Number Format Exception in EasyIn.readInt"
									+ "\nPlease Enter an Integer Value: ");
				} catch (NullPointerException npe) {
					System.err
							.println("Null Pointer Exception in EasyIn.readInt"
									+ "\nPlease Enter an Integer Value: ");
				} catch (NoSuchElementException npe) {
					System.err
							.println("No Such Element Exception in EasyIn.readInt"
									+ "\nPlease Enter an Integer Value: ");
				}
			}
			System.out
					.println("You have entered an incorrect value more than three times."
							+ "\nThe program will now exit...");
			System.exit(0);
		}
	}

	/**
	 * Read long.
	 *
	 * @return the long
	 */
	public long readLong() {
		try {
			st = getToken();
			return Long.parseLong(st.nextToken());
		} catch (IOException ioe) {
			System.err.println("IO Exception in EasyIn.readLong");
			return 0L;
		}
	}

	/**
	 * Read float.
	 *
	 * @return the float
	 */
	public float readFloat() {
		try {
			st = getToken();
			return new Float(st.nextToken()).floatValue();
		} catch (IOException ioe) {
			System.err.println("IO Exception in EasyIn.readFloat");
			return 0.0F;
		}
	}

	/**
	 * Read double.
	 *
	 * @return the double
	 * @throws NullPointerException
	 *             the null pointer exception
	 * @throws NumberFormatException
	 *             the number format exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	public double readDouble() throws NullPointerException,
			NumberFormatException, IOException {
		while (true) {
			int count = 0;
			while (count < 4) {
				count++;
				try {
					st = getToken();
					if (!(st.hasMoreTokens())) {
						System.err.println("You did not enter a Double value"
								+ "\nPlease Enter a Double Value: ");
					} 
					else {
						count = 4;
						return new Double(st.nextToken()).doubleValue();
					}
				} 
				catch (IOException ioe) {
					System.err.println("IO Exception in EasyIn.readDouble"
							+ "\nPlease Enter a String Value: ");
				} 
				catch (NumberFormatException nme) {
					System.err
							.println("Number Format Exception in EasyIn.readDouble"
									+ "\nPlease Enter a Double Value: ");
				} 
				catch (NullPointerException npe) {
					System.err
							.println("Null Pointer Exception in EasyIn.readDouble"
									+ "\nPlease Enter a Double Value: ");
				} 
				catch (NoSuchElementException npe) {
					System.err
							.println("No Such Element Exception in EasyIn.readDouble"
									+ "\nPlease Enter a Double Value: ");
				}
			}
			System.out
					.println("You have entered an incorrect value more than three times."
							+ "\nThe program will now exit...");
			System.exit(0);
		}
	}

	/**
	 * Read char.
	 *
	 * @return the char
	 */
	public char readChar() {
		try {
			String s = br.readLine();
			return s.charAt(0);
		} catch (IOException ioe) {
			System.err.println("IO Exception in EasyIn.readChar");
			return 0;
		}
	}

	/**
	 * Read string.
	 *
	 * @return the string
	 * @throws NullPointerException
	 *             the null pointer exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	public String readString() throws NullPointerException, IOException,
			NoSuchElementException {
		while (true) {
			int count = 0;
			while (count < 4) {
				count++;
				try {
					String str = br.readLine();
					if (str.equals("")) {
						System.err.println("You did not enter a String value"
								+ "\nPlease Enter a String Value: ");
					} else {
						count = 4;
						return str;
					}
				} catch (IOException ioe) {
					System.err.println("IO Exception in EasyIn.readString"
							+ "\nPlease Enter a String Value: ");
				} catch (NullPointerException npe) {
					System.err
							.println("Null Pointer Exception in EasyIn.readInt"
									+ "\nPlease Enter a String Value: ");
				} catch (NoSuchElementException nsee) {
					System.err
							.println("No Such Element Exception in EasyIn.readInt"
									+ "\nPlease Enter a String Value: ");
				}
			}
			System.out
					.println("You have entered an incorrect value more than three times."
							+ "\nThe program will now exit...");
			System.exit(0);
		}
	}
}

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.tools.*;
import java.util.*;

class Sec	{
	public ArrayList pathOfRecursion;
	public int cntOfpathOfRecursion;
	public int pathLimit;
	
	public String[] printRec;
	int hoiNai;
	
	public static void main(String[] Args){
		//Koro.pathOfRecursion = new ArrayList();
		Sec sc = new Sec();
		//sc.shapePathOfRecursion();
	}
	void state(int pastCnt)	{
		String ss;ss = " " + pastCnt + " ";printRec[pastCnt] = ss;
	}
	void state(Object st1, int pastCnt)	{
		String ss;ss = " " + st1 + " ";printRec[pastCnt] = ss;
	}
	void state(Object st1, Object st2, int pastCnt)	{
		String ss;ss = " " + st1 + " " + st2 + " ";printRec[pastCnt] = ss;
	}
	void state(Object st1, Object st2, Object st3, int pastCnt)	{
		String ss;ss = " " + st1 + " " + st2 + " " + st3 + " ";printRec[pastCnt] = ss;
	}
	void state(Object st1, Object st2, Object st3, Object st4, int pastCnt)	{
		String ss;ss = " " + st1 + " " + st2 + " " + st3 + " " + st4 + " ";printRec[pastCnt] = ss;
	}
	void state(Object st1, Object st2, Object st3, Object st4, Object st5, int pastCnt)	{
		String ss;ss = " " + st1 + " " + st2 + " " + st3 + " " + st4 + " " + st5 + " ";printRec[pastCnt] = ss;
	}
	void state(Object st1, Object st2, Object st3, Object st4, Object st5, Object st6, int pastCnt)	{
		String ss;ss = " " + st1 + " " + st2 + " " + st3 + " " + st4 + " " + st5 + " " + st6 + " ";printRec[pastCnt] = ss;
	}
	Sec()	{
		
		hoiNai = 0;pathLimit = 1000;
		printRec = new String[(pathLimit * 3)];
		for(int i = 0; i < (pathLimit * 3); i++)	{
			printRec[i] = "";
		}
		
		pathOfRecursion = new ArrayList();
		
		cntOfpathOfRecursion = 0;
		call();
		
		shapePathOfRecursion();
		//for base case we don't get endpath for that state that's why we have to shape path for those states
		if(hoiNai == 1)	{
			//System.out.println("state more than 1000 is not allowed");
			ErrorFrame ef = new ErrorFrame("state more than 1000 is not allowed", "ERROR", 1);
			//System.exit(0);
		}
		else	{
			print_path();
			Kaj kaj = new Kaj(this);
			MainFrame mf = new MainFrame(kaj);
		}
		
		/*
		Kaj kaj = new Kaj(this);
		MainFrame mf = new MainFrame(kaj);
		*/
	}
	Sec(Koro kr)	{
		hoiNai = 0;pathLimit = 1000;
		printRec = new String[(pathLimit * 3)];
		for(int i = 0; i < (pathLimit * 3); i++)	{
			printRec[i] = "";
		}
		pathOfRecursion = new ArrayList();
		
		cntOfpathOfRecursion = 0;
		call();
		
		shapePathOfRecursion();
		//for base case we don't get endpath for that state that's why we have to shape path for those states
		if(hoiNai == 1)	{
			
		}
		else	{
			print_path();
			/*
			if(cntOfpathOfRecursion == pathLimit)	{
				
			}
			*/
			Kaj kaj = new Kaj(this);
			MainFrame mf = new MainFrame(kaj);
		}
		
		//comeHereIfSomethingWrong:
		
	}
	void terminatePlease()	{
		hoiNai = 1;
	}
	int firstLine()	{
		pathOfRecursion.add(cntOfpathOfRecursion);
		cntOfpathOfRecursion++;
		return (cntOfpathOfRecursion - 1);
	}
	void lastLine(int pastCnt)	{
		pathOfRecursion.add(pastCnt);
	}
	void shapePathOfRecursion()	{
		int cnt[];cnt = new int[pathLimit + 10];
		int bigVal = 0;
		//System.out.println(cnt[0]);
		
		if(pathOfRecursion == null)	{
			return;
		}
		
		for(int i = 0; i < pathOfRecursion.size(); i++)	{
			int tmp = (int)pathOfRecursion.get(i);
			cnt[tmp]++;
			if(tmp > bigVal)	{
				bigVal = tmp;
			}
		}
		
		
		for(int i = 0; i < pathOfRecursion.size(); i++)	{
			int tmp = (int)pathOfRecursion.get(i);
			if(cnt[tmp] == 1)	{
				pathOfRecursion.add(i, tmp);
				i++;
			}
		}
		
	}
	
	void print_path()	{
		if(pathOfRecursion != null)	{
			for(int i = 0; i < pathOfRecursion.size(); i++)	{
				int tmp = (int)pathOfRecursion.get(i);
				System.out.print(tmp + " ");
			}
			System.out.println("");
		}
		else	{
			System.out.print("something is wrong please check");
		}
	}
	//$
	void call()	{
		System.out.println("hi\n");
	}
}



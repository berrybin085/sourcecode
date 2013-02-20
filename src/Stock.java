import Boundary.SysConsole;
import Control.StockRecordControl;
import Control.AddWineRecordControl;
import domain.WineRecord;

import java.io.IOException;
import java.util.*;

public class Stock {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean flag = true;
		SysConsole sc = new SysConsole();
		sc.outputMenu();
		Scanner in=new Scanner(System.in);
		String input = in.next().toString();
 	    sc.menuSelect(input);
	}	

}

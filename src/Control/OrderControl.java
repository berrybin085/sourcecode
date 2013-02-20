package Control;
import domain.SellRecord;
import domain.WineRecord;

import java.io.IOException;
import java.util.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;
public class OrderControl {
    private static final String Message1 = "ˆê•”ğ‚ªİŒÉ‚È‚µ";
    private static final String Message2 = "‚·‚×‚Ä‚Ìğ‚ªİŒÉ‚È‚µ";
    private static final String Message3 = "===========BILL==========";
    private static final String SPACE = " ";

    
	public void orderProcess(String guestName, List<WineRecord> listWine) throws IOException{
		
		Facade fc = new Facade();
		int billNo;
		List<WineRecord> billWineRecord = new ArrayList<WineRecord>();
		List<WineRecord> wineRecord = fc.getWineRecord();
		
		for(int i=0;i<listWine.size();i++){
			WineRecord wr = new WineRecord();
			
			wr = listWine.get(i);
			if(fc.checkWineRecord(wr, wineRecord)){
				
				
				billWineRecord.add(wr);
				
			}
			
		}
		if(billWineRecord.size()==0){
			
			System.out.println(Message2);
		}
		else if(billWineRecord.size()<listWine.size()){
			
			System.out.println(Message1);
			System.out.println(Message3);
			billNo = fc.generateBillNo();
			System.out.print("No."+billNo+SPACE+guestName+SPACE);
			for(int i=0;i<billWineRecord.size();i++){
				
				System.out.print(billWineRecord.get(i).getWineName()+SPACE+billWineRecord.get(i).getWineNum()+SPACE);
			}
			fc.setBillRecord(billNo, guestName, billWineRecord);
			fc.updateWineRecord(billWineRecord);
			
		}
		else{
			System.out.println(Message3);
			billNo = fc.generateBillNo();
			System.out.print("No."+billNo+SPACE+guestName+SPACE);
			for(int i=0;i<billWineRecord.size();i++){
				
				System.out.print(billWineRecord.get(i).getWineName()+SPACE+billWineRecord.get(i).getWineNum()+SPACE);
			}
			fc.setBillRecord(billNo, guestName, billWineRecord);
			fc.updateWineRecord(billWineRecord);
		}
		
		
		
		
	}
    
}

package Control;
import Control.Facade;
import java.io.IOException;
import java.util.*;
import domain.WineRecord;
import domain.SellRecord;


public class BillListControl {
	
	
    public List<SellRecord> getGuestBillRecord(String guestName) throws IOException{
    	List<SellRecord> lsGuestBillRec = new ArrayList<SellRecord>();
    	List<SellRecord> lsBillRec = new ArrayList<SellRecord>(); 
    	Facade fc = new Facade();
    	lsBillRec = fc.getsellRecord();
    	for(int i=0;i<lsBillRec.size();i++){
    		if(lsBillRec.get(i).getGuestName().equals(guestName)){
    			
    			lsGuestBillRec.add(lsBillRec.get(i));
    			
    		}
    		
    	}
    	
		return lsGuestBillRec;
    	
    	
    	
    }
}

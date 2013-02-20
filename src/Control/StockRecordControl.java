package Control;
import Control.Facade;
import java.io.IOException;
import java.util.*;
import domain.WineRecord;


public class StockRecordControl {

	public List<WineRecord> getStockRecord() throws IOException{
		
		Facade fc = new Facade();
		List<WineRecord> rtnlsWRecord;
		rtnlsWRecord = fc.getWineRecord();
		
		return rtnlsWRecord;
	}
}

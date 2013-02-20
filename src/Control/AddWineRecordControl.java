package Control;
import Control.Facade;
import java.io.IOException;
import java.util.*;
import domain.WineRecord;

public class AddWineRecordControl{

	public void setWineRecord(List<WineRecord> rtnlsWRecord) throws IOException {
	Facade fc = new Facade();
	fc.setWineRecordForNew(rtnlsWRecord);
	System.out.println("“ü‰×‚µ‚Ü‚µ‚½");
	
	
	}
	
}

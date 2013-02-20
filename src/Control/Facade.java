package Control;
import java.io.*;
import java.util.*;
import domain.WineRecord;
import domain.SellRecord;


public class Facade {

	private static final  String  SPACE = " ";
	private static final  String  ENPTY = "";
	
	public List<WineRecord> getWineRecord() throws IOException{	
		String path = "C:/WineRecord.txt";
		File filename = new File(path);
		if(!filename.exists()){
			filename.createNewFile();	
		}
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String brStr;
		String wineName;
		int wineNum;
		String[] str;
		List<WineRecord> listWinRe = new ArrayList();
		WineRecord wineRe;
		
		brStr = br.readLine();
		while(brStr != null){
			str = brStr.split(" ");
			wineName = str[0]; 
			wineNum = Integer.parseInt(str[1]);
			wineRe = new WineRecord();
			wineRe.setWineName(wineName);
			wineRe.setWineNum(wineNum);
			listWinRe.add(wineRe);
			brStr = br.readLine();
		}
		return listWinRe;
		
	}
	
	public void setWineRecord(List<WineRecord> lsWinRec) throws IOException{
		String strPath = "C:/WineRecord.txt";
		File f = new File(strPath);
		FileWriter outFile=new FileWriter(strPath,true);
		String nextLine = System.getProperty("line.separator");
		try{
		if(!f.exists()){
			 f.createNewFile();
			
			
		}
		for(int i=0;i<lsWinRec.size();i++){
			
			String wrWineRecord = new String();
			wrWineRecord = lsWinRec.get(i).getWineName()+SPACE
			+Integer.toString(lsWinRec.get(i).getWineNum());
			outFile.write(wrWineRecord+nextLine);
			outFile.flush();
			
			
		}
		outFile.close();
		System.out.println("“ü‰×‚µ‚Ü‚µ‚½");
		}
		catch(IOException e){
			
			e.getMessage();
		}
		
	}
	
	public void setWineRecordForNew(List<WineRecord> lsWinRec) throws IOException{
		String strPath = "C:/WineRecord.txt";
		File f = new File(strPath);
		FileWriter outFile=new FileWriter(strPath);
		String nextLine = System.getProperty("line.separator");
		try{
		if(!f.exists()){
			 f.createNewFile();
			
			
		}
		for(int i=0;i<lsWinRec.size();i++){
			
			String wrWineRecord = new String();
			wrWineRecord = lsWinRec.get(i).getWineName()+SPACE
			+Integer.toString(lsWinRec.get(i).getWineNum());
			outFile.write(wrWineRecord+nextLine);
			outFile.flush();
			
			
		}
		outFile.close();
		
		}
		catch(IOException e){
			
			e.getMessage();
		}
		
	}
	
	public void updateWineRecord(List<WineRecord> lsSellRec) throws IOException{
		List<WineRecord> oldWineRec = getWineRecord();
		for(int i=0;i<lsSellRec.size();i++){
			for(int j=0;j<oldWineRec.size();j++){
				if(lsSellRec.get(i).getWineName().equals(oldWineRec.get(j).getWineName())){
					oldWineRec.get(j).setWineNum(oldWineRec.get(j).getWineNum()-lsSellRec.get(i).getWineNum());
			}
			}
			
		}
		setWineRecordForNew(oldWineRec);
		
	}
	
	public int generateBillNo() throws IOException{
		int billNo;
		billNo = getsellRecordNum()+1;
		return billNo;
	
	}
	
	public boolean checkWineRecord(WineRecord wRecord,List<WineRecord> listWinRe) throws IOException{
		
		boolean rtnFlag = false;
		int inputWineNum,wineNum;
		String inputWineName,wineName;
		inputWineNum = wRecord.getWineNum();
		inputWineName = wRecord.getWineName();
		for(int i=0;i<listWinRe.size();i++){
			wineNum = listWinRe.get(i).getWineNum();
			wineName = listWinRe.get(i).getWineName();
			if(inputWineName.equals(wineName)&&(wineNum>=inputWineNum)){
				
				rtnFlag = true;
			}
			
		}
		return rtnFlag;
	}
	
	public void setBillRecord(int BillNo,String guestName,List<WineRecord> listWinRe) throws IOException{
		
		String strPath = "C:/BillRecord.txt";
		File f = new File(strPath);
		FileWriter outFile=new FileWriter(strPath,true);
		String nextLine = System.getProperty("line.separator");
		try{
		if(!f.exists()){
			 f.createNewFile();
			
			
		}
		String wrWineRecord_1;
		String wrWineRecord_2 = ENPTY;
		String billInfo;
		wrWineRecord_1 = Integer.toString(BillNo)+SPACE+guestName+SPACE;
		for(int i=0;i<listWinRe.size();i++){
			
			
			wrWineRecord_2 += listWinRe.get(i).getWineName()+SPACE
			+Integer.toString(listWinRe.get(i).getWineNum())+SPACE;
	
		}
		billInfo = wrWineRecord_1 + wrWineRecord_2.substring(0,wrWineRecord_2.length());
		if(getsellRecord().size()== 0){
		outFile.write(billInfo);
		}
		else{
			outFile.write(nextLine+billInfo);
		
		}
		outFile.flush();
		outFile.close();

		}
		catch(IOException e){
			
			e.getMessage();
		}
	}
	
	public int getsellRecordNum() throws IOException{
		String path = "C:/BillRecord.txt";
		File filename = new File(path);
		if(!filename.exists()){
			filename.createNewFile();	
		}
		BufferedReader br = new BufferedReader(new FileReader(filename));
		int billNo;
		String guestName;
		String wineRecord=ENPTY;
		String brStr;
		String[] str;
		
		
		List<SellRecord> listSellRe = new ArrayList<SellRecord>();
		List<WineRecord> lsWineRe = new ArrayList<WineRecord>();
		
		brStr = br.readLine();
		while(brStr != null){
			str = brStr.split(" ");
			billNo = Integer.parseInt(str[0]); 
			guestName = str[1];
			for(int i=2;i<str.length-1;i=i+2){
				WineRecord wr = new WineRecord();
				wr.setWineName(str[i]);
				wr.setWineNum(Integer.parseInt(str[i+1]));
				lsWineRe.add(wr);
				
			}
			SellRecord sr =new SellRecord();
			sr.setSellNum(billNo);
			sr.setGuestName(guestName);
			sr.setListRecord(lsWineRe);
			listSellRe.add(sr);
			brStr = br.readLine();
		}
		return listSellRe.size();
		
	}
	
	
public List<SellRecord> getsellRecord() throws IOException{
		String path = "C:/BillRecord.txt";
		File filename = new File(path);
		if(!filename.exists()){
			filename.createNewFile();	
		}
		BufferedReader br = new BufferedReader(new FileReader(filename));

		int billNo;
		String guestName;
		String wineRecord=ENPTY;
		String brStr;
		String[] str;
		
		
		List<SellRecord> listSellRe = new ArrayList<SellRecord>();
		
		
		brStr = br.readLine();
		while(brStr != null){
			List<WineRecord> lsWineRe = new ArrayList<WineRecord>();
			str = brStr.split(" ");
			billNo = Integer.parseInt(str[0]); 
			guestName = str[1];
			for(int i=2;i<str.length-1;i=i+2){
				WineRecord wr = new WineRecord();
				wr.setWineName(str[i]);
				wr.setWineNum(Integer.parseInt(str[i+1]));
				lsWineRe.add(wr);
				
			}
			SellRecord sr =new SellRecord();
			sr.setSellNum(billNo);
			sr.setGuestName(guestName);
			sr.setListRecord(lsWineRe);
			listSellRe.add(sr);
			brStr = new String();
			brStr = br.readLine();
			
		}
		return listSellRe;
		
	}
	
}

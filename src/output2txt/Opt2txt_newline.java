package output2txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;
//use this one to write as pdf
public class Opt2txt_newline {
	
	public static void main(String[] args) throws DocumentException, IOException {
		Date date=Calendar.getInstance().getTime();

		 PrintWriter writer = new PrintWriter("./report.txt", "UTF-8");		
		writer.println("AUXO AUTOMATION TEST,  CONCORD CAPTURE   <Version 2.9>,  "+date.toLocaleString());
		writer.println("The second line");
		writer.close();
		//-----------pdf--------------------------
		String TEXT= "./report.txt";
    	String dest= "./txt2pdfsss.pdf";
        File file = new File(dest);
       // file.getParentFile().mkdirs();
    	
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        BufferedReader br = new BufferedReader(new FileReader(TEXT));
        String line;
        Paragraph p;
        Font normal = new Font(FontFamily.TIMES_ROMAN, 12);
        Font bold = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        //Font custom=new Font(FontFamily.TIMES_ROMAN,16,Font.BOLD);
        boolean title = true;
        while ((line = br.readLine()) != null) {
            p = new Paragraph(line, title ? bold : normal);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            title = line.isEmpty();
            document.add(p);
        }
        document.close();
	}


}



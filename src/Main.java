import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Main {
    static JButton print,additem,clear;
    static JLabel lt,l1,l2 ,l3, l4,l5,l6,l7,l8,l9,l10;
    static JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    static JTextArea a1,to;

    static float rate,weight,total,totalwithgst,granttotal,igst;

    static String descrip,toaddr,gstin,state,code,date,path,toname,invno,hsn,numberinrs;
    static class myframe extends JFrame implements ActionListener{
        myframe(){
            lt= new JLabel("TAX INVOICE ");
            l1=new JLabel("DESCRIPTION OF GOODS: ");
            l2= new JLabel("WEIGHT IN KG:");
            l3=new JLabel("RATE:");
            l4 =new JLabel("FOR TOTAL WITH GST:");
            l5 = new JLabel("TO");
            l6=new JLabel("GSTIN");
            l7=new JLabel("STATE");
            l8=new JLabel("CODE");
            l9=new JLabel("DATE");
            l10 =new JLabel("PATH");

            t1=new JTextField("enter info");
            t2=new JTextField("0");
            t3=new JTextField("0");
            t4=new JTextField( "00");

            t5 = new JTextField("enter GSTIN");
            t6=new JTextField("enter state");
            t7=new JTextField("enter code");
            t8=new JTextField("enter date");
            t9= new JTextField("G:\\TAX_INVOICE.pdf");
            t10=new JTextField("TO NAME");
            t11=new JTextField("enter invoice number");
            t12=new JTextField("enter hsn\sac code");

            to= new JTextArea("TO ADDRS");

            a1 = new JTextArea("PREVIEW");
            print= new JButton("PRINT");
            additem =new JButton("ADD ITEM");
            clear = new JButton("CLEAR");

            lt.setBounds(300,40,100,40);
            l1.setBounds(20,100,400,40);
            l2.setBounds(20,150,400,40);
            l3.setBounds(20,200,400,40);
            l4.setBounds(20,250,400,40);
            l5.setBounds(20,300,400,40);
            l6.setBounds(20,400,400,40);
            l7.setBounds(20,450,400,40);
            l8.setBounds(20,500,400,40);
            l9.setBounds(20,550,400,40);
            l10.setBounds(20,600,400,40);


            t1.setBounds(500,100,200,40);
            t2.setBounds(500,150,200,40);
            t3.setBounds(500,200,200,40);
            t4.setBounds(500,250,200,40);
            to.setBounds(500,300,200,80);
            t5.setBounds(500,400,200,40);
            t6.setBounds(500,450,200,40);
            t7.setBounds(500,500,200,40);
            t8.setBounds(500,550,200,40);
            t9.setBounds(20,650,400,40);
            t10.setBounds(20,700,400,40);
            t11.setBounds(20,750,400,40);
            t12.setBounds(20,800,400,40);


            a1.setBounds(800,100,400,800);


            clear.setBounds(500,600,100,40);
            additem.setBounds(600,600,100,40);
            print.setBounds(500,650,200,40);
            this.pack();
            this.setSize(1200,890);
            this.setVisible(true);

            this.add(lt);
            this.add(l1);
            this.add(l2);
            this.add(l3);
            this.add(l4);
            this.add(l5);
            this.add(l6);
            this.add(l7);
            this.add(l8);
            this.add(l9);
            this.add(l10);



            this.add(t1);
            this.add(t2);
            this.add(t3);
            this.add(t4);
            this.add(to);
            this.add(t5);
            this.add(t6);
            this.add(t7);
            this.add(t8);
            this.add(t9);
            this.add(t10);
            this.add(t11);
            this.add(t12);

            this.add(a1);

            this.add(clear);
            this.add(additem);
            this.add(print);
            this.setLayout(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.add(print);
            this.add(clear);
            this.add(l1);
            this.add(l2);
            print.addActionListener(this);
            clear.addActionListener(this);
            additem.addActionListener(this);


        }

        @Override
        public void actionPerformed(ActionEvent ae) {

            descrip= t1.getText();
            weight= Float.parseFloat(t2.getText());
            rate = Float.parseFloat(t3.getText());
            totalwithgst= Float.parseFloat(t4.getText());
            toaddr = to.getText();
            gstin = t5.getText();
            state = t6.getText();
            code = t7.getText();
            date = t8.getText();
            path =t9.getText();
            toname=t10.getText();
            invno=t11.getText();
            hsn=t12.getText();
            float a;

            if (rate!=0&&totalwithgst==0){
                total=weight*rate;
                igst= (float) (total*(0.03));
                granttotal=total+igst;
            }else {
                granttotal=totalwithgst;
                rate= (float) (granttotal/(weight*(1+0.03)));
                total=weight*rate;
                igst= (float) (total*(0.03));
            }




            //======================================================================================================================
            float n1 = granttotal;
            int num = (int) (n1%10);
            ArrayList<Integer> num1=new ArrayList<Integer>();
            ArrayList<Integer> num2=new ArrayList<Integer>();

            num1.add(0);
            num1.add(1);
            num1.add(2);
            num1.add(3);
            num1.add(4);
            num1.add(5);
            num2.add(6);
            num2.add(7);
            num2.add(8);
            num2.add(9);

            float realnum = 0;

            for (int j =0;j <num2.size();j++ ){

                if (num == num2.get(j)){
                    realnum=n1+(10-num2.get(j));
                    System.out.println(realnum);
                }

            }
            for (int i =0;i <num1.size();i++ ){

                if (num == num1.get(i)){
                    realnum=n1-num1.get(i);
                    System.out.println(realnum);
                }

            }



            //==========================================================================================================
            int n= (int) granttotal;

            if (n==0)
            {
                System.out.print("Zero");
            }
            else
            {
            /*
            int c=0;
            for(int i=n;i>0;i/=10)
            {
                c++;
            }
            System.out.print(c);
            */

                String wrd=String.valueOf(n);
                int l=wrd.length(); //for length of number ie. no of digits in the number

                //Declaration of variables
                String z="",zz="";
                int i=0,c=0,nn=0,nnn=0,zzc=0;

                //Start the loop
                for (i=l-1;i>=0;i--)
                {
                    char cc=wrd.charAt(i);
                    c=Integer.valueOf(String.valueOf(cc));//current digit


                    //Arrays
                    String uw[]={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixten","Seventeen","Eighteen","Ninteen"};
                    String tw[]={"","Ten","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
                    //Arrays//

                    //for combating double digit numbers like 13,14,15...  Start
                    if(i>0)
                    {
                        zz=wrd.substring(i-1,i+1);  //substring extracts string from string(.substring (inclusive,exclusive))
                        zzc=Integer.valueOf(zz);    //contains last two digits eg. 1234 and c=3, so zzc =23
                    }
                    else
                    {
                        zzc=22;
                    }
                    //for combating double digit numbers like 13,14,15...  End


                    /*nnn is the number of DIGITS CONVERTED AND it is for when hundred/thousand/lakh etc. SHOULD BE INSERTED.
                     * nn also controls the number of digits conveted but it needs to resets on hundred/thousand/lakh etc...   HERE USED FOR CHECKING UNIT PLACE
                     * Z contains the NUMBER_WORD*/
                    if (nnn==2)
                    {
                        if(c!=0){ //Just to eliminate 0 problem, in case.
                            z="hundred "+z;
                        }
                        nn=0;
                    }
                    if (nnn==3)
                    {
                        if(c!=0){
                            z="thousand "+z;
                        }
                        nn=0;
                    }
                    if (nnn==5)
                    {
                        if(c!=0){
                            z="lakh "+z;
                        }
                        nn=0;
                    }
                    if (nnn==7)
                    {
                        if(c!=0){
                            z="crore "+z;
                        }
                        nn=0;
                    }
                    if (nnn==9)
                    {
                        if(c!=0){
                            z="arab "+z;
                        }
                        nn=0;
                    }
                    if (nnn==11)
                    {
                        if(c!=0){
                            z="kharab "+z;
                        }
                        nn=0;
                    }


                    //Main
                    if(zzc<20 && nnn!=1 && nnn==0)  //up till 19
                    {
                        z=uw[zzc]+" "+z;
                        nn++;nnn++;i--;  //since two digits crossed(one extra digit).
                    }
                    else if(zzc<20 && nnn!=1 && nnn%2!=0)
                    {
                        z=uw[zzc]+" "+z;
                        nn++;nnn++;i--;  //since two digits crossed(one extra digit).
                    }
                    else if(nn%2==0)       //One,two,three... etc Unit place words
                    {
                        z=uw[c]+" "+z;
                    }
                    else   //ten,twenty,thirty... etc Tens place words
                    {
                        z=tw[c]+" "+z;
                    }
                    nn++;nnn++;     //++ -One more digit converted to word
                }
                //Print
                System.out.println("\nNumber in Words: \n"); //for printing purposes
                System.out.println(z);
                numberinrs=z;



            }







            if(ae.getSource()==additem){

                a1.setText("entered description:\n "+descrip +
                        "\nentered weight:\n" +weight+
                        "\nentered rate:\n"+rate+
                        "\nentered total with gst:\n"+totalwithgst+
                        "\ntotal amoumt\n"+total+
                        "\nigst of the amount 3% :\n"+igst+
                        "\ngranttotal :\n"+granttotal+
                        "\n============================\n"+
                        "\n entered to address :\n"+toaddr+
                        "\n entered gstin :\n"+gstin+
                        "\n  entered code :\n"+code+
                        "\n entered state:\n"+ state+
                        "\nentered the date :\n"+ date+
                        "\n entered to name :\n " + toname+
                        "\n entered  invoice no :\n " + invno+
                        "\n entered  hsn no :\n " + hsn+
                        "\n total  in words :\n " + numberinrs);

            } else if (ae.getSource()==clear) {
                t1.setText("enter info");
                descrip="";
                t2.setText("0");
                weight=0;
                t3.setText("0");
                rate=0;
                t4.setText("0");
                totalwithgst=0;
                total=0;
                igst =0;
                granttotal=0;
                toaddr="";
                gstin="";
                code="";
                state="";
                date="";
                toname="";
                invno="";
                hsn="";

                t9.setText("G:\\TAX_INVOICE.pdf");
                a1.setText("entered description:\n "+descrip +
                        "\nentered weight:\n" +weight+
                        "\nentered rate:\n"+rate+
                        "\nentered total with gst:\n"+totalwithgst+
                        "\ntotal amoumt\n"+total+
                        "\nigst of the amount 3% :\n"+igst+
                        "\ngranttotal :\n"+granttotal+
                        "\n============================\n"+
                        "\n entered to address :\n"+toaddr+
                        "\n entered gstin :\n"+gstin+
                        "\n  entered code :\n"+code+
                        "\n entered state:\n"+ state+
                        "\nentered the date :\n"+ date+
                        "\n entered to name :\n " + toname+
                        "\n entered  invoice no :\n " + invno+
                        "\n entered  hsn no :\n " + hsn);

            } else if (ae.getSource()==print) {
                PdfWriter pdfWriter = null;
                try {
                    pdfWriter = new PdfWriter(path);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                PdfDocument pdfDocument = new PdfDocument(pdfWriter);
                pdfDocument.setDefaultPageSize(PageSize.A4);
                Document document = new Document(pdfDocument);
                String imgpath="G:\\lakshmi.png";
                ImageData data1= null;
                try {
                    data1 = ImageDataFactory.create(imgpath);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                Image image1=new Image(data1);

                float col1=200f;
                float col2=col1+300f;
                float col3=col1+150f;
                float colwidth[]={col1,col2,col1};
                float colwith2[]={330f ,220f};
                float colwith3[]={75f,125f,75f,75f,75f,125f};
                float colwith4[]={275f,150f,125f};
                float  colwithrup[]={550f};
                Table tablerupee;
                tablerupee = new Table(colwithrup);


                Table table= new Table(colwidth);
                Table table1=new Table(colwith2);
                Table table2=new Table(colwith3);
                Table table3=new Table(colwith4);



                table.addCell(new Cell().add(
                        "GSTIN :33AGRPR6245H1ZZ\n" +
                                "STATE :            TAMILNADU\n" +
                                "CODE :                              33").setTextAlignment(TextAlignment.LEFT).setBorderRight(Border.NO_BORDER).setBold().setFontSize(8));


                table.addCell(new Cell().add("TAX INVOICE\n" +
                                " SRI DHANALAKSHMI JEWELLERS  ").setBold().setTextAlignment(TextAlignment.CENTER).setBorderLeft(Border.NO_BORDER).setBorderRight(Border.NO_BORDER)
                        .add(new Cell().add("298/48,Malangattan Street ,Siddar Kovil MainRoad,\n" +
                                "Sivathapuram,SALEM -636 307").setFontSize(10).setTextAlignment(TextAlignment.CENTER))
                        .add(new Cell().add("PH no: 94432 33330 , 87785 69199").setFontSize(10)).setTextAlignment(TextAlignment.CENTER));



                table.addCell(new Cell().add(image1.scaleAbsolute(100,100)).setBorderLeft(Border.NO_BORDER));



                table1.addCell("TO\n" +
                        "NAME        :"+toname+
                        "\nADDRESS :"+toaddr+
                        "\nGSTIN      :"+gstin+
                        "\nSTATE :"+state+"\tCODE :"+code);
                table1.addCell(
                        "INVOICE NO :" + invno+"\n"+
                                "DATE             :"+date);


                table2.addCell(new Cell().add("S.NO").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table2.addCell(new Cell().add("DESCRIPTION OF \nGOODS").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table2.addCell(new Cell().add("HSN\\SAC").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table2.addCell(new Cell().add("WEIGHT\nin KG").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table2.addCell(new Cell().add("RATE \nper KG").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table2.addCell(new Cell().add("AMOUNT").setFontSize(10).setTextAlignment(TextAlignment.CENTER));


                table2.addCell(new Cell(0,0).add("1").setFontSize(10).setTextAlignment(TextAlignment.CENTER).setBorderBottom(Border.NO_BORDER));
                table2.addCell(new Cell(5,0).add(descrip).setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table2.addCell(new Cell(5,0).add(hsn).setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table2.addCell(new Cell(5,0).add(String.valueOf(weight)).setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table2.addCell(new Cell(5,0).add(String.valueOf(rate)).setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table2.addCell(new Cell(5,0).add(String.valueOf(total)).setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table2.addCell(new Cell().add("\n\n").setFontSize(10).setTextAlignment(TextAlignment.CENTER).setBorderBottom(Border.NO_BORDER).setBorderTop(Border.NO_BORDER));
                table2.addCell(new Cell().add("\n\n").setFontSize(10).setTextAlignment(TextAlignment.CENTER).setBorderBottom(Border.NO_BORDER).setBorderTop(Border.NO_BORDER));
                table2.addCell(new Cell().add("\n\n").setFontSize(10).setTextAlignment(TextAlignment.CENTER).setBorderBottom(Border.NO_BORDER).setBorderTop(Border.NO_BORDER));
                table2.addCell(new Cell().add("\n\n").setFontSize(10).setTextAlignment(TextAlignment.CENTER).setBorderTop(Border.NO_BORDER));



                table3.addCell(new Cell(7,0).add("OUR BANK DETAILS  :\n" +
                        "NAME :SRI DHANALAKSHMI JEWELLERS\n " +
                        "BANK NAME : STATE BANK OF INDIA\n" +
                        "BRANCH : SIVADHAPURAM BRANCH (17743)\n" +
                        "A/C No : 37061564258\n" +
                        "IFSC CODE : SBIN0017743\n").setFontSize(13).setTextAlignment(TextAlignment.LEFT));



                table3.addCell(new Cell().add("TOTAL AMOUNT :").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table3.addCell(new Cell().add(String.valueOf(total)).setFontSize(10).setTextAlignment(TextAlignment.CENTER));



                table3.addCell(new Cell().add("CGST @ 1.50%").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table3.addCell(new Cell().add(String.valueOf((float) (total*(0.015)))).setFontSize(10).setTextAlignment(TextAlignment.CENTER));

                table3.addCell(new Cell().add("SGST @ 1.50%").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table3.addCell(new Cell().add(String.valueOf((float) (total*(0.015)))).setFontSize(10).setTextAlignment(TextAlignment.CENTER));

                table3.addCell(new Cell().add("IGST @ 3.00%").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                table3.addCell(new Cell().add(String.valueOf(igst)).setFontSize(10).setTextAlignment(TextAlignment.CENTER));

                table3.addCell(new Cell().add("ROUND OFF :").setFontSize(10).setTextAlignment(TextAlignment.CENTER));
                float round = Math.round(granttotal);
                float roundoff=(Math.round(granttotal)-granttotal) ;
                table3.addCell(new Cell().add(String.valueOf( roundoff)).setFontSize(10).setTextAlignment(TextAlignment.CENTER));

                table3.addCell(new Cell().add("\n").setFontSize(10).setTextAlignment(TextAlignment.CENTER));

                table3.addCell(new Cell().add("\n").setFontSize(10).setTextAlignment(TextAlignment.CENTER));

                table3.addCell(new Cell().add("GRAND TOTAL :").setFontSize(10).setTextAlignment(TextAlignment.CENTER));


                //==================================================================================================================================






                table3.addCell(new Cell().add(String.valueOf(realnum)).setFontSize(10).setTextAlignment(TextAlignment.CENTER));



                tablerupee.addCell(new Cell().add("TOTAL AMOUNT IN RUPEES :\n"+numberinrs+"  only"));

                float clofinal[]={180f,180f,190f};
                Table tablefinal= new Table(clofinal);

                tablefinal.addCell(new Cell().add("TERMS AND CONDITIONS:\n" +
                        "1.Goods once sold cannot be accepted with our prior approval" +
                        "our responsibility ceases when goods leaves our godown\n" +
                        "2.All disputes subject to Salem jurisdiction.").setBold());
                tablefinal.addCell(new Cell().add("received the goods in good condition\n\n\n\n\n\n\n" +
                        "RECEIVER'S SIGNATURE").setTextAlignment(TextAlignment.CENTER));
                tablefinal.addCell(new Cell().add("For  SRI  DHANALAKSHMI JEWELLERS \n\n\n\n\n\n\n AUTHORISED SIGNATORY").setTextAlignment(TextAlignment.CENTER));







                document.add(table);
                document.add(table1);
                document.add(table2);
                document.add(table3);
                document.add(tablerupee);
                document.add(tablefinal);
                document.close();

            }
        }
    }
    public class Number2Words  {
        String number2words()
        {
            //Scanner in =new Scanner (System.in);
            //Input
            //System.out.println("Enter a number\n");

            return null;
        }

    }



    public static  void main(String[] args) throws FileNotFoundException {
        myframe opframe = new myframe();

    }
}
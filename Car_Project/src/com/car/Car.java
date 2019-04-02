package com.car;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.Part;

public class Car {
	private String make,model,descp,imgUrl;
	private Date dateOfPurchase;
	private Date dateOfAdded;
	private int odometer,year;
	private double price;
	boolean discount = false;
	boolean ownImage = false;
	int discountPercent = 0;
	private SimpleDateFormat dateformat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	private String fileName = "";
	private double orgPrice = 0;
	private int totalDays = 0;
    NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);

	
	public Car() {
		super();
	}

	

	public Car(String make, String model,int year,
			int odometer, double price) {
		super();
		this.make = make;
		this.model = model;
		this.odometer = odometer;
		this.price = price;
		this.year = year;
		this.imgUrl = "http://www.regcheck.org.uk/image.aspx/@" +  Base64.getEncoder().encodeToString(String.format("%s %s %s", make,model,year).getBytes());
		this.orgPrice = price;
	}
	
	
	public int totalDays() {
		//return new Date(checkOutDate.getTime() - checkInDate.getTime());
		Date date = new Date();
		long diffDays = (date.getTime() - dateOfAdded.getTime() )/ (1000 * 60 * 60 * 24);
		this.totalDays =  Integer.parseInt(Long.toString(diffDays));
		return totalDays;

	}


	public void discountPrice(int min) {
		System.out.println(totalDays());
		if(totalDays() >= 120) {
			this.discount = true;
			
			if(min <= 10) {
				Random r = new Random();
				this.discountPercent = r.nextInt((10 - min) + 1) + min;
				this.price *= 1 - (discountPercent/100.00);		
			}
		}
	}

	public String getDateByFormat(Date date) {
		try{
			return dateformat.format(date);

		}catch(Exception e) {
			return "null";
		}
	}
	
	public void saveImage(File uploads,String fileName,Part filePart) {
		String carName = this.make.replaceAll("\\s+","")+"-"+this.model.replaceAll("\\s+","")+this.year;
		this.ownImage = true;
		this.fileName = carName+"-"+fileName;
		File file = new File(uploads, this.fileName);
    	try {
        	InputStream fileContent = filePart.getInputStream();
			
            OutputStream out = new FileOutputStream(file);
            
            
            byte[] buf = new byte[1024];
            int len;
            while ((len = fileContent.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            fileContent.close();
            out.close();
			
	    	//Files.copy(fileContent, file.toPath());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	//filePart.write(path+seller.getFirstName()+"-"+seller.getLastName()+"-"+fileName);
    	this.setImgUrl("/images/"+this.fileName);
	}
	
	
	public String getFormatOdo() {
		DecimalFormat formatter = new DecimalFormat("#,###");
		return formatter.format(this.odometer);
	}
	
	public double getOrgPrice() {
		return orgPrice;
	}



	public int getTotalDays() {
		return totalDays;
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public boolean isOwnImage() {
		return ownImage;
	}



	public void setOwnImage(boolean ownImage) {
		this.ownImage = ownImage;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getDescp() {
		return descp;
	}


	public void setDescp(String descp) {
		this.descp = descp;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}


	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}


	public String getDateOfAdded() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(dateOfAdded);
	}


	public void setDateOfAdded(Date dateOfAdded) {
		this.dateOfAdded = dateOfAdded;
	}


	public int getOdometer() {
		return odometer;
	}


	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}





	public double getPrice() {
		return price;
	}
	
	public String getOrgPriceFormat() {
		return us.format(orgPrice);
	}
	
	
	public String getPriceFormat() {
        return us.format(price);
	}


	public void setPrice(double price) {
		this.orgPrice = price;
		this.price = price;
	}


	




	public boolean isDiscount() {
		return discount;
	}



	public void setDiscount(boolean discount) {
		this.discount = discount;
	}



	public int getDiscountPercent() {
		return discountPercent;
	}



	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getFormatCarName() {
		System.out.println(String.format("%s-%s-%d-%d", make,model,year,odometer));
		return String.format("%s-%s-%d-%d", make,model,year,odometer).replaceAll("\\s+","");
	}


	public String formatData() {
		return String.format("%s,%s,%s,%s,%s,%s,%d,%d,%.2f",make,model,descp,imgUrl,getDateByFormat(dateOfPurchase),getDateByFormat(dateOfAdded),odometer,year,price);
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", descp=" + descp + ", imgUrl=" + imgUrl
				+ ", dateOfPurchase=" + dateOfPurchase + ", dateOfAdded=" + dateOfAdded + ", odometer=" + odometer
				+ ", year=" + year + ", price=" + price + "]";
	}




	



	
	
	
	
	
	
}

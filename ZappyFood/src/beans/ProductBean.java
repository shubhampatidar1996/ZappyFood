package beans;

public class ProductBean {
String category,productname,productprice,description,filename;
int pid;
String name,emailid,password,address;
String quantity,image;
String user;

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public int getPid() {
	return pid;
}

public String getQuantity() {
	return quantity;
}

public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public void setPid(int pid) {
	this.pid = pid;
}

public String getCategory() {
	return category;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmailid() {
	return emailid;
}

public void setEmailid(String emailid) {
	this.emailid = emailid;
}

public String getPassowrd() {
	return password;
}

public void setPassowrd(String passowrd) {
	this.password = passowrd;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public void setCategory(String category) {
	this.category = category;
}

public String getProductname() {
	return productname;
}

public void setProductname(String productname) {
	this.productname = productname;
}

public String getProductprice() {
	return productprice;
}

public void setProductprice(String productprice) {
	this.productprice = productprice;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getFilename() {
	return filename;
}

public void setFilename(String filename) {
	this.filename = filename;
}
}
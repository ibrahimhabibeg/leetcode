class Main{
  public static void main(String[] args) {
    
  }
  public String defangIPaddr(String address) {
    return address.replace(".", "[.]");
  }
}
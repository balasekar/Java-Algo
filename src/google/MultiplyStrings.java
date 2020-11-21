package google;

public class MultiplyStrings {

        private String multiply(String num1, String num2) {
            int m = num1.length();
            int n = num2.length();
            int[] product = new int[m+n];

            for(int i=m-1; i>=0; i--) {
                for(int j=n-1; j>=0; j--) {
                    int d1 = num1.charAt(i) - '0';
                    int d2 = num2.charAt(j) - '0';
                    product[i+j+1] += d1*d2;
                }
            }

            int carry =0;
            for(int i=product.length-1; i>=0; i--) {
                int temp = (product[i]+carry) % 10;
                carry = (product[i]+carry) / 10;
                product[i] = temp;
            }

            StringBuilder sb = new StringBuilder();
            for(int i : product) sb.append(i);

            while(sb.length()>0 && sb.charAt(0)=='0') sb.deleteCharAt(0);
            return sb.length()==0?"0" : sb.toString();
        }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println("Mutliply 123 * 456 = "+ms.multiply("123", "456"));
        System.out.println("Mutliply 123456789 * 4567891011 = "+ms.multiply("123456789", "4567891011"));

    }
}

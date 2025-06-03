import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

class VaultDoor7 {
    public static void main(String args[]) {
        VaultDoor7 vaultDoor = new VaultDoor7();
/*        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vault password: ");
        String userInput = scanner.next();
	String input = userInput.substring("picoCTF".length(),userInput.length()-1);
	if (vaultDoor.checkPassword(input)) {
	    System.out.println("Access granted.");
	} else {
	    System.out.println("Access denied!");
        }*/
        int[] x = {1096770097,
            1952395366,
            1600270708,
            1601398833,
            1716808014,
            1734293296,
            842413104,
            1684157793};
	
	for (int i = 0; i < x.length; i++){
		binTo4char(toBin(x[i]).getBytes());
	}
	
    }
	public static String toBin(int X){
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < 32; i++){	
			result.append((char)((X%2)+48));
			X /= 2;
		}

		return result.toString();
	}
	public static void binTo4char(byte[] X){
		int x = 0;
		for(int j = 3; j >= 0; j--){
			x = 0;
			for(int i = 7; i >= 0; i--){
				//System.out.print((char)X[(j*8)+i]);
				x *= 2;
				if((X[(j*8)+i]) == 49)x++;
			}
			//System.out.println("   ||   " + (char)x);
			System.out.print((char)x);
		}
	}

    public int[] passwordToIntArray(String hex) {
        int[] x = new int[8];
        byte[] hexBytes = hex.getBytes();
        for (int i=0; i<8; i++) {
            x[i] = hexBytes[i*4]   << 24
                 | hexBytes[i*4+1] << 16
                 | hexBytes[i*4+2] << 8
                 | hexBytes[i*4+3];
        }
        return x;
    }

    public boolean checkPassword(String password) {
        if (password.length() != 32) {
            return false;
        }
        int[] x = passwordToIntArray(password);
        return x[0] == 1096770097
            && x[1] == 1952395366
            && x[2] == 1600270708
            && x[3] == 1601398833
            && x[4] == 1716808014
            && x[5] == 1734293296
            && x[6] == 842413104
            && x[7] == 1684157793;
    }
}

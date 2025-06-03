import java.net.URLDecoder;
import java.util.*;

class VaultDoor5 {
    public static void main(String args[]) {
        VaultDoor5 vaultDoor = new VaultDoor5();
        Scanner scanner = new Scanner(System.in);
        //System.out.print("Enter vault password: ");
        //String userInput = scanner.next();
        String input = "JTYzJTMwJTZlJTc2JTMzJTcyJTc0JTMxJTZlJTY3JTVm"
                        + "JTY2JTcyJTMwJTZkJTVmJTYyJTYxJTM1JTY1JTVmJTM2"
                        + "JTM0JTVmJTMwJTYyJTM5JTM1JTM3JTYzJTM0JTY2";
	//String input = "0123456789";
	byte[] base64decode = Base64.getDecoder().decode(input);	//base64 decode
	//String base64Decode = new String(base64decode);
	//System.out.println(base64Decode);
	int [] toDecimal = new int[100];
	for(int i = 0; i < base64decode.length; i += 3){
		toDecimal[i/3] = hexadecimalToDecimal((char)base64decode[i+1])*16 + hexadecimalToDecimal((char)base64decode[i+2]);
		System.out.print((char)toDecimal[i/3]);
	}
	
	/*if (vaultDoor.checkPassword(input)) {
	    System.out.println("Access granted.");
	} else {
	    System.out.println("Access denied!");
        }*/
    }
	public static int hexadecimalToDecimal(char x){
		char[] X = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		for(int i = 0; i < 16; i++){
			if(x == X[i]) return i;
		}
		return 0;
	}

    // Minion #7781 used base 8 and base 16, but this is base 64, which is
    // like... eight times stronger, right? Riiigghtt? Well that's what my twin
    // brother Minion #2415 says, anyway.
    //
    // -Minion #2414
    public String base64Encode(byte[] input) {
        return Base64.getEncoder().encodeToString(input);
    }

    // URL encoding is meant for web pages, so any double agent spies who steal
    // our source code will think this is a web site or something, defintely not
    // vault door! Oh wait, should I have not said that in a source code
    // comment?
    //
    // -Minion #2415
    public static String urlEncode(byte[] input) {
        StringBuffer buf = new StringBuffer();
        for (int i=0; i<input.length; i++) {
            buf.append(String.format("%%%2x", input[i]));	//jadi hexadecimal
        }
        return buf.toString();
    }

    public boolean checkPassword(String password) {
        String urlEncoded = urlEncode(password.getBytes());		//jadiin dulu hexadecimal
        String base64Encoded = base64Encode(urlEncoded.getBytes());	//diencode ke base 64
        String expected = "JTYzJTMwJTZlJTc2JTMzJTcyJTc0JTMxJTZlJTY3JTVm" //kunci seharusnya
                        + "JTY2JTcyJTMwJTZkJTVmJTYyJTYxJTM1JTY1JTVmJTM2"
                        + "JTM0JTVmJTMwJTYyJTM5JTM1JTM3JTYzJTM0JTY2";
        return base64Encoded.equals(expected);				//evaluasi
    }
	//BERARTI: decode base64 -> hexadecimal to decimal -> cast ke karakter
}

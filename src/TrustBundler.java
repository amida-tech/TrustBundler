import org.nhindirect.trustbundle.core.CreateSignedPKCS7;
import org.nhindirect.trustbundle.core.CreateUnSignedPKCS7;

public class TrustBundler {

	public static void main(String[] args) {
		String anchorDir = null;
		String metaDataFile = "Select Meta Data File";
		String destDir = null;
		String bundleName = null;
		String certificateFile = null;
		String passkey = "";
		
		int index = 0;
		int positionalIndex = 0;
		
		while (index < args.length) {
			String arg = args[index];
			if (arg.startsWith("-")) {
				++index;
				if ((index == args.length) || (arg.length() < 2)) {
					System.out.println("Invalid arguments.");
					return;					
				}
				char ch = arg.charAt(1);
				if (ch == 'm') {
					metaDataFile = args[index];
				} else if (ch == 'c') {
					certificateFile = args[index];
				}  else if (ch == 'p') {
					passkey = args[index];
				} else {
					System.out.println("Invalid arguments.");
					return;					
				}
			} else {
				switch (positionalIndex) {
				case 0:
					anchorDir = arg;
					break;
				case 1:
					destDir = arg;
					break;
				case 2:
					bundleName = arg;
					break;
				default:
					System.out.println("Invalid arguments.");
					return;
				}
				++positionalIndex;
			}
			++index;
		}
		
		if ((anchorDir == null) || (destDir == null) || (bundleName == null)) {
			System.out.println("Invalid arguments.");
			return;			
		}
		
		if (certificateFile == null) {
			CreateUnSignedPKCS7 r = new CreateUnSignedPKCS7();
			String result = r.getParameters(anchorDir, metaDataFile, destDir, bundleName);
			System.out.println(result);
		} else {
			CreateSignedPKCS7 r= new CreateSignedPKCS7();
			String result = r.getParameters(anchorDir, metaDataFile, certificateFile, passkey, destDir, bundleName);
			System.out.println(result);
		}
	}
}
